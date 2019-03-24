/**
 * 
 */
package com.cs.hash;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Administrator
 *
 */
public class HashMapTest {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put(null, 10);
		map.put("key0", null);
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		map.put("key4", 4);
		map.put("key5", 5);
		map.put("key6", 6);
		map.put("key7", 7);
		map.put("key8", 8);
		map.put("key9", 9);

		
		Map m = Collections.synchronizedMap(map);
		System.out.println("key1".hashCode());
		System.out.println("1100100010110110110010".length());
		
//		for(Entry<String,Integer> entry : map.entrySet()){
//			System.out.println(entry.getKey() +"-"+ entry.getValue());
//		}
		
		System.out.println(map.size());
		
		
		try {
			Class<?> mapType = map.getClass();
			Method capacity;
			capacity = mapType.getDeclaredMethod("capacity");
			capacity.setAccessible(true);
			System.out.println("capacity : " + capacity.invoke(map));
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
		
		
		
		
		
		
	}
}
