package com.wsd.service.impl;
import com.wsd.dao.UserCoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.dao.UserTimeMapper;
import com.wsd.entity.UserTime;
import com.wsd.service.UserTimeService;
@Service("userTimeService")
public class UserTimeServiceImpl implements UserTimeService {
    @Autowired
    private UserTimeMapper userTimeMapper;

    @Autowired
    private UserCoinMapper userCoinMapper;

    public Integer updateFrequencyByShare(String user_id) {
        // TODO Auto-generated method stub
        return userTimeMapper.updateFrequencyByShare(user_id);
    }

    public UserTime selectTimeByUserId(String user_id) {
        UserTime userTime = userTimeMapper.selectFrequency(user_id);
        return userTime;
    }

    public Integer insertUserTime(UserTime userTime) {
        return userTimeMapper.insertTime(userTime);
    }

    public Integer selectCoinByUser(Integer id) {
        return userCoinMapper.selectCoinByUser(id);
    }
}
