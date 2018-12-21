package com.cmsz.utils;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * 工具类
 */
public class HttpUtil {
    /**
     * 调用服务
     *
     * @param url
     * @param type
     * @param json
     * @return
     */
    public static String httpUtil(String url, String type, String json) {
        HttpClient httpClient = new HttpClient();
        /**
         * 权限认证的操作 测试时发现不需要进行操作  之前调用不了是由于matrix-system中拦截器的作用
         */
//        UsernamePasswordCredentials creds = new UsernamePasswordCredentials("tpm@oneapm.com", "E136EFCE72C70BA8DB08B3220F11E574");
//        httpClient.getState().setCredentials(AuthScope.ANY, creds);
        HttpMethod method = null;
        PostMethod postMethod;
        switch (type) {
            case "GET":
                method = new GetMethod(url);
                break;
            case "POST":
                postMethod = new PostMethod(url);
                postMethod.setRequestEntity(new StringRequestEntity(json));
                method = postMethod;
                break;
        }
        //HttpMethodParams httpMethodParams = new HttpMethodParams();
        // httpMethodParams.setContentCharset("ISO-8859-1");
        //method.setDoAuthentication(true);//设置认证
        //method.setParams(httpMethodParams);
        method.addRequestHeader("accept", "application/json");  // 视具体情况而定，可以从浏览器或postman查看下请求的header
        //  method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8"); //这里设置具体编码，视具体接口而定

        /**
         * 参数中增加以下这句，是说让httpclient调用时/，
         * 如果Http出错，三次重试(DefaultHttpMethodRetryHandler这个类中已经默认设置为3)
         */
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
        String response = "";
        try {
            int statusCode = httpClient.executeMethod(method);
            response = method.getResponseBodyAsString();
            if (statusCode != HttpStatus.SC_OK) {
                System.out.println("Method failed code=" + statusCode + ": " + method.getStatusLine());
                return statusCode + ":" + method.getStatusLine();
            } else {
                System.out.println(new String(method.getResponseBody(), "utf-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return response;
    }

    /**
     * 获取配置文件
     *
     * @return
     */
    public static String getConfig() {
        //config为属性文件名，放在包com.test.config下，如果是放在src下，直接用config即可
        ResourceBundle resource = null;
        try {
            resource = ResourceBundle.getBundle("config");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resource.getString("URL");
    }

}
