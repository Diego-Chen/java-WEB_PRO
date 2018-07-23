/**
 * 
 */
package com.cs.test;

import java.util.Locale;

import com.cs.pro.utils.ByteUtil;


/**
 * @author Administrator
 *
 */
public class ByteMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		byte数组截取当然要提到效率非常高的arraycopy，java中调用方式如下：
		System.arraycopy(src, srcPos, dest, destPos, length)
		参数解析：
		src：byte源数组
		srcPos：截取源byte数组起始位置（0位置有效）
		dest,：byte目的数组（截取后存放的数组）
		destPos：截取后存放的数组起始位置（0位置有效）
		length：截取的数据长度
		*/
		
		
		String apdus = "02020866000000010110805200000B2018071914003562B51E0401020700A40000021001010308002000000312345601040500B095001F010505805C00020401060500B201C4170107";
		byte[] apdusByte = ByteUtil.hexStr2Byte(apdus);
		//数据头
		//020208
		//66000000
		byte[] header = new byte[7];
		System.arraycopy(apdusByte, 0, header, 0, 7);
		int size = ByteUtil.hexToInt(header, 2, 1) ;
		//将apdusByte去掉头
		System.arraycopy(apdusByte, 7, apdusByte, 0, apdusByte.length - 7);
		
		
		for(int i= 0 ; i < size ;i++){
			//存放指令头
			byte[] subHeader = new byte[3];
		    System.arraycopy(apdusByte, 0, subHeader, 0, 3);
		    int len = ByteUtil.hexToInt(subHeader, 2, 1);
		    //存放指令
		  	byte[] apdu = new byte[len];
		    System.arraycopy(apdusByte, 3, apdu, 0, len);
		    System.arraycopy(apdusByte, len+3, apdusByte, 0, apdusByte.length - len - 3);
		    String temp  = ByteUtil.hexToStr(apdu);
		    temp = temp.toUpperCase(Locale.getDefault());
		    if(temp.indexOf("805200000B") >=0 && temp.length() == 32){
		    	System.out.println(temp.substring(10, 18));
		    	System.out.println(temp.substring(18, 24));
		    	System.out.println(temp.substring(24, 32));
		    }
		    System.out.println("apdu:"+temp);
		}
	    
	}

}
