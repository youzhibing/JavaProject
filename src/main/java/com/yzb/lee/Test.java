package com.yzb.lee;

import java.util.Objects;

public class Test
{
    public static void main(String[] args)
    {
        //HashSet
        //SortedMap
        //TreeMap
        //TreeSet
        //ThreadLocal
        float a = 15.25000f;
        float b = 15.250001f;
        System.out.println(Math.abs(a-b));
        if (Math.abs(a-b) < 1E-6f) 
        {
            System.out.println(true);
        } 
        
        Objects.equals(a, b);
    }
}
