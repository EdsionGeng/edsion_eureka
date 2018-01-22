package com.wsd.controller;

import com.wsd.cache.Cache;
import com.wsd.cache.CacheManager;
import com.wsd.util.AESUtil;
import com.wsd.util.JsoupUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wsd.entity.PointRecord;
import com.wsd.entity.UserTime;
import com.wsd.service.GuessService;
import com.wsd.service.UserTimeService;
import com.wsd.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author EdsionGeng
 * @Describtion
 * @Date Created in
 * 温商贷
 * 猜猜猜游戏
 */
@Controller
@RequestMapping("guess")
public class GuessController {
    @Autowired
    private GuessService guessService;
    @Autowired
    private UserTimeService userTimeService;
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    /**
     * 执行玩游戏
     *
     * @param guess_content
     * @param coin
     * @param userid
     * @param req
     * @param rep
     * @return
     */
    @RequestMapping("/game/play")
    @ResponseBody
    public synchronized JsonResult playGame(String guess_content, String coin, String userid, HttpServletRequest req, HttpServletResponse rep) {
        JsoupUtil.SetHttpServletResponse(rep);
        try {
            req.setCharacterEncoding("utf-8");
            rep.setContentType("text/html;charset=utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (guess_content == null || coin == null || userid == null) {
            return new JsonResult(1, "", "请登录");
        }
        String str = cacheExist(userid);
        if (str.equals("full")) {
            return new JsonResult(2, 0, "网络延时，请稍后加载");
        }
        int fUid = 0;
        try {
            fUid = AESUtil.GetUid(userid);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(2, "", "userid异常");
        }
        if (fUid == 0) {
            return new JsonResult(1, "", "请登录");
        }
        Integer usercoin = userTimeService.selectCoinByUser(fUid);
        if (usercoin == null) {
            return new JsonResult(2, "", "userid异常");
        }
        int guess_coin = Integer.parseInt(coin);
        if (guess_coin > usercoin) {
            return new JsonResult(2, "", "您的押注超过财币余额");
        }
        String uuserid = String.valueOf(fUid);
        PointRecord pointRecord = new PointRecord(guess_content, guess_coin);
        UserTime uti = userTimeService.selectTimeByUserId(uuserid);
        if (uti.getTime() <= 0) {
            //new JsonResult
            Map<String, Object> m = new HashMap<>();
            String win_coin = null;
            int result = 0;
            m.put("win_coin", win_coin);
            m.put("frequency", uti.getTime());
            m.put("result", result);
            m.put("share", uti.getShare());
            return new JsonResult(0, m, "您的次数已用完");
        }
        Map<String, Object> map = guessService.gameService(pointRecord.getGuess_content(), uuserid, pointRecord.getGuess_coin());
        return new JsonResult(0, map, "您的游戏结果是");
    }

    //分享加三次玩游戲 次数
    @RequestMapping("/game/share")
    @ResponseBody
    public synchronized JsonResult addFrequencyByShare(HttpServletRequest req, HttpServletResponse rep) {
        JsoupUtil.SetHttpServletResponse(rep);
        String userid = req.getParameter("userid");
        int fUid = 0;
        try {
            fUid = AESUtil.GetUid(userid);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(2, "", "userid异常");
        }
        if (userid == null || fUid == 0) {
            return new JsonResult(1, "", "请登录");
        }
//        try {
//            req.setCharacterEncoding("utf-8");
//            rep.setContentType("text/html;charset=utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String user_id = String.valueOf(fUid);
        UserTime us = userTimeService.selectTimeByUserId(user_id);
        if (us.getShare() == 1) {
            Map<String, Object> map = new HashMap<>();
            String win_coin = null;
            int result = 0;
            map.put("win_coin", win_coin);
            map.put("frequency", us.getTime());
            map.put("result", result);
            map.put("share", us.getShare());
            return new JsonResult(0, map, "每天只能分享一次!");
        } else {
            if (userTimeService.updateFrequencyByShare(user_id) != null) {
                Map<String, Object> map = new HashMap<>();
                String win_coin = null;
                int result = 0;
                UserTime usertime = userTimeService.selectTimeByUserId(user_id);
                map.put("win_coin", win_coin);
                map.put("frequency", usertime.getTime());
                map.put("result", result);
                map.put("share", usertime.getShare());
                return new JsonResult(0, map, "分享成功");
            }
        }
        return new JsonResult(2, "", "异常");
    }

    @RequestMapping("/new/player")
    @ResponseBody
    public synchronized JsonResult newPlay(HttpServletResponse rep, HttpServletRequest req) {
        JsoupUtil.SetHttpServletResponse(rep);
//        try {
//            req.setCharacterEncoding("utf-8");
//            rep.setContentType("text/html;charset=utf_8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String user_id = req.getParameter("userid");
        if (user_id == null) {
            return new JsonResult(1, "", "请登录");
        }
        int fUid = 0;
        try {
            fUid = AESUtil.GetUid(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(2, "", "userid异常");
        }
        if (fUid == 0) {
            return new JsonResult(1, "", "请登录");
        }
        String userid = String.valueOf(fUid);
        UserTime userTime = userTimeService.selectTimeByUserId(userid);
        if (userTime != null) {
            Map<String, Object> map = new HashMap<String, Object>();
            int result = 0;
            int win_coin = 0;
            UserTime ut = userTimeService.selectTimeByUserId(userid);
            map.put("result", result);
            map.put("win_coin", win_coin);
            map.put("frequency", ut.getTime());
            map.put("share", ut.getShare());
            return new JsonResult(0, map, "已经是游戏玩家，不能再加次数");
        }
        UserTime ut = new UserTime(userid, 10, 0);
        userTimeService.insertUserTime(ut);
        Map<String, Object> map = new HashMap<>();
        UserTime us = userTimeService.selectTimeByUserId(userid);
        int win_coin = 0;
        int result = 0;
        map.put("frequency", us.getTime());
        map.put("win_coin", win_coin);
        map.put("result", result);
        map.put("share", us.getShare());
        return new JsonResult(0, map, "今日游戏次数");
    }
    public String cacheExist(String user_id) {
        String key = user_id;
        Cache cache = CacheManager.getCacheInfo(key);
        if (null == cache || cache.getValue() == null) {
            cache = new Cache();
            cache.setKey(key);
            cache.setValue(1);
            CacheManager.putCache(key, cache);
            return "empty";
        } else {
            return "full";
        }
    }
}
