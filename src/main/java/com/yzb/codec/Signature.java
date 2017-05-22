package com.yzb.codec;

import java.util.Locale;

public class Signature
{
    // 日期格式：yyyyMMdd'T'HHmmss'Z'
    private static final int APPID = 100101;
    // SignedHeaders：需要签名的属性
    private static final String SignedHeaders = "host;user-agent;x-wgpserver-appid;"
            + "x-wgpserver-date;x-wgpserver-method;x-wgpserver-param;x-wgpserver-trace-id;x-wgpserver-uri";
    /**
      * Authorization: WGPSERVER-HMAC-SHA256 Credential=100101/20170421/wgp-server/slbadmin_request,
      * SignedHeaders=host;user-agent;x-wgpserver-appid;x-wgpserver-date;x-wgpserver-method;x-wgpserver-param;x-wgpserver-trace-id;x-wgpserver-uri,
      * Signature=92367419bdb84c3d81b0bdbebe40e77c4e470714579d78485e03e863fc18b199
     */
    
    private String getCanonicalRequest()
    {
        StringBuilder sb = new StringBuilder("");
        sb.append(HttpMethod.GET + "\n");
        sb.append(getUri()).append("\n");
        sb.append(getQueryParam(1,"10-15")).append("\n");
        sb.append(SignedHeaders.toLowerCase(Locale.US));
        return sb.toString();
    }
    
    private String getUri()
    {
        StringBuilder sb = new StringBuilder("");
        sb.append("http://192.168.195.157:18082/wgp-server/findServer"); 
        return sb.toString();
    }
    
    // appid 需要加进去，日期也需要加进去？
    private String getQueryParam(int serverId, String traceId)
    {
        StringBuilder sb = new StringBuilder("");
        sb.append("serverId=").append(serverId);
        sb.append("&").append("traceId=").append(traceId);
        return sb.toString();
    }
    
    public String getSignatureStr()
    {
        Encrypt encrypt = new Encrypt();
        String obj = getCanonicalRequest();
        System.out.println(obj);
        return encrypt.SHA256(obj);
    }
    
    enum HttpMethod
    {
        GET, PUT, DELETE
    }
    
    public static void main(String[] args)
    {
        Signature sign = new Signature();
        String obj = sign.getSignatureStr();
        System.out.println("\n" + obj);
    }
}
