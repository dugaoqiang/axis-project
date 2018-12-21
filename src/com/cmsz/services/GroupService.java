package com.cmsz.services;

import com.alibaba.fastjson.JSON;
import com.cmsz.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 工作组同步接口
 */
public class GroupService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String REST_API = HttpUtil.getConfig();

    public String queryWorkGroup(String groupId) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/queryWorkGroup", "POST", groupId);
        return JSON.toJSONString(jsonString);
    }


}
