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
		String a = "abcdddefabc";
		
		listBuffer2(a);
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
