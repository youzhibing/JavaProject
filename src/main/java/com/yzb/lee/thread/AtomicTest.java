package com.yzb.lee.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest
{
	public static void main(String[] args)
	{
		AtomicInteger ai = new AtomicInteger(10);
		int b = ai.incrementAndGet();
		System.out.println(b);
	}
}
