/**
 * 
 */
package com.cs.tool;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;


/**
 * @author Administrator
 *
 */
public class DateTool {

	/**
	 * 英文简写（默认）如：2010-12-01
	 */
	public static String FORMAT_SHORT = "yyyy-MM-dd";

	/**
	 * 路径格式 如：2010/12/01
	 */
	public static String FORMAT_PATH = "/yyyy/MM/dd";

	/**
	 * 获得月份
	 */
	public static String FORMAT_MONTH = "yyyy-MM";

	/**
	 * 英文全称 如：2010-12-01 23:15:06
	 */
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
	 */
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

	/**
	 * 年月日十分秒 不要横线
	 */
	public static String FORMAT_FULL_NOLINE = "yyyyMMddHHmmss";

	/**
	 * 年月日 不要横线
	 */
	public static String FORMAT_SHORT_NOLINE = "yyyyMMdd";
	
	
	/**
	 * 时分秒 不要横线
	 */
	public static String FORMAT_TIME_NOLINE = "HHmmss";

	/**
	 * 时 分 秒
	 */
	public static String FORMAT_TIME_SHORT_NOLINE = "HH:mm:ss";

	/**
	 * 中文简写 如：2010年12月01日
	 */
	public static String FORMAT_SHORT_CN = "yyyy年MM月dd日";

	/**
	 * 中文全称 如：2010年12月01日 23时15分06秒
	 */
	public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

	/**
	 * 精确到毫秒的完整中文时间
	 */
	public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

	/**
	 * 获得默认的 date pattern
	 */
	public static String getDatePattern()
	{
		return FORMAT_FULL_NOLINE;
	}

	/**
	 * 根据预设格式返回当前日期
	 * 
	 * @return
	 */
	public static String getNow()
	{
		return format(new Date());
	}

	/**
	 * 根据时间戳得到date对象
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDate(long date)
	{
		return new Date(date);
	}

	/**
	 * 根据时间戳得到月份
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonth(String date)
	{
		return format(parse(date, FORMAT_MONTH), FORMAT_MONTH);
	}

	/**
	 * 根据用户格式返回当前日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getNow(String format)
	{
		return format(new Date(), format);
	}

	/**
	 * 使用预设格式格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date)
	{
		return format(date, getDatePattern());
	}

	/**
	 * 使用用户格式格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String format(Date date, String pattern)
	{
		String returnValue = "";
		if (date != null)
		{
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * 使用预设格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @return
	 */
	public static Date parse(String strDate)
	{
		return parse(strDate, getDatePattern());
	}

