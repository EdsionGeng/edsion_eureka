package com.wsd.service.impl;

import com.wsd.entity.UserTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsd.dao.PointMapper;
import com.wsd.dao.UserTimeMapper;
import com.wsd.dao.UserWealthMapper;
import com.wsd.entity.PointRecord;
import com.wsd.service.GuessService;
import com.wsd.util.DateUtil;
import com.wsd.util.GuessUtil;
import java.util.HashMap;
import java.util.Map;

@Service("guessService")
public class GuessServiceImpl implements GuessService {

	@Autowired
	private PointMapper pointMapper;
	@Autowired
	private UserTimeMapper userTimeMapper;
	@Autowired
	private UserWealthMapper userWealthMapper;

	public Map<String, Object> gameService(String guess_content, String user_id, int guess_coin) {
		// TODO Auto-generated method stub
		userTimeMapper.updateFrequency(user_id);
		int win_coin = 0;
		int result = 0;
		if (guess_content.equals("small")) {
		String 	system_content = new GuessUtil().gameRunSmall();
			if (guess_content.equals(system_content)) {
				result = 1;
				win_coin = (int) (guess_coin * 1.7);
				PointRecord po = new PointRecord(user_id, 1, new DateUtil().refFormatNowDate(), guess_content,
						system_content, guess_coin, win_coin);
				pointMapper.insertPointRecord(po);
              int userID=Integer.parseInt(user_id);
				Map<String, Object> maps = new HashMap();
				maps.put("fUid", userID);
				maps.put("fJclx", 1);
				maps.put("cBdsm", "猜猜猜游戏中奖");
				maps.put("fBdjf", win_coin);
				maps.put("cCategoryNumber", 8007);
				maps.put("fRelatedId", 0);
				maps.put("cRelatedId2", "");
				maps.put("fComeFrom", 1);
				userWealthMapper.insertUserCoin(maps);
                UserTime ut=userTimeMapper.selectFrequency(user_id);
                Map<String, Object> maplist = new HashMap();
                maplist.put("result", result);
                maplist.put("win_coin", win_coin);
                maplist.put("frequency",ut.getTime());
                maplist.put("share",ut.getShare());
                return maplist;
			} else {
				result = 0;
				PointRecord po = new PointRecord(user_id, 0, new DateUtil().refFormatNowDate(), guess_content,
						system_content, guess_coin, 0);
				pointMapper.insertPointRecord(po);
				Map<String, Object> map = new HashMap();
                int userID=Integer.parseInt(user_id);
				map.put("fUid", userID);
				map.put("fJclx", 2);
				map.put("cBdsm", "猜猜猜游戏减掉用户押注金额");
				map.put("fBdjf", guess_coin);
				map.put("cCategoryNumber", 8007);
				map.put("fRelatedId", 0);
				map.put("cRelatedId2", "");
				map.put("fComeFrom", 1);
               userWealthMapper.insertUserCoin(map);
                UserTime ut=userTimeMapper.selectFrequency(user_id);
                Map<String, Object> maplist = new HashMap();
                maplist.put("result", result);
                maplist.put("win_coin", win_coin);
                maplist.put("frequency",ut.getTime());
				maplist.put("share",ut.getShare());
                return maplist;
}
		} else if (guess_content.equals("big")) {
		String	system_content =new GuessUtil().gameRunBig();
			if (guess_content.equals(system_content)) {
				result = 1;
				win_coin = (int) (guess_coin * 1.7);
				PointRecord po = new PointRecord(user_id, 1, new DateUtil().refFormatNowDate(), guess_content,
						system_content, guess_coin, win_coin);
				 pointMapper.insertPointRecord(po);
				Map<String, Object> maps = new HashMap();
                int userID=Integer.parseInt(user_id);
                maps.put("fUid", userID);
				maps.put("fJclx", 1);
				maps.put("cBdsm", "猜猜猜游戏中奖");
				maps.put("fBdjf", win_coin);
				maps.put("cCategoryNumber", 8007);
				maps.put("fRelatedId", 0);
				maps.put("cRelatedId2", "");
				maps.put("fComeFrom", 1);
                userWealthMapper.insertUserCoin(maps);
                UserTime ut=userTimeMapper.selectFrequency(user_id);
                Map<String, Object> maplist = new HashMap();
                maplist.put("result", result);
                maplist.put("win_coin", win_coin);
                maplist.put("frequency",ut.getTime());
                maplist.put("share",ut.getShare());
                return maplist;
			} else {
				result = 0;
				PointRecord po = new PointRecord(user_id, 0, new DateUtil().refFormatNowDate(), guess_content,
                system_content, guess_coin, 0);
				pointMapper.insertPointRecord(po);
				Map<String, Object> map = new HashMap();
                int userID=Integer.parseInt(user_id);
                map.put("fUid", userID);
				map.put("fUid", user_id);
				map.put("fJclx", 2);
				map.put("cBdsm", "猜猜猜游戏减掉用户押注金额");
				map.put("fBdjf", guess_coin);
				map.put("cCategoryNumber", 8007);
				map.put("fRelatedId", 0);
				map.put("cRelatedId2", "");
				map.put("fComeFrom", 1);
                userWealthMapper.insertUserCoin(map);
                UserTime ut=userTimeMapper.selectFrequency(user_id);
                Map<String, Object> maplist = new HashMap();
                maplist.put("result", result);
                maplist.put("win_coin", win_coin);
                maplist.put("frequency",ut.getTime());
                maplist.put("share",ut.getShare());
                return maplist;
			}
		} else if (guess_content.equals("fu")) {

			String 	system_content =new GuessUtil().gameRunFu();
			if (guess_content.equals(system_content)) {
				result = 1;
				win_coin = guess_coin * 3;
				PointRecord po = new PointRecord(user_id, 1, new DateUtil().refFormatNowDate(), guess_content,
						system_content, guess_coin, win_coin);
				pointMapper.insertPointRecord(po);
				Map<String, Object> maps = new HashMap();
                int userID=Integer.parseInt(user_id);
                maps.put("fUid", userID);
				maps.put("fJclx", 1);
				maps.put("cBdsm", "猜猜猜游戏中奖");
				maps.put("fBdjf", win_coin);
				maps.put("cCategoryNumber", 8007);
				maps.put("fRelatedId", 0);
				maps.put("cRelatedId2", "");
				maps.put("fComeFrom", 1);
                userWealthMapper.insertUserCoin(maps);
                UserTime ut=userTimeMapper.selectFrequency(user_id);
                Map<String, Object> maplist = new HashMap();
                maplist.put("result", result);
                maplist.put("win_coin", win_coin);
                maplist.put("frequency",ut.getTime());
				maplist.put("share",ut.getShare());
                return maplist;
			} else {
				result = 0;
				PointRecord po = new PointRecord(user_id, 0, new DateUtil().refFormatNowDate(), guess_content,
						system_content, guess_coin, 0);
				pointMapper.insertPointRecord(po);
				Map<String, Object> map = new HashMap();
                int userID=Integer.parseInt(user_id);
                map.put("fUid", userID);
				map.put("fJclx", 2);
				map.put("cBdsm", "猜猜猜游戏减掉用户押注金额");
				map.put("fBdjf", guess_coin);
				map.put("cCategoryNumber", 8007);
				map.put("fRelatedId", 0);
				map.put("cRelatedId2", "");
				map.put("fComeFrom", 1);
                userWealthMapper.insertUserCoin(map);
                UserTime ut=userTimeMapper.selectFrequency(user_id);
                Map<String, Object> maplist = new HashMap();
                maplist.put("result", result);
                maplist.put("win_coin", win_coin);
                maplist.put("frequency",ut.getTime());
				maplist.put("share",ut.getShare());
                return maplist;
                }
		}
        UserTime ut=userTimeMapper.selectFrequency(user_id);
		Map<String, Object> maps = new HashMap();
		maps.put("result", result);
		maps.put("win_coin", win_coin);
        maps.put("frequency",ut.getTime());
		maps.put("share",ut.getShare());;
		return maps;
	}



}
