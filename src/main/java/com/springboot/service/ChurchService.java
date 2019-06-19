package com.springboot.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.common.MongoDbUtil;
import com.springboot.common.RedisUtil;
import com.springboot.dao.ChurchDao;
import com.springboot.entity.Church;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChurchService implements ChurchDao {

    @Autowired
    private ChurchDao churchDao;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 获取指定团契信息
     * @param churchId 团契标识
     * @return 团契信息
     */
    public Church get(String churchId) {
        String key = "churchId";
        Church church;
        if(redisUtil.exists(key)) {
            church = JSON.parseObject(redisUtil.get(key, 1), Church.class);
            return church;
        }
        else {
            church = churchDao.get(churchId);
            redisUtil.set(key, JSON.toJSONString(church), 1);
            return church;
        }
    }

    /**
     * 获取教团契列表
     * @return 团契列表
     */
    public List<Church> list() {
        List<Church> list = churchDao.list();
        return list;
    }

    /**
     * 分页获取团契列表
     * @param page 当前页
     * @param pageSize 每页显示数
     * @return 团契列表
     */
    public PageInfo<Church> list(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Church> list = churchDao.list();
        return new PageInfo<>(list);
    }


}
