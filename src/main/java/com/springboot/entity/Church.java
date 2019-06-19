package com.springboot.entity;

import java.util.Date;

/**
 * 教会信息类
 * JaminHuang   2019年6月19日 13:36:43
 */
public class Church {
    /**
     * 教会/团契标识
     */
    private String ChurchId;
    /**
     * 教会/团契名称
     */
    private String ChurChName;
    /**
     * Logo地址
     */
    private String Logo;
    /**
     * 最后更新时间
     */
    private Date UpdateTime;

    public String getChurchId() {
        return ChurchId;
    }

    public void setChurchId(String churchId) {
        ChurchId = churchId;
    }

    public String getChurChName() {
        return ChurChName;
    }

    public void setChurChName(String churChName) {
        ChurChName = churChName;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public Date getUpdateTime() {
        return UpdateTime;
    }

    public void setUpdateTime(Date updateTime) {
        UpdateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Church{" +
                "ChurchId='" + ChurchId + '\'' +
                ", ChurChName='" + ChurChName + '\'' +
                ", Logo='" + Logo + '\'' +
                ", UpdateTime=" + UpdateTime +
                '}';
    }
}