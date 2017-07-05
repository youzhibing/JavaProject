package com.yzb.lee.reflect;

import java.lang.reflect.Method;

public class ReflectTest
{

	public static void main(String[] args)
	{
		/*Method[] methods = Example.class.getMethods();
		for (Method method : methods)
		{
			System.out.println(method.getName());
		}*/
		
		Example example = new Example();
		Method[] methods = example.getClass().getMethods();
		for (Method method : methods)
		{
			System.out.println(method.getName());
		}
	}

}
