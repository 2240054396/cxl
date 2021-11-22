package com.zlt.entity;

import java.util.Date;

public class Customerlog {
    private Long clid;

    private Long cid;

    private Long uid;

    private String content;

    private Date starttime;

    private Date endtime;

    public Long getClid() {
        return clid;
    }

    public void setClid(Long clid) {
        this.clid = clid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}