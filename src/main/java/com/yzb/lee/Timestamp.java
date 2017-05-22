package com.yzb.lee;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class Timestamp {

	public static void main(String[] args) {
		//System.out.println(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		System.out.println(sdf.format(new Date(1478849999514L)));
		Arrays.asList("helelo");
		Collections.addAll(null);
		Math.random();
		SecureRandom random = new SecureRandom();
		//Comparable
	}

}
