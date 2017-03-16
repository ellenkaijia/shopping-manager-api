package com.server.api.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTools {

	 private static Logger log = LoggerFactory.getLogger(StringTools.class);
	
	public static String getClassAndMethod(String clazz){
		if(isEmpty(clazz) || !clazz.contains(".")){
			return "";
		}
		try{
			int index = clazz.lastIndexOf(".");//最后一个.
			String tmp = clazz.substring(0, index-1);//倒数第二个.
			index = tmp.lastIndexOf(".");
			return clazz.substring(index+1);//取类名.方法名的字符串，如“EmployeeDao.selectByPrimaryKey”
		}
		catch(Exception e){
			log.error("" , e);
		}
		return "";
	}
	
	/**
	 * 连续空白字符替换为一个空格
	 * @param str
	 * @return
	 */
	public static String getStringOneBlank(String str) {      
        if(!isEmpty(str)) {      
            Pattern p = Pattern.compile("\\s+");      
            Matcher m = p.matcher(str);      
            String strNoBlank = m.replaceAll(" ");      
            return strNoBlank;      
        }else {      
            return str;      
        }           
    } 
	
	/**
	 * 首写字母变小写
	 * @param src
	 * @return
	 */
	public static String firstToLower(String src)
	{
		String first = src.substring(0,1);
		String upper = first.toLowerCase();
		return src.replaceFirst(first,upper);
	}
	
	
	
	/**
	 * 判断字符串是否为空或者空字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
	    return null == str || str.trim().isEmpty(); 
	}	
}
