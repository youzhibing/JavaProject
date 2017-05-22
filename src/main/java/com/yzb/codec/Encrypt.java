package com.yzb.codec;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Encrypt
{
    
    public static void main(String[] args)
    {
        Encrypt encrypt = new Encrypt();
        System.out.println(encrypt.SHA256WithSecret("123", "hello"));
    }
    
    public String SHA256WithSecret(String secret, String message)
    {
        try
        {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(),"HmacSHA256");
            sha256_HMAC.init(secret_key);
            
            byte[] byteBuffer = sha256_HMAC.doFinal(message.getBytes());
            
            return Hex.encodeHexString(byteBuffer);
        }
        catch (Exception e)
        {
            System.out.println("Error");
            return "";
        }
    }
    
    private String byte2HexString(byte[] signedBytes)
    {
        StringBuilder strHexString = new StringBuilder();
        for (byte objByte : signedBytes)
        {
            String hex = Integer.toHexString(0xff & objByte);
            if (hex.length() == 1)
            {
                strHexString.append('0');
            }
            strHexString.append(hex);
        }
        
        return strHexString.toString();
    }
    
    /** 
     * 传入文本内容，返回 SHA-256 串 
     *  
     * @param strText 
     * @return 
     */
    public String SHA256(final String strText)
    {
        return SHA(strText, "SHA-256");
    }
    
    /** 
     * 传入文本内容，返回 SHA-512 串 
     *  
     * @param strText 
     * @return 
     */
    public String SHA512(final String strText)
    {
        return SHA(strText, "SHA-512");
    }
    
    /** 
     * 字符串 SHA 加密 
     *  
     * @param strSourceText 
     * @return 
     */
    private String SHA(final String strText, final String strType)
    {
        // 返回值  
        String strResult = null;
        
        // 是否是有效字符串  
        if (strText != null && strText.length() > 0)
        {
            try
            {
                // SHA 加密开始  
                // 创建加密对象 并傳入加密類型  
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串  
                messageDigest.update(strText.getBytes());
                // 得到 byte 類型结果  
                byte byteBuffer[] = messageDigest.digest();
                
                // 將 byte 轉換爲 string  
                StringBuffer strHexString = new StringBuffer();
                // 遍歷 byte buffer  
                for (int i = 0; i < byteBuffer.length; i++)
                {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1)
                    {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果  
                strResult = strHexString.toString();
            }
            catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
        }
        
        return strResult;
    }
    
}
