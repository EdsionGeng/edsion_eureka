package com.wsd.service;

import com.wsd.entity.UserTime;

public interface UserTimeService {
    Integer updateFrequencyByShare(String user_id);

    UserTime selectTimeByUserId(String user_id);

    Integer insertUserTime(UserTime userTime);

    Integer selectCoinByUser(Integer id);
}
