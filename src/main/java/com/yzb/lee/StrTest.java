package com.yzb.lee;

public class StrTest
{
    public static void main(String[] args)
    {
        String str = "start";
        for (int i = 0; i < 100; i++)
        {
            str = str + "hello";
        }
        System.out.println(str);
    }
    
}
