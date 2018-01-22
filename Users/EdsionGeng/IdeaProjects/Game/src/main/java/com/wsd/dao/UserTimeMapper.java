package com.wsd.dao;

import org.apache.ibatis.annotations.Param;
import com.wsd.entity.UserTime;

import javax.xml.registry.infomodel.User;
import java.util.List;

public interface UserTimeMapper {
	Integer  updateFrequencyByShare(@Param("user_id") String user_id);//分享加可玩次数
	UserTime selectFrequency(@Param("user_id") String user_id);//查询剩余游戏次数
	Integer updateFrequency(@Param("user_id") String user_id);//更改次数，设一个触发函数
	Integer insertTime(UserTime userTime);//添加游戏次数

}
