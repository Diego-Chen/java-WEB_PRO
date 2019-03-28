/**
 * 
 */
package com.cs.hash;

import java.util.Hashtable;

/**
 * @author Administrator
 *
 */
public class HashTableTest {
	public static void main(String[] args) {
		Hashtable<String, Integer> table = new Hashtable<String, Integer>();
//		table.put("key0", null);
//		table.put(null, 10);
		table.put("key1", 1);
		table.put("key2", 2);
		table.put("key3", 3);
		table.put("key4", 4);
		table.put("key5", 5);
		table.put("key6", 6);
		table.put("key7", 7);
		table.put("key8", 8);
		table.put("key9", 9);
		
		//哈希表无序
		//哈希冲突下，单个桶会有多个条目
	}
}
