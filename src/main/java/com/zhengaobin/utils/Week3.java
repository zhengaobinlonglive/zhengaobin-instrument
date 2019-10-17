package com.zhengaobin.utils;

import java.io.IOException;
import java.util.List;

public class Week3 {
	
	public static void main(String[] args) throws IOException {
		List<String> readFile = FileUtils.readFile("d:\\Test.txt");
		for (String string : readFile) {
			String[] split = string.split("\\|");
			MyBean bean = new MyBean();
			bean.setName(split[0]);
			/*bean.setSex(split[1]);*/
			System.out.println(" bean is " + bean);
		}
		
	}

}

class MyBean{
	String name;
	String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "MyBean [name=" + name + ", sex=" + sex + "]";
	}
	
}

