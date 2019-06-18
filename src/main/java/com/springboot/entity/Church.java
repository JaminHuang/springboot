package com.springboot.entity;

import java.util.Date;

public class Church {
    private String churchid;

    private String churchname;

    private String logo;

    private Date updatetime;

    public String getChurchid() {
        return churchid;
    }

    public void setChurchid(String churchid) {
        this.churchid = churchid == null ? null : churchid.trim();
    }

    public String getChurchname() {
        return churchname;
    }

    public void setChurchname(String churchname) {
        this.churchname = churchname == null ? null : churchname.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}