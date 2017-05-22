package com.example.demo;

import java.math.BigDecimal;

public class BigDecimalTest {
	
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("9223372036854775807");
		System.out.println(bd.divide(new BigDecimal("1001"),2,BigDecimal.ROUND_HALF_UP));
	}
}
