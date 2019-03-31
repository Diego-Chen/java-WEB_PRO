/**
 * 
 */
package com.cs.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class StringTest {
	
	public static void main(String[] args) {
		String a = "";
		
		
//		String aString2 = "b1";
//		final String cString2 = "1";//标识cString2指针是不可变的
//		String bString2 = "b"+cString2;
//		System.out.println(aString2 == bString2);
		
//		String aString2 = "b1";
//	    String cString2 = "1";//标识cString2指针是不可变的
//		String bString2 = "b"+cString2;
//		System.out.println(aString2 == bString2);
		
		czzfc();
		
	}
	
	/**
	 * 查找子字符串
	 */
	public static void czzfc(){
		String superS = "thjabdddefabc";
		String t = "abc";
		int re = -1;
		for (int i = 0; i < superS.length(); i++) {
			if(superS.charAt(i) == t.charAt(0)){
				if(i+t.length()-1<superS.length()){
					for (int j = 0; j < t.length(); j++) {
						if(superS.charAt(i+j) != t.charAt(j)){
							break;
						}
						if(j== t.length()-1){
							re = i;
						}
					}
				}
			}
		}
		System.out.println(re);
		
		
		
	}
	
	
	/**
	 * 二分法查找字符
	 */
	public static void eff(){
		int[] a = {1,3,3,3,3,5,7,8};
		int len = 5;
		int m = 3;
		int re = -1;
		for (int i = 0; i < len; i++) {
			int temp = a[len/2];
			if(temp > m){
				len = len/2;
				continue;
			}else if(temp < m){
				i = len/2;
				continue;
			}else if(temp == m){
				re = len/2;
				for (int j = re; j >=0 ; j--) {
					if(a[j] != m){
						re = j+1;
						break;
					}
				}
				break;
			}
		}
		System.out.println(re);
		
		
		
	}
	
	
	
	//查找首个重复出现的字符
	public static void cfzfc(){
		String s = "qywyer23tdd";
		char[] t = s.toCharArray();
		int count = t.length;
		int len = count;
		char re = '!';
		for (int i = 0; i < len ; i++) {
			for(int j = i+1 ; j < len ;j++){
				if(t[i] == t[j]){
					re = t[i];
					break;
				}
			}
			if(re != '!'){
				break;
			}
		}
		System.out.println(re);
		
	}
	
	
	/**
	 * 利用list的判断包含，从字符数组中选出未添加的字符到buffer中
	 * @param s
	 */
	public static void listBuffer(String s){
		char[] t = s.toCharArray();
		List cs = new ArrayList();
		StringBuffer sb = new StringBuffer();
		for (char o : t) {
			if(cs.contains(o)){
				continue;
			}else{
				sb.append(o);
				cs.add(o);
			}
		}
		System.out.println(sb.toString());
	}
	
	
	//adacd
	public static void listBuffer1(String s){
		List cs = new ArrayList();
		StringBuffer sb = new StringBuffer(s);
		int m = s.length();
		for (int i = 0; i < m; i++) {
			
			System.out.println(i);
			//已经出现过，需要删除
			if(cs.contains(sb.charAt(i))){
				
				sb.deleteCharAt(i);
				i--;
				m--;
				
			}
			//没出现过，不删除，添加到已出现数组
			else{
				cs.add(sb.charAt(i));
			}
		}
		System.out.println(sb.toString());
	}
	
	
	public static void listBuffer2(String s){
		StringBuffer sb = new StringBuffer(s);
		StringBuffer bb = new StringBuffer();
		bb.append(sb.charAt(0));
		for (int i = 1; i < sb.length(); i++) {
			
			for (int j = 0; j < bb.length(); j++) {
				if(sb.charAt(i) == bb.charAt(j)){
					break;
				}
				if(j == bb.length()-1){
					bb.append(sb.charAt(i));
				}
			}
		}
		System.out.println(bb.toString());
	}
		
	
}
