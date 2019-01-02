package com.cmsz.services;

import com.alibaba.fastjson.JSONObject;
import com.cmsz.utils.HttpUtil;

/**
 * 用户信息同步接口
 */
public class UserService {
    private static final String REST_API = HttpUtil.getConfig();

    /**
     * 查询用户
     */
    public String queryUserInfo(String loginUser) {
        System.out.println("-----------开始调用查询服务:queryUserInfo()-----------" + loginUser);
        String jsonString = HttpUtil.httpUtil(REST_API + "/queryUserInfo", "POST", loginUser);
        System.out.println("------------查询的数据为:" + jsonString + "---------");
        return jsonString;
    }


    /**
     * 添加用户
     */
    public String addUserInfo(String userInfo) {
        System.out.println("-----------开始调用新增用户服务:addUserInfo()-----------" + userInfo);
        String jsonString = HttpUtil.httpUtil(REST_API + "/addUserInfo", "POST", userInfo);
        System.out.println("-----------返回结果----------" + jsonString);
        return jsonString;
    }

    /**
     * 删除用户
     */
    public String delUserInfo(String loginUsers) {
        System.out.println("-----------开始调用删除用户服务:delUserInfo()-----------" + loginUsers);
        String jsonString = HttpUtil.httpUtil(REST_API + "/delUserInfo", "POST", loginUsers);
        System.out.println("-----------返回结果----------" + jsonString);
        return jsonString;
    }

    /**
     * 修改用户
     */
    public String modifyUserInfo(String userInfo) {
        System.out.println("-----------开始调用修改用户服务:modifyUserInfo()-----------" + userInfo);
        String jsonString = HttpUtil.httpUtil(REST_API + "/modifyUserInfo", "POST", userInfo);
        System.out.println("-----------返回结果----------" + jsonString);
        return jsonString;
    }

    /**
     * 修改用户密码
     */
    public String modifyUserPwd(String json) {
        System.out.println("-----------开始调用修改用户密码服务:modifyUserPwd()-----------" + json);
        String jsonString = HttpUtil.httpUtil(REST_API + "/modifyUserPwd", "POST", json);
        System.out.println("-----------返回结果----------" + jsonString);
        return jsonString;
    }

    public static void main(String[] args) {
//        JSONObject jsonObject = new JSONObject();
//        UserService userService=new UserService();
//        /**
//         * {"loginUser":"iQDfSQQSaFuD9TfwJK4=","password":"iQDfO1tNNQ==",
//         "staffName":"mwLAfBg=","flag":"1","validLength":"370",
//         "expireDate":"2018-12-15 12:00:00","logLock":"1",
//         "departmentCode":"1","workCode":"1",
//         "note":"4A新增用户"}
//
//         */
//        jsonObject.put("loginUser","iQDf");
//        jsonObject.put("password","iQDfSQQSaFuD9TfwJK4=");
//        jsonObject.put("staffName","C/oy7sb16pd6");
//        jsonObject.put("flag","1");
//        jsonObject.put("validLength","370");
//        jsonObject.put("expireDate","2018-12-15 12:00:00");
//        jsonObject.put("logLock","1");
//        jsonObject.put("departmentCode","1=");
//        jsonObject.put("workCode","1=");
//        jsonObject.put("note","测试");
//        String s = new UserService().addUserInfo(jsonObject.toJSONString());
//        System.out.println(s);
//        AES aes=new AES();
//        String jBfD = aes.decrypt("jBfD");
//        System.out.println(jBfD);
////
//        jsonObject.put("loginUsers", "iQDf");
//        String delResult = new UserService().delUserInfo(jsonObject.toJSONString());
//        System.out.println(delResult);
//////        JSONObject jsonObject = new JSONObject();
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
//        String str="tpm@oneapm.com";
//        String substring = str.substring(0, str.indexOf("@"));
//        System.out.println(substring);
//        jsonObject.put("loginUser","iRLJaAQNZFud/1n8JabB58P2L4LR");
//        String userInfo = new UserService().queryUserInfo(jsonObject.toString());
//        System.out.println("查询用户:"+userInfo);
    }
}