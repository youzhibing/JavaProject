package com.yzb.lee;

import java.util.Objects;

public class Test
{
	static
	{
		c = 0;
		System.out.println(Test.c);
		// System.out.println(c);  
		// 估计是因为编译的时候是先编译的静态常量，再编译的静态方法（可以看到常量池的内容在上面先生成，方法的内容在下面后生成），
		// 所以static块的putstatic这条字节码指令可以拿到静态变量c的直接引用地址
	}
	
	private static int c ;
	
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
