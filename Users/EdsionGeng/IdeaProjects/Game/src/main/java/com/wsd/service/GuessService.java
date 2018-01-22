package com.wsd.service;


import java.util.Map;

public interface GuessService {
	Map<String,Object> gameService(String guess_content, String user_id, int guess_coin);// 玩游戏结果
//    Map<String,Integer> lastGuess(String user_id, int guess_coin, String guess_content);// 最后一次游戏
	//List<PointRecord> selectPointListByUserId(String user_id);//查看用户中奖情况



}
