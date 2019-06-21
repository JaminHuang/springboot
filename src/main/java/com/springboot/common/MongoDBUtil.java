package com.springboot.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDBUtil {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoDBUtil(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
