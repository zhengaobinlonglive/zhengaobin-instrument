package com.zhengaobin.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author 郑奥斌
 *
 */
public class StringUtils {
	private static Object[] cs;


	/**
	 *  
	 * @param str
	 * @return  
	 */
	public static  boolean isEmpty(String str) {
		
		return (null==str||"".equals(str.trim()));
	}
	
	
	/**
	 * 是否有值
	判断源字符串是否有值，空引号和空格也算没值
	 * @param str
	 * @return
	 */
	public static boolean hasText1(String str) {
		
		// 以下两种写法都对
		//return !(null ==str || "".equals(str.trim()));
		return (null !=str && !"".equals(str.trim()));
	}
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		String pattern = "^(136|135|137)\\d{8}$";
		return str.matches(pattern);
	}
	
	/**
	 *  
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		
		String pattern = "^\\w+@\\w+\\.[a-zA-Z]{2,3}$";
		Pattern compile = Pattern.compile(pattern);
		Matcher matcher = compile.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * 验证全为字母
	 * @param str
	 * @return
	 */
	public static boolean isLetter(String str) {
		String pattern = "^[a-zA-Z]+$";
		return str.matches(pattern);
	}
	
	/**
	 * 
	 * 获取n位随机英文字符串
	 * @param n
	 * @return
	 */
	public String randomLetterStr(int n) {
		
		if(n<=0)
			return "";
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			char letter = (char)('A' + random.nextInt(26));
			sb.append(letter);
		}		
		return sb.toString();
	}
	
	/**
	 * 获取n位随机英文和数字字符串
	 * @param n
	 * @return
	 */
	public String randomStr(int n) {
		
		char chars[]= {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N'};
		
		// 定义个随机对象
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			// 随机得到一个下标，根据下标从数组当中获取值，拼接到字符串上
			
			// 随机获取一个下标
			int index = random.nextInt(chars.length);
			char c = chars[index];
			sb.append(c);//向后拼接
			
			/*sb.append( chars[random.nextInt(chars.length)]
					);*/
			
		}
		return sb.toString();
		
	}
	
	//获取n个随机中文字符串
	public static String getRandonCnStr(int n) {
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(getOneCn());
		}
		return sb.toString();
		
	} 
	
	/**
	 * 随机获取一个中文字符
	 * @return
	 */
	private static String getOneCn(){
		
		String str = "";
        int hightPos; //
        int lowPos;
        Random random = new Random();

        hightPos = (176 + Math.abs(random.nextInt(39)));
        lowPos = (161 + Math.abs(random.nextInt(93)));

        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(hightPos)).byteValue();
        b[1] = (Integer.valueOf(lowPos)).byteValue();

        try {
            str = new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("错误");
        }

        return str;
	}
	
	/*
	* 方法功能：根据正则在字符串提取一段值，用于后面在url地址里提取ID值。
	* 例如在“http://news.cnstock.com/news,yw-201908-4413224.htm”把“4413224”提取出来。
	*/
	public static String getPlaceholderValue(String src, String regex){
		//TODO 实现代码
        Pattern pattern = Pattern.compile(regex);// 匹配的模式  
        Matcher m = pattern.matcher(src);  
        boolean find = m.find();
        if(find) {
        	String group = m.group(0);
        	 return group.substring(1,group.lastIndexOf('.'));
        }
        return "";
	}
	
	//测试工具包中isNumber()，
	/**
	 * 
	 * @param src
	 * @return
	 */
	public static boolean isNumber(String src) {
		//String regix="[0-9]{1,}(\\.?|[0-9]*)";
		String regix="[0-9]{1,}\\.?[0-9]*";
		return src.matches(regix);
		
		
	}
	
	/**
	 * 随机生成长度为n的字符串，其中包含字母和数字
	 * @param n
	 * @return
	 */
	public static String randomCharAndNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			sb.append(cs[random.nextInt(36)]);
		}
		return sb.toString();
		
	}
	
	
	
	public static boolean isUrl(String str) {
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184  
                 + "|" // 允许IP和DOMAIN（域名）
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);
	}
	
	/**
	 * 获取一个文件名称的扩展名
	 * 例如： mytest/mynewFile.txt return .txt
	 * @param fileName
	 * @return
	 */
	public static String getFileSuffix(String fileName) {
		
		//return ".txt";
		int dotIndex = fileName.lastIndexOf('.');
		if(dotIndex==-1)
			return "";
		
		return fileName.substring(fileName.lastIndexOf('.')-1);
		
	}
	
	/**
	 * 测试工具包中hasText()，该方法是过滤String参数空格后判断是否有值，
	 * 如果你有该功能方法，但不是这个方法名不扣分。如果没有该方法，必须现在编写该方法
	 * @param src
	 * @return
	 */
	public static boolean hasText(String src) {
		String string = src.replaceAll("\\s", "");
		return (!"".equals(string));
	}
	
	/*
	* 方法：生成唯一标签名，处理步骤：
	* 1、全部变成小写；
	* 2、清空两边的空格，把中间所有的空格替换成“-”；
	* 3、使用URLEncoder.encode()编码
	* 最后返回处理的结果。
	* 举例“Spring MVC”处理后为“spring-mvc”，“Spring Mvc”处理后也为“spring-mvc”
	*/
	public static String toUniqueTerm(String term) throws UnsupportedEncodingException{
	//TODO 实现代码
		term=term.toLowerCase();
		term=term.trim();
		term = term.replaceAll(" ", "-");
		return URLEncoder.encode(term,"UTF-8");
		
	}
	
	
	/*方法功能：将字符串转换成html文本，如果遇到“\n”换行换符，则要将这一段文本使用<p></p>标签
	 * @ContextConfiguration("classpath:spring.xml")
	*@RunWith(SpringRunner.class)
	* 包起来。如果遇到“\n\r”两个在一起按上面\n处理。如果只遇到一个“\r”则替换成<br/>标签。
	* 使用场景：网页文本框传到后台的字符串就可能就会回车换行。*/
	public static String toHtml1(String src){
		String[] strings = src.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : strings) {
			sb.append("<p>").append(string).append("</p>");
		}
		return sb.toString();
	}
	
	
	/**
	 * 检测含有\n\r 转换成\n
	 * \r 转换<br>
	 * @param str
	 * @return
	 */
	public static String toHtml(String str) {
		String replaceAll = str.replaceAll("\\\n\r", "\n");
		String replaceAll2 = replaceAll.replaceAll("\\\r", "<br/>");
		/* System.out.println(replaceAll2); */
		String[] split = replaceAll2.split("\\\n");
		StringBuilder sb = new StringBuilder();
		for (String string : split) {
			sb.append("<p>").append(string).append("</p>\n");
		}
		return sb.toString();	
	}
	
	
	

}
