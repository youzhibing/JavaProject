package com.yzb.lee.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ByteTest
{

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String obj = new String("hello");
		byte[] bytes = obj.getBytes();
		for (byte b : bytes)
		{
			System.out.print(b);
		}
		ByteTest bt = new ByteTest();
		
		Method method = ByteTest.class.getMethod("main", String.class);
		method.invoke(bt, "hello");
	}

}
