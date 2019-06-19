package com.springboot.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.common.RedisUtil;
import com.springboot.dao.ChurchDao;
import com.springboot.entity.Church;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurchService implements ChurchDao {

    @Autowired
    private ChurchDao churchDao;

    @Autowired
    RedisUtil redisUtil;

    /**
     * 获取指定教会/团契信息
     * @param churchId 教会标识
     * @return 教会/团契信息
     */
    public Church get(String churchId) {
        String key = "churchId";

        if(redisUtil.exists(key)) {
            Church church = JSON.parseObject(redisUtil.get(key, 1), Church.class);
            return church;
        }
        else {
            Church church = churchDao.get(churchId);
            redisUtil.set(key, JSON.toJSONString(church), 1);
            return church;
        }
    }

    /**
     * 获取教会/团契列表
     * @return 教会/团契列表
     */
    public List<Church> list() {
        return churchDao.list();
    }

    /**
     * 分页获取教会/团契列表
     * @param page 当前页
     * @param pageSize 每页显示数
     * @return 教会/团契列表
     */
    public PageInfo<Church> list(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Church> list = churchDao.list();
        return new PageInfo<>(list);
    }
}
