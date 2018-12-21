package com.cmsz.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

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
        String str = "dgq";
		String str1="杜";
		str = aes.encrypt(str);
		str1 = aes.encrypt(str1);
		System.out.println("加密="+str);
		System.out.println("加密="+str1);
		str= aes.decrypt(str);
		str1= aes.decrypt("mRfD");
		System.out.println("解密="+str);
		System.out.println("解密="+str1);




    }
}
