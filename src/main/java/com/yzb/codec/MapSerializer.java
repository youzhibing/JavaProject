package com.yzb.codec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignedObject;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MapSerializer
{
    private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    
    public static void main(String[] args) throws Exception
    {
        MapSerializer sign = new MapSerializer();
        byte[] key = sign.initMacKey(Hmac.HmacMD5);
        byte[] result = sign.makeHmac(Hmac.HmacMD5, "hello".getBytes(), key);
        System.out.println(byte2String(result));
        //System.out.println(byte2String(sign.makeHmac(Hmac.HmacSHA256, result, key)));
    }
    
    /**
     * 加密
     * 
     * @return
     * @see Hmac
     * @throws Exception
     */
    public byte[] makeHmac(Hmac hmac, byte[] data, byte[] key)
        throws NoSuchAlgorithmException, InvalidKeyException
    {
        Mac mac = Mac.getInstance(hmac.toString());
        SecretKeySpec spec = new SecretKeySpec(key, hmac.toString());
        mac.init(spec);
        return mac.doFinal(data);
    }
    
    /**
     * 初始化HMAC密钥
     * 
     * @return
     * @see Hmac
     * @throws Exception
     */
    public byte[] initMacKey(Hmac hmac) throws Exception
    {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(hmac.toString());
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }
    
    /**
     * 将字节流按16进制转换成字符串.
     */
    public static String byte2String(byte[] buf)
    {
        int count = buf.length;
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < count; i++)
        {
            byte byte0 = buf[i];
            sbuf.append(hexDigits[byte0 >>> 4 & 0xf])
                    .append(hexDigits[byte0 & 0xf]);
        }
        return sbuf.toString().toUpperCase();
    }
}

/**
 * Hmac(Hash Message Authentication Code，散列消息鉴别码)
 * 
 * @author jianggujin
 * 
 */
enum Hmac
{
    HmacMD5, HmacSHA1, HmacSHA256, HmacSHA384, HmacSHA512
}