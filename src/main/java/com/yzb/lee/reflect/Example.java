package com.yzb.lee.reflect;

public class Example
{
	public static String getHi(String message)
	{
		return "Hi, " + message;
	}
	
	public String getHello(String message)
	{
		return "Hello, " + message;
	}
	
	static void setHi()
	{
		System.out.println("set hi");
	}
	
	void setHello()
	{
		System.out.println("hello");
	}
}
