/**
 * 
 */
package com.cs.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @author Administrator
 *
 */
public class DateTool {

	public static String[] presuppose = {"yyyy","MM","dd","HH","mm","ss","SSS"};
	
	public static void main(String[] args) {
		//当前时间的各种格式
		{
			Date date = new Date();
			String patten = "yyyy/MM/dd HH:mm:ss";
			SimpleDateFormat df = new SimpleDateFormat(patten);
			String returnValue = df.format(date);
			System.out.println(returnValue);
		}
		
		//时间戳转对象
		{
			//得到时间对象
			long d = System.currentTimeMillis();
			Date date = new Date(d);
			System.out.println(date);
		}
		
		//时间字符串根据格式转时间对象
		{
			String d = "20190130144025";
			String patten = "yyyyMMddHHmmss";
			SimpleDateFormat df = new SimpleDateFormat(patten);
			try {
				Date date = df.parse(d);
				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//当前时间往前，往后
		{
			Date date = new Date();
			//当前时间
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			//后挪3天
			cal.add(Calendar.DATE, 3);
			//新的时间
			Date newDate = cal.getTime();
			String patten = "yyyy/MM/dd HH:mm:ss";
			SimpleDateFormat df = new SimpleDateFormat(patten);
			String returnValue = df.format(newDate);
			System.out.println(returnValue);
		}
		
		//计算距今天数
		{
			
			Date date;
			try {
				String d = "20190129144025";
				String patten = "yyyyMMddHHmmss";
				SimpleDateFormat df = new SimpleDateFormat(patten);
				date = df.parse(d);
				
				long t = Calendar.getInstance().getTime().getTime();
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				long t1 = c.getTime().getTime();
				int day =  (int) (t / 1000 - t1 / 1000) / 3600 / 24;
				System.out.println("距今" + day +"天");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		//时间串变时间戳
		{
			String d = "20190129144025";
			String patten = "yyyyMMdd";
			try {
				long timestamp = new SimpleDateFormat(patten).parse(d).getTime();
				System.out.println("时间戳:" + timestamp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//比较时间
		{
			String s = "20190129144025";
			String e = "20190129184025";
			String patten = "yyyyMMddHHmmss";
			SimpleDateFormat df = new SimpleDateFormat(patten);
			try {
				Date sd = df.parse(s);
				Date ed = df.parse(e);
				if(sd.getTime() > ed.getTime()){
					System.out.println("sd比较大");
				}else{
					System.out.println("ed比较大");
				}
				
				if(sd.before(ed)){
					System.out.println("sd比较小");
				}else{
					System.out.println("ed比较小");
				}
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
	



