package com.yzb.codec;

import java.security.MessageDigest;

public class MessageDigestTest
{
    public static void main(String[] args) throws Exception
    {
        
        String str = "123";
        byte[] plainText = str.getBytes("UTF8");
        
        //使用getInstance("算法")来获得消息摘要,这里使用SHA-1的160位算法
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        
        System.out.println("/n" + messageDigest.getProvider().getInfo());
        
        //开始使用算法
        messageDigest.update(plainText);
        System.out.println("/nDigest:");
        //输出算法运算结果
        System.out.println(new String(messageDigest.digest(), "UTF8"));

    }
}
