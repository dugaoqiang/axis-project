package com.cmsz.services;

import com.alibaba.fastjson.JSON;
import com.cmsz.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dgq on 2018/11/29.
 */
public class LoginSwitchService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String REST_API = HttpUtil.getConfig();

    public String loginModChg(String flag) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/loginModChg", "POST", flag);
        return JSON.toJSONString(jsonString);
    }


}
