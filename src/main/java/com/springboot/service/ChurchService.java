package com.springboot.service;

import com.springboot.dao.ChurchDao;
import com.springboot.entity.Church;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChurchService implements ChurchDao {

    @Autowired
    private ChurchDao churchDao;

    /**
     * 获取指定教会/团契信息
     * @param churchId 教会标识
     * @return 教会/团契信息
     */
    public Church get(String churchId) {
        return churchDao.get(churchId);
    }
}
