package com.yzb.lee.aes;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * 
 * AES加密与解密<br>
 * 没有加入盐值
 *
 */
public class AESUtil
{
    private static final int AES_TYPE = 128;                // AES可以使用128、192、和256位密钥, 为什么只支持128?
    private static final String ALGORITHM_TYPE = "AES";     // 算法类型
    
    public static void main(String[] args)
    {
        String content = "hello AES";
        String password = "123123123123123123";
        byte[] encodeMessage = AESJDKEncode(content, password);
        System.out.println("AES 加密后: "
                + convertByteToHexString(encodeMessage));
        byte[] decodeMessage = AESJDKDecode(encodeMessage, password);
        System.out.println("AES 解密后: "
                + new String(decodeMessage));
    }
    
    /**
     * AES加密
     * @param message   加密对象
     * @param password  加密密钥
     * @return [参数说明]
     */
    public static byte[] AESJDKEncode(String message, String password)
    {
        try
        {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM_TYPE);
            kgen.init(AES_TYPE, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM_TYPE);
            Cipher cipher = Cipher.getInstance(ALGORITHM_TYPE);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(message.getBytes());
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * AES解密
     * @param message 解密对象
     * @param password 加密密钥
     * @return [参数说明]
     */
    public static byte[] AESJDKDecode(byte[] message, String password)
    {
        try
        {
            KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM_TYPE);
            kgen.init(AES_TYPE, new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, ALGORITHM_TYPE);
            Cipher cipher = Cipher.getInstance(ALGORITHM_TYPE);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(message);
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 将byte数组转化为16进制输出
     * @param bytes
     * @return [参数说明]
     */
    public static String convertByteToHexString(byte[] bytes)
    {
        String result = "";
        for (byte b : bytes)
        {
            int temp = b & 0xff;
            String tempHex  = Integer.toHexString(temp);
            if (tempHex.length() < 2)
            {
                result += "0" + tempHex;
            }
            else
            {
                result += tempHex;
            }
        }
        return result;
    }
}
