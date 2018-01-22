package com.wsd.entity;

public class PointRecord {
    private int id;
    private String user_id;// 用户ID
    private int prize;//是否中奖
    private String play_time;//玩游戏当前时间
    private String guess_content;//用户所猜
    private String system_content;//系统开奖内容；
    private int guess_coin;//用户下注金币
    private int win_coin;//此次游戏赚的

    public int getWin_coin() {
        return win_coin;
    }

    public void setWin_coin(int win_coin) {
        this.win_coin = win_coin;
    }

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

    public String getPlay_time() {
        return play_time;
    }

    public void setPlay_time(String play_time) {
        this.play_time = play_time;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getGuess_content() {
        return guess_content;
    }

    public void setGuess_content(String guess_content) {
        this.guess_content = guess_content;
    }

    public String getSystem_content() {
        return system_content;
    }

    public void setSystem_content(String system_content) {
        this.system_content = system_content;
    }

    public PointRecord() {
    }

    public PointRecord(String user_id, int prize, String play_time,
                       String guess_content, String system_content, int guess_coin, int win_coin) {
        this.user_id = user_id;
        this.prize = prize;
        this.play_time = play_time;
        this.guess_content = guess_content;
        this.system_content = system_content;
        this.guess_coin = guess_coin;
        this.win_coin = win_coin;
    }

    public PointRecord(String guess_content, int guess_coin) {

        this.guess_content = guess_content;
        this.guess_coin = guess_coin;
    }

    public int getGuess_coin() {
        return guess_coin;
    }

    public void setGuess_coin(int guess_coin) {
        this.guess_coin = guess_coin;
    }


}
