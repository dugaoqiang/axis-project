package com.cmsz.services;

import com.alibaba.fastjson.JSON;
import com.cmsz.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户信息同步接口
 */
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String REST_API = HttpUtil.getConfig();

    /**
     * 查询用户
     */
    public String queryUserInfo(String loginUser) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/queryUserInfo", "POST", loginUser);
        System.out.println("查询的数据为:" + jsonString);
        return JSON.toJSONString(jsonString);
    }


    /**
     * 添加用户
     */
    public String addUserInfo(String userInfo) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/addUserInfo", "POST", userInfo);
        logger.info("添加用户信息:" + jsonString);
        return JSON.toJSONString(jsonString);
    }

    /**
     * 删除用户
     */
    public String delUserInfo(String loginUsers) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/delUserInfo", "POST", loginUsers);
        return JSON.toJSONString(jsonString);
    }

    /**
     * 修改用户
     */
    public String modifyUserInfo(String userInfo) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/modifyUserInfo", "POST", userInfo);
        return JSON.toJSONString(jsonString);

    }

    /**
     * 修改用户密码
     */
    public String modifyUserPwd(String json) {
        String jsonString = HttpUtil.httpUtil(REST_API + "/modifyUserPwd", "POST", json);
        return JSON.toJSONString(jsonString);
    }

    public static void main(String[] args) {
//        UserService userService=new UserService();
//        /**
//         * {"loginUser":"iQDfSQQSaFuD9TfwJK4=","password":"iQDfO1tNNQ==",
//         "staffName":"mwLAfBg=","flag":"1","validLength":"370",
//         "expireDate":"2018-12-15 12:00:00","logLock":"1",
//         "departmentCode":"1","workCode":"1",
//         "note":"4A新增用户"}
//
//         */
//       JSONObject jsonObject = new JSONObject();
////        jsonObject.put("loginUser","iQDf");
////        jsonObject.put("password","iQDfSQQSaFuD9TfwJK4=");
////        jsonObject.put("staffName","C/oy7sb16pd6");
////        jsonObject.put("flag","1");
////        jsonObject.put("validLength","370");
////        jsonObject.put("expireDate","2018-12-15 12:00:00");
////        jsonObject.put("logLock","1");
////        jsonObject.put("departmentCode","1=");
////        jsonObject.put("workCode","1=");
////        jsonObject.put("note","测试");
////        String s = new UserService().addUserInfo(jsonObject.toJSONString());
////        System.out.println(s);
//
////        jsonObject.put("loginUsers", "iQDfSQQSaFuD9TfwJK6M89u/LYLNsa/abKiotMNvdqt2hKXf");
////        String delResult = new UserService().delUserInfo(jsonObject.toJSONString());
////        System.out.println(delResult);
////        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("loginUser","iQDf");
////        jsonObject.put("password","iQDfSQQSaFuD9TfwJK4=");
////        jsonObject.put("staffName","C/oy");
////        String modifyUserInfo=userService.modifyUserInfo(jsonObject.toJSONString());
////        System.out.println(modifyUserInfo);
////        {"loginUser":"mwLAfBg=","oldPassword":"",
////                "newPassword":"3FafOFpN"}
//
//        jsonObject.put("loginUser","iQDf");
//        jsonObject.put("oldPassword","iQDfSQQSaFuD9TfwJK4=");
//        jsonObject.put("newPassword","3FafOFpN");
//        String s = userService.modifyUserPwd(jsonObject.toJSONString());
//        System.out.println(s);
//
////        String str="tpm@oneapm.com";
////        String substring = str.substring(0, str.indexOf("@"));
////        System.out.println(substring);
////        jsonObject.put("loginUser","iRLJaAQNZFud/1n8JabB58P2L4LR");
////        String userInfo = new UserService().queryUserInfo(jsonObject.toString());
////        System.out.println("查询用户:"+userInfo);
    }
}