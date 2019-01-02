package com.cmsz.services;

import com.alibaba.fastjson.JSON;
import com.cmsz.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 查询部门服务
 */
public class DepartmentService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String REST_API = HttpUtil.getConfig();

    public String queryDepartment(String departmentId) {
        System.out.println("-----------调用查询部门服务queryDepartment():"+departmentId);
        String jsonString = HttpUtil.httpUtil(REST_API + "/queryDepartment", "POST", departmentId);
        return jsonString;
    }


}
