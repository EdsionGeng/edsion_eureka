package com.wsd.entity;

public class UserTime {
    private int id;
    private String user_id;//用户ID
    private int time;//游戏次数
    private int share;//有无分享

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public UserTime(int id, String user_id, int time) {
        this.id = id;
        this.user_id = user_id;
        this.time = time;
    }
    public UserTime() {

    }
    public int getShare() {
        return share;
    }

    public void setShare(int add) {
        this.share = add;
    }

    public UserTime(String user_id, int time, int share) {
        this.user_id = user_id;
        this.time = time;
        this.share = share;
    }
}
