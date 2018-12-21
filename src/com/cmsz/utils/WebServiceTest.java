package com.cmsz.utils;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * Created by DGQ on 2018/12/3.
 */
public class WebServiceTest {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
//        String url = "http://localhost:8080/services/LoginSwitchService?wsdl";//调用的服务地址
        String url = "http://localhost:8080/services/UserService?wsdl";
        try {
            Call call = (Call) service.createCall();//创建工具call
            call.setTargetEndpointAddress(new java.net.URL(url));//设置地址
            call.setOperationName(new QName("http://com.cmsz.services", "queryUserInfo"));//与服务器端保持一致
            call.addParameter(new QName("loginUser"), org.apache.axis.encoding.XMLType.XSD_STRING, ParameterMode.IN);//  //“from”是接口服务端方法体中的实体类所声明的变量名称
            call.setUseSOAPAction(true);//是否是soapaction这里需要看webservice是否要求如下格式，如果没有要求可以不添加此设置
            call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING);//设置返回类型
//            String json="{\"flag\":\"1\"}";//对于json字符串的传递处理方式
            String json = "{\"loginUser\":\"\"}";
            String result = (String) call.invoke(new Object[]{json});
            System.out.println(result);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}


