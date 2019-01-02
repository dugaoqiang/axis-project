package com.cmsz.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * AES方式加解密算法
 *
 * @author venus4A
 */
public class AES {

    /**
     * 由服务端提供给调用者的一个用于数据加密的共享密钥
     */
    private String _publicKey = null;

    /**
     * @param publicKey AES密钥
     */
    public AES() {
        String publicKey = "jKV4GEAwBtcyehND";
        _publicKey = publicKey;
    }

    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_ALGORITHM = "AES/CTR/PKCS5Padding";
    public static final String ivParameter = "1234567890abcdef";

    /**
     * 解密
     *
     * @param data
     * @return
     */
    public String decrypt(String data) {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(_publicKey.getBytes("ASCII"), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 加密
     *
     * @param data
     * @return
     */
    public String encrypt(String data) {
        try {
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            SecretKeySpec sKeySpec = new SecretKeySpec(_publicKey.getBytes(), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iv);
            byte[] encrypted = cipher.doFinal(data.getBytes("utf-8"));
            return new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        //举例
        AES aes = new AES();
        String loginUser = "dgq";
		String password="123456";
		String contact_name="杜";
        loginUser = aes.encrypt(loginUser);
        password = aes.encrypt(password);
        contact_name = aes.encrypt(contact_name);
		System.out.println("加密="+loginUser);
		System.out.println("加密="+password);
		System.out.println("加密="+contact_name);
        loginUser= aes.decrypt(loginUser);
        password= aes.decrypt(password);
        contact_name= aes.decrypt(contact_name);
		System.out.println("解密="+loginUser);
		System.out.println("解密="+password);
		System.out.println("解密="+contact_name);

        JSONObject jsonObject=new JSONObject();
	    jsonObject.put("loginUser","iQDf");
        jsonObject.put("password","iQDfSQQSaFuD9TfwJK4=");
        jsonObject.put("staffName","C/oy7sb16pd6");
        jsonObject.put("flag","1");
        jsonObject.put("validLength","370");
        jsonObject.put("expireDate","2018-12-15 12:00:00");
        jsonObject.put("logLock","1");
        jsonObject.put("departmentCode","1=");
        jsonObject.put("workCode","1=");
        jsonObject.put("note","测试");
        System.out.println(jsonObject.toString());





    }
}
