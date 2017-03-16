package com.server.api.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.Assert;


public class DateUtils {
	private DateUtils() {

	}

	/**
	 * 获取下一个月的时间
	 * @param startDate
	 * @return
	 */
	public static Date getNextMonthDate(Date startDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.MONTH,1);
		return calendar.getTime();
	}



	public static Date now() {
		return new GregorianCalendar().getTime();
	}

	public static String toString(Date date, String pattern) {
		Assert.notNull(date);
		Assert.notNull(pattern);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	public static String toString(Date date, DateFormator pattern) {
		Assert.notNull(date);
		Assert.notNull(pattern);
		SimpleDateFormat sdf = new SimpleDateFormat(pattern.toString());
		return sdf.format(date);
	}

	public static String toString(Date date) {
		Assert.notNull(date);
		return toString(date, DateFormator.YEAR_MONTH_DAY_HH_MM_SS);
	}

	/**
	 * 比较两个 Date 对象表示的时间值（从历元至现在的毫秒偏移量）。
	 * 
	 * @param d1
	 * @param d2
	 * @return 如果 d1 表示的时间等于 d2 表示的时间，则返回 0 值；如果此 d1 的时间在d2表示的时间之前，则返回小于 0 的值；如果 d1 的时间在 d2 表示的时间之后，则返回大于 0 的值。
	 * 
	 */
	public static int compare(Date d1, Date d2) {
		Assert.notNull(d1);
		Assert.notNull(d2);

		Calendar c1 = new GregorianCalendar();
		Calendar c2 = new GregorianCalendar();
		c1.setTime(d1);
		c2.setTime(d2);

		return c1.compareTo(c2);
	}

	

	/**
	 * 根据年月获取一个月的开始时间（第一天的凌晨）
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date beginTimeOfMonth(int year, int month) {
		Calendar first = new GregorianCalendar(year, month - 1, 1, 0, 0, 0);
		return first.getTime();
	}

	/**
	 * 根据年月获取一个月的结束时间（最后一天的最后一毫秒）
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static Date endTimeOfMonth(int year, int month) {
		Calendar first = new GregorianCalendar(year, month, 1, 0, 0, 0);
		first.add(Calendar.MILLISECOND, -1);
		return first.getTime();
	}

	/**
	 * 获取前preDays天的Date对象
	 * 
	 * @param date
	 * @param preDays
	 * @return
	 */
	public static Date preDays(Date date, int preDays) {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(date);
		GregorianCalendar cloneCalendar = (GregorianCalendar) c1.clone();
		cloneCalendar.add(Calendar.DATE, -preDays);
		return cloneCalendar.getTime();
	}

	/**
	 * 获取后nextDays天的Date对象
	 * 
	 * @param date
	 * @param nextDays
	 * @return
	 */
	public static Date nextDays(Date date, int nextDays) {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(date);
		GregorianCalendar cloneCalendar = (GregorianCalendar) c1.clone();
		cloneCalendar.add(Calendar.DATE, nextDays);
		return cloneCalendar.getTime();
	}
	public static  Date beginTimeOfNextDate(int  nextDays) {
	    return beginTimeOfNextDate(new Date(),nextDays);
    }
	public static Date beginTimeOfNextDate(Date date ,int  nextDays) {
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	    cal.set(Calendar.SECOND, 0);
	    cal.set(Calendar.MILLISECOND, 0);
	    cal.add(Calendar.DAY_OF_MONTH, nextDays);
	    return  cal.getTime();
    }

	public static Date nextMonths(Date date, int nextMonth) {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(date);
		GregorianCalendar cloneCalendar = (GregorianCalendar) c1.clone();
		cloneCalendar.add(Calendar.MONTH, nextMonth);
		return cloneCalendar.getTime();
	}

	public static Date preMonths(Date date, int preMonth) {
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(date);
		GregorianCalendar cloneCalendar = (GregorianCalendar) c1.clone();
		cloneCalendar.add(Calendar.MONTH, -preMonth);
		return cloneCalendar.getTime();
	}

	public static long getDiffMillis(Date d1, Date d2) {
		Assert.notNull(d1);
		Assert.notNull(d2);

		long diff = d1.getTime() - d2.getTime();

		return diff;
	}

	

	

	/**
	 * 获取间隔时间
	 * 
	 * @param d1
	 * @param d2
	 * @return HH:MM:SS,返回时间间隔的绝对值，没有负数
	 */
	public static String getDiffs(Date d1, Date d2) {
		long diffMillis = getDiffMillis(d1, d2);
		long diffHours = diffMillis / (60L * 60L * 1000L);
		long diffMinutes = diffMillis / (60L * 1000L) % 60;
		long diffSeconds = diffMillis / 1000L % 60;
		diffHours = Math.abs(diffHours);
		diffMinutes = Math.abs(diffMinutes);
		diffSeconds = Math.abs(diffSeconds);
		StringBuffer temp = new StringBuffer();
		temp.append(diffHours < 10 ? "0" + diffHours : diffHours);
		temp.append(":");
		temp.append(diffMinutes < 10 ? "0" + diffMinutes : diffMinutes);
		temp.append(":");
		temp.append(diffSeconds < 10 ? "0" + diffSeconds : diffSeconds);
		return temp.toString();
	}

	
	/**
	 * 根据日期返回日期中的年. wuwm
	 * 
	 * @param d
	 * @return int
	 */
	public static int getYear(Date d) {
		Assert.notNull(d);
		String dateStr = toString(d, DateFormator.YEAR_MONTH); // yyyy-MM
		return Integer.parseInt(dateStr.split(DateFormator.SPLIT_CHAR.toString())[0]);
	}

	/**
	 * 根据日期返回日期中的年.
	 * 
	 * @param d
	 * @return int
	 */
	public static int getMonth(Date d) {
		Assert.notNull(d);
		String dateStr = toString(d, DateFormator.YEAR_MONTH); // yyyy-MM
		return Integer.parseInt(dateStr.split(DateFormator.SPLIT_CHAR.toString())[1]);
	}

	/**
	 * 根据日期返回日期中的日.
	 * 
	 * @param d
	 * @return int
	 */
	public static int getDay(Date d) {
		Assert.notNull(d);
		String dateStr = toString(d, DateFormator.YEAR_MONTH_DAY); // yyyy-MM-dd
		return Integer.parseInt(dateStr.split(DateFormator.SPLIT_CHAR.toString())[2]);
	}

	public static boolean isEnDateFormat(String str) {
		String rex = "((((02|2)\\/29)\\/(19|20)(([02468][048])|([13579][26])))|((((0?[1-9])|(1[0-2]))\\/((0?[1-9])|(1\\d)|(2[0-8])))|((((0?[13578])|(1[02]))\\/31)|(((0?[1,3-9])|(1[0-2]))\\/(29|30))))\\/((20[0-9][0-9])|(19[0-9][0-9])|(18[0-9][0-9])))";
		Pattern regex = Pattern.compile(rex);
		Matcher matcher = regex.matcher(str);
		boolean isMatched = matcher.matches();
		return isMatched;
	}

	private static Map<String, DateFormator> defaultDateFormatMap = new HashMap<String, DateFormator>();
	static {
		defaultDateFormatMap.put("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2}", DateFormator.YEAR_MONTH_DAY);
		defaultDateFormatMap.put("[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}", DateFormator.YEAR_MONTH_DAY_EU);
		defaultDateFormatMap.put("[0-9]{4}-[0-9]{1,2}-[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}",
				DateFormator.YEAR_MONTH_DAY_HH_MM_SS);
		defaultDateFormatMap.put("[0-9]{4}/[0-9]{1,2}/[0-9]{1,2} [0-9]{1,2}:[0-9]{1,2}:[0-9]{1,2}",
				DateFormator.YEAR_MONTH_DAY_H_M_S_EU);
		defaultDateFormatMap.put("[0-9]{4}-[0-9]{1,2}", DateFormator.YEAR_MONTH);
		defaultDateFormatMap.put("[0-9]{4}/[0-9]{1,2}", DateFormator.YEAR_MONTH_EU);
		defaultDateFormatMap
				.put("((((02|2)/29)/(19|20)(([02468][048])|([13579][26])))|((((0?[1-9])|(1[0-2]))/((0?[1-9])|(1\\d)|(2[0-8])))|((((0?[13578])|(1[02]))/31)|(((0?[1,3-9])|(1[0-2]))/(29|30))))/((20[0-9][0-9])|(19[0-9][0-9])|(18[0-9][0-9])))",
						DateFormator.MONTH_DAY_YEAR_EU);
	}

	public static boolean checkIsWeekend(Date time) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 计算两个日期之间相差多少个小时
	 * 
	 * @author ZFQ
	 * @param begingDate
	 *            较小的时间
	 * @param endDate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int hoursBetween(Date endDate, Date begingDate)  {
		Calendar cal = Calendar.getInstance();
		cal.setTime(begingDate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(endDate);
		long time2 = cal.getTimeInMillis();
		long between_hours = (time2 - time1) / (1000 * 3600);
		return Integer.parseInt(String.valueOf(between_hours));
	}


	
}
