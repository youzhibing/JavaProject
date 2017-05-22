package com.yzb.lee;

public class JavaVersion {

	public static void main(String[] args) {

		String arch = System.getProperty("java.home"); 
		System.out.println(arch);
	}

}
