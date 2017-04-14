package com.server.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.server.api.util.DateFormator;
import com.server.api.util.DateUtils;

/**  
* 生成各种唯一的Id  
*  
* @author zkj  
* @date 2017年3月27日  新建  
*/
public class GenerateCode {

	  private static final String FORMATSTRING = "yyyyMMddHHmmss";

	    private static final String FORMATSTRINGFORLOG = "yyyyMMddHHmmssSSS";

	    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateCode.class);

	    /**
	     * 使用公平锁防止饥饿
	     */
	    private static final Lock LOCK = new ReentrantLock(true);

	    private static final int TIMEOUTSECODES = 3;

	    private static volatile int serialNo = 0;


	    /**
	     * 获取系统当前时间
	     *
	     * @param formatStr
	     * @return
	     */
	    private static String getDateTime(String formatStr) {
	        SimpleDateFormat format = new SimpleDateFormat(formatStr);
	        return format.format(new Date());
	    }

	    /**
	     * 随机生成N个字符串
	     *
	     * @return
	     */
	    public static String generNNumer(int n) {
	        String result = "";
	        for (int i = 1; i <= n; i++) {
	            int intVal = (int) (Math.random() * 26 + 97);
	            result = result + (char) intVal;
	        }
	        return result;
	    }

	    /**
	     * 返回四位随机整数
	     *
	     * @return
	     */
	    private static String getRandomNum(int length) {
	        int num = new Random(System.nanoTime()).nextInt(10000);
	        if (num < 10) {
	            return "000" + num;
	        } else if (num < 100) {
	            return "00" + num;
	        } else if (num < 1000) {
	            return "0" + num;
	        } else {
	            return "" + num;
	        }
	    }

	    /**
	     * 生成产品编号
	     * @return
	     */
	    public static String generateProductId(){
	        StringBuilder builder = new StringBuilder();
	        builder.append("CP");
	        builder.append(getDateTime(FORMATSTRINGFORLOG));
	        builder.append(getRandomNum(1000));
	        return builder.toString();
	    }
	    
	    /**
	     * 生成品牌编号
	     * @return
	     */
	    public static String generateBandId(){
	        StringBuilder builder = new StringBuilder();
	        builder.append("BD");
	        builder.append(getDateTime(FORMATSTRINGFORLOG));
	        builder.append(getRandomNum(1000));
	        return builder.toString();
	    }
	    
	    /**
	     * 生成分类编号
	     * @return
	     */
	    public static String generateSortId(){
	        StringBuilder builder = new StringBuilder();
	        builder.append("SO");
	        builder.append(getDateTime(FORMATSTRINGFORLOG));
	        builder.append(getRandomNum(1000));
	        return builder.toString();
	    }

	    /**
	     * 生成订单编号
	     * @return
	     */
	    public static String generateOrderNo() {
	        return "OD" + DateUtils.toString(new Date(), DateFormator.YEARMONTHDAYHHMMSS) + new Random().nextInt(1000);
	    }
	    
	    /**
	     * 生成订单编号(增强)
	     * @return
	     */
	    public static String generateOrderNo(String userId) {
	        return "OD" + userId.substring(10, 16) + DateUtils.toString(new Date(), DateFormator.YEARMONTHDAYHHMMSS) + new Random().nextInt(1000);
	    }
	    
	    
	    /**
	     * 生成用户唯一编号
	     * @return
	     */
	    public static String generateUserIdCode(){
	        StringBuilder builder = new StringBuilder();
	        builder.append("ZQ");
	        builder.append(getDateTime(FORMATSTRINGFORLOG));
	        builder.append(getRandomNum(1000));
	        return builder.toString();
	    }
	    
	    /**
	     * 图片资源的文件夹名 唯一
	     * @return
	     */
	    public static String generateResIdCode() {
	    	return "RES" + DateUtils.toString(new Date(), DateFormator.YEARMONTHDAYHHMMSS) + new Random().nextInt(1000);
	    }


	    /**
	     * 获取自增序列
	     *
	     * @return
	     */
	    private static String getIncrement() {
	        int tempSerialNo = 0;
	        try {
	            if (LOCK.tryLock(TIMEOUTSECODES, TimeUnit.SECONDS)) {
	                if (serialNo >= 9999) {
	                    serialNo = 0;
	                } else {
	                    serialNo = serialNo + 1;
	                }
	                tempSerialNo = serialNo;
	            } else {
	                // 指定时间内没有获取到锁，存在激烈的锁竞争或者性能问题，直接报错
	                LOGGER.error("can not get lock in:{} seconds!", TIMEOUTSECODES);
	                throw new RuntimeException("generateOrder can not get lock!");
	            }
	        } catch (Exception e) {
	            LOGGER.error("tryLock throws Exception:", e);
	            throw new RuntimeException("tryLock throws Exception!");
	        } finally {
	            LOCK.unlock();
	        }
	        if (tempSerialNo < 10) {
	            return "0" + tempSerialNo;
	        } else {
	            return "" + tempSerialNo;
	        }
	    }
}
