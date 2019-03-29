package com.cs.base.msa.排序;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class ListTest {
	public static void main(String[] args) {
		//集合排序
//		List<String> list = new ArrayList<String>();
//		list.add("刘媛媛");
//		list.add("王硕");
//		list.add("李明");
//		list.add("张迪");
//		list.add("刘布");	
//		//升序
//		Collections.sort(list,Collator.getInstance(java.util.Locale.CHINA));//注意：是根据的汉字的拼音的字母排序的，而不是根据汉字一般的排序方法
//	
//		//降序
//		Collections.reverse(list);//不指定排序规则时，也是按照字母的来排序的
//
//		//数组排序
//		System.out.println();
//		String[] names = {"王林",  "杨宝", "李镇", "刘迪", "刘波"}; 
//		Arrays.sort(names, Collator.getInstance(java.util.Locale.CHINA));
		
		
//		UserInfo u1 = new UserInfo();
//		u1.setId(1);
//		u1.setAge(18);
//		u1.setName("A");
//		
//		UserInfo u2 = new UserInfo();
//		u2.setId(2);
//		u2.setAge(10);
//		u2.setName("B");
//		
//		UserInfo u3 = new UserInfo();
//		u3.setId(3);
//		u3.setAge(19);
//		u3.setName("C");
//		
//		UserInfo u4 = new UserInfo();
//		u4.setId(4);
//		u4.setAge(10);
//		u4.setName("D");
//		
//		List<UserInfo> us = new ArrayList<UserInfo>();
//		us.add(u1);
//		us.add(u2);
//		us.add(u3);
//		us.add(u4);
//	
//		Collections.sort(us);
//		
//		for (UserInfo userInfo : us) {
//			System.out.println(JSON.toJSONString(userInfo));
//		}
		maopao();
	}
	
	
	
	//冒泡排序
	public  static void maopao(){
		int[] ins = {2,4,3,1};
		for (int i = 0; i < ins.length; i++) {
			for (int j = 0; j < ins.length-1-i; j++) {
				if(ins[j] > ins[j+1]){
					int temp = ins[j];
					ins[j] = ins[j+1];
					ins[j+1] = temp;
				}
			}
		}
		
		for (int i : ins) {
			System.out.println(i);
		}
	}
	
	
	
}
