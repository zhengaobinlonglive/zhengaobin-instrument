package com.zhengaobin.utils;

public class NumberUtils {
	
	/**
	 *  求百分比的整数部分的字符串
	 * @param n
	 * @param m
	 * @return
	 */
	public static String percent(int n ,int m) {
		return 100*n/m + "%";
	}

}
