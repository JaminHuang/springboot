package com.springboot.dao;

import com.springboot.entity.Church;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChurchDao {

    /**
     * 获取指定教会/团契信息
     * @param churchId 教会/团契标识
     * @return 教会/团契对象
     */
    @Select("SELECT * FROM Church WHERE ChurchId = #{churchId}")
    Church get(String churchId);

    /**
     * 获取教会/团契列表
     * @return 教会/团契列表
     */
    @Select("SELECT * FROM Church")
    List<Church> list();
}
