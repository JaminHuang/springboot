package com.springboot.service.impl;

import com.springboot.entity.Church;
import com.springboot.mapper.ChurchMapper;
import com.springboot.service.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "churchService")
public class ChurchServiceImpl implements ChurchService {

    @Autowired
    private ChurchMapper churchMapper;

    public Church getChurch(String churchId) {
        return churchMapper.getChurch(churchId);
    }
}
