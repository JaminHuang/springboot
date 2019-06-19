package com.springboot.common;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@SuppressWarnings("deprecation")
public class MongoDbUtil {

    @Value("%{spring.data.mongodb.host}")
    private static String host;

    @Value("%{spring.data.mongodb.database}")
    private static String database;

    @Value("%{spring.data.mongodb.port}")
    private static String port;

    private static Mongo mongo;

    private static DB db;

    static {
        try {
            mongo = new Mongo(host + ":" + port);
            db = mongo.getDB(database);
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    private MongoDbUtil() {
    }

}
