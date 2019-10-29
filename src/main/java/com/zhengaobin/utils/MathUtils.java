package com.zhengaobin.utils;

import java.text.NumberFormat;

/**
 * @author 郑奥斌
 *
 * 2019年10月27日
 */
public class MathUtils {
	
	//计算百分比的工具类
		public static String percnt(Integer num,Integer tatal){
			//创建一个数值格式化对象
			NumberFormat numberFormat = NumberFormat.getInstance();
			
			//设置返回小数点后几位
			numberFormat.setMaximumFractionDigits(2);
			
			String format = numberFormat.format((float)num/(float)tatal*100);
			return format;
			
		}
		
		public static void main(String[] args) {
			String percnt = percnt(1, 3);
			System.out.println(percnt+"%");
		}
	
}