	/**
	 * 使用用户格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date parse(String strDate, String pattern)
	{
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try
		{
			return df.parse(strDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 使用用户格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String parse_CN(String strDate, String pattern)
	{
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_LONG);

		SimpleDateFormat df_CN = new SimpleDateFormat(pattern);

		Date date = null;
		try
		{
			date = df.parse(strDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

		return df_CN.format(date);
	}

	public static String parseTo(String strDate)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(strDate.substring(0, 4)).append("-")
				.append(strDate.substring(4, 6)).append("-")
				.append(strDate.substring(6, 8)).append(" ")
				.append(strDate.substring(8, 10)).append(":")
				.append(strDate.substring(10, 12)).append(":")
				.append(strDate.substring(12));
		return sb.toString();
	}

	/**
	 * 在日期上增加数个整月
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的月数
	 * @return
	 */
	public static Date addMonth(Date date, int n)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return
	 */
	public static Date addDay(Date date, int n)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加小时
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的小时
	 * @return
	 */
	public static Date addHour(Date date, Integer n)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, n);
		return cal.getTime();
	}

	/**
	 * 获取时间戳
	 */
	public static String getTimeString()
	{
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * 获取日期年份
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getYear(Date date)
	{
		return format(date).substring(0, 4);
	}

	/**
	 * 按默认格式的字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 */
	public static int countDays(String date)
	{
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	public static int countDays(Date sdate, Date eDate)
	{
		Calendar ec = Calendar.getInstance();
		ec.setTime(eDate);
		long t = ec.getTime().getTime();
		Calendar sc = Calendar.getInstance();
		sc.setTime(sdate);
		long t1 = sc.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 按用户格式字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static int countDays(String date, String format)
	{
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 获取时间字符串
	 * 
	 * @param hour
	 * @param min
	 * @return
	 */
	public static String getTimeStr(int hour, int min)
	{
		StringBuilder builder = new StringBuilder();
		if (hour < 10)
		{
			builder.append(0);
		}
		builder.append(hour).append(':');
		if (min < 10)
		{
			builder.append(0);
		}
		builder.append(min);
		return builder.toString();
	}

	/**
	 * 获取现在时间
	 * 
	 * @param format
	 * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate(String format)
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 生成时间（年月日时分秒）
	 * 
	 * @Title:
	 * @Date: 2014-9-24
	 * @author: ZFQ
	 * @param: @return
	 * @return: String
	 */
	public static String generDataTime()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String datatime = sdf.format(new Date());
		return datatime;
	}

	/**
	 * 注：台州版本 交易详情给出超时时间 (24小时 - （当前时间 - 交易时间) 得出时间差) 超时时间返回
	 * 
	 * @param time
	 * @param timeout
	 * @param seqNo
	 * @return
	 */
	public static String compareDate(String time)
	{
		String now = getNow("yyyy-MM-dd HH:mm:ss");
		String retTime = null;
		int tt = Integer.parseInt(getDate(time, now));
		if (tt > 86400)
		{
			retTime = "0";
		}
		else
		{
			int i = 86400 - tt;
			retTime = String.valueOf(i);
		}
		return retTime;
	}

	public static String getDate(String orderTime, String nowTime)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long days = 0;
		try
		{
			Date busiTime = sdf.parse(orderTime);
			Date now = sdf.parse(nowTime);
			long diff = now.getTime() - busiTime.getTime();
			days = diff / (1000);
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return String.valueOf(days);
	}

	/**
	 * 将指定的日期转换成时间戳
	 * 
	 * @param String
	 *            date 需要转换的日期 yyyy-MM-dd HH:mm:ss
	 * @return long 时间戳
	 */
	public static long dateToTimeStamp(String date)
	{
		long timestamp = 0;
		try
		{
			timestamp = new SimpleDateFormat(FORMAT_LONG).parse(date).getTime();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 将指定的日期转换成时间戳
	 * 
	 * @param String
	 *            date 需要转换的日期 yyyy-MM-dd
	 * @return long 时间戳
	 */
	public static long dateToTimeStamp(String date, String dateFormat)
	{
		long timestamp = 0;
		try
		{
			timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return timestamp;
	}

	/**
	 * 将当前日期转换成时间戳
	 * 
	 * @return long 时间戳
	 */
	public static long dateToTimeStamp()
	{
		long timestamp = new Date().getTime();
		return timestamp;
	}

	/**
	 * 将时间戳转换成日期
	 * 
	 * @param long timestamp 时间戳
	 * @return String 日期字符串
	 */
	public static String unixTimestampToDate(long timestamp)
	{
		SimpleDateFormat sd = new SimpleDateFormat(FORMAT_LONG);
		sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return sd.format(new Date(timestamp));
	}

	public static void main(String[] args)
	{
		// long nowTime = dateToTimeStamp()
		// System.out.println("当前时间戳：" + nowTime);
		// // 晚上12点
		// String day = getNow(FORMAT_SHORT) + " 23:59:50";
		// System.out.println(day);
		// long thatTime = dateToTimeStamp(day);
		// System.out.println("晚上11点59分50秒的时间戳：" + thatTime);
		// System.out.println("中间相隔：" + (thatTime - nowTime) + " 毫秒");
		// int overSecond = (int) ((thatTime - nowTime) / 1000);
		// System.out.println("中间相隔：" + overSecond + " 秒");
		// Date dd = getDate(1514217600000l);
		// String aaa=DateUtil.format(DateUtil.addDay(new Date(), -1),
		// DateUtil.FORMAT_SHORT_NOLINE);
		// System.out.println("ssdkjf :"+
		// DateUtil.getNow(DateUtil.FORMAT_PATH));
		// Date lastTime = parse("20171206103120", FORMAT_FULL_NOLINE);
		// System.out.println("上个时间点：" + lastTime);
		// Date now = new Date();
		// System.out.println("当前时间点：" + now);
		// Date aTime = addHour(lastTime, 3) ;
		// System.out.println("上个时间点增加了3小时后的时间：" + aTime);
		// if(compareTime(aTime, new Date())>0){
		// System.out.println("还没到显示图片的时间哦！");
		// }else{
		// System.out.println("已经到了可以显示图片的时间了！！");
		// }

		// System.out.println(parse_CN("2018-05-01 11:22:11",FORMAT_SHORT_CN));
		//System.out.println(getUpAndDownDime(new Date(), "m", -30, 30));
		System.out.println(getUpAndDownDime(new Date(), "m", -2, 2));
		
		//System.err.println(compareDate("2018-05-01 11:22:13","2018-05-01 11:22:12")); 
		
		
	}

	/**
	 * 根据单位字段比较两个时间
	 * 
	 * @param date
	 *            时间1
	 * @param otherDate
	 *            时间2
	 * @param withUnit
	 *            单位字段，从Calendar field取值
	 * @return 等于返回0值, 大于返回大于0的值 小于返回小于0的值
	 */
	public static int compareTime(Date date, Date otherDate)
	{
		try
		{
			if (date.getTime() > otherDate.getTime())
			{
				System.out.println("date 超出当前时间");
				return 1;
			}
			else if (date.getTime() < otherDate.getTime())
			{
				System.out.println("date 已过期");
				return -1;
			}
			else
			{
				return 0;
			}
		}
		catch (Exception exception)
		{
			System.out.println("时间比较发生异常！");
			return -1;
		}
	}

	/**
	 * 获取当前时间的上下时间
	 * 
	 * @param formatId
	 *            时间标志 h-小时 m-分钟 s-秒
	 * @param index
	 *            移动多少
	 * @return
	 */
	public static String getUpAndDownDime(Date date, String formatId,
			int index, int span)
	{
		try
		{
			// 默认改分钟
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");
			Calendar c = new GregorianCalendar();
			c.setTime(date);// 设置参数时间
			if ("h".equals(formatId))
			{
				df = new SimpleDateFormat("yyyyMMddHH");
				c.add(Calendar.HOUR, index);
			}
			else if ("m".equals(formatId))
			{
				df = new SimpleDateFormat("yyyyMMddHHmm");
				c.add(Calendar.MINUTE, index);
			}
			else if ("s".equals(formatId))
			{
				df = new SimpleDateFormat("yyyyMMddHHmmss");
				c.add(Calendar.SECOND, index);
			}
			else
			{
				System.out.println("获取当前时间前后时未配置");
			}

			date = c.getTime(); // 这个时间就是日期往后推一天的结果
			// 得到起始时间
			String str = df.format(date);
			String str2 = df.format(date);
			// 得到时间末尾 并将最后一位分离
			String con = str.substring(str.length() - 1);
			str = str.substring(0, str.length() - 1);
			//获取时间倒数第二们
			String con2 = str2.substring(str2.length()-2);
			str2 = str2.substring(0, str2.length()-2);
			// 计算最后一位的正则匹配
			StringBuffer sb = new StringBuffer();
			sb.append("[");
			
			String expression = "[0123456789]";
			for (int i = Integer.parseInt(con); i < Integer.parseInt(con) + span; i++)
			{
				sb.append(i);
				if (i>9)
				{
					sb = new StringBuffer();
					sb.append("[");
					for (int j = Integer.parseInt(con2)/10; j < Integer.parseInt(con2)/10+(span/10); j++)
					{
						sb.append(j);
					}
					sb.append("]");
					str2 = str2 + sb.toString() + expression;
				}
			}
			sb.append("]");
			// 得到最终结果
			str = str + sb.toString();
			return str;
		}
		catch (Exception exception)
		{
			System.out.println("获取当前时间前后时间发生异常！");
		}

		return null;
	}
	/**
	 * 比较二个时期大小 
	 * 
	 * date1 = date2  返回 true;
	 * date1 < date2  返回true;
	 * date1 > date2  返回 false;
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static Boolean compareDate(String date1,String date2){	
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		try {			
			Date d1 = dateFormat.parse(date1);			
			Date d2 = dateFormat.parse(date2);			
		
			if(d1.equals(d2)){				
				return true;			
			}else if(d1.before(d2)){				
				return true;		
			}		
		} catch (ParseException e) {			
			e.printStackTrace();			
			System.out.println("compareDate（{}，{}）异常"+date1+","+date2);	
		}
		return false;
	}
	
	public static int compareBunch(String date1,String date2){	
		DateFormat dateFormat=new SimpleDateFormat("yyyyMMdd");		
		try {			
			Date d1 = dateFormat.parse(date1);			
			Date d2 = dateFormat.parse(date2);			
		
			if(d1.equals(d2)){				
				return 0;			
			}else if(d1.before(d2)){				
				return 1;		
			}		
		} catch (ParseException e) {			
			e.printStackTrace();			
			System.out.println("compareDate（{}，{}）异常"+date1+","+date2);	
		}
		return -1;
	}
	
	/**
     * 两个时间相差距离多少秒
     * @param str1 时间参数 1 格式：1990-01-01 12:00:00
     * @param str2 时间参数 2 格式：2009-01-01 12:00:00
     * @return 
     */
	public static int getDistanceTimes(String str1, String str2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date one;
        Date two;
        
        int sec = 0;
        try {
            one = df.parse(str1);
            two = df.parse(str2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            sec = (int)(diff / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return sec;
    }
}
