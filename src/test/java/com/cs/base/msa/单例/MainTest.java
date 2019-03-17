/**
 * 
 */
package com.cs.base.msa.单例;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * @author Administrator
 *
 */



public class MainTest {
	
	/**
	 * 反射测试
	 * @throws Exception
	 */
	public static void reflectTest() throws Exception
	{
		{
			HungrySingleton ton = HungrySingleton.hslton();
			Class cla = HungrySingleton.class;
			Constructor co = cla.getDeclaredConstructor(null);
			co.setAccessible(true);
			HungrySingleton ton1 = (HungrySingleton) co.newInstance(null);
			System.out.println(ton);
			System.out.println(ton1);
		}
		
		{
			LazySingleton ton = LazySingleton.lzTon();
			Class cla = LazySingleton.class;
			Constructor co = cla.getDeclaredConstructor(null);
			co.setAccessible(true);
			LazySingleton ton1 = (LazySingleton) co.newInstance(null);
			System.out.println(ton);
			System.out.println(ton1);
		}
		
		{
			SynthesisSingleton ton = SynthesisSingleton.ssl();
			Class cla = SynthesisSingleton.class;
			Constructor co = cla.getDeclaredConstructor(null);
			co.setAccessible(true);
			SynthesisSingleton ton1 = (SynthesisSingleton) co.newInstance(null);
			System.out.println(ton);
			System.out.println(ton1);
		}
		
		{
			EnumSingleton ton = EnumSingleton.TON;
			Class cla = EnumSingleton.class;
			Constructor co = cla.getDeclaredConstructor(null);
			co.setAccessible(true);
			EnumSingleton ton1 = (EnumSingleton) co.newInstance(null);
			System.out.println(ton);
			System.out.println(ton1);
		}
		
	}
	
	/**
	 * 序列化测试
	 */
	public static void serializ() throws Exception{
		{
			HungrySingleton ton = HungrySingleton.hslton();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/HungrySingleton.txt"));
			oos.writeObject(ton);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/HungrySingleton.txt")); 
			HungrySingleton ton1 = (HungrySingleton) ois.readObject();
			ois.close();
			System.out.println(ton);
			System.out.println(ton1);
		}
		
		{
			LazySingleton ton = LazySingleton.lzTon();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/LazySingleton.txt"));
			oos.writeObject(ton);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/LazySingleton.txt")); 
			LazySingleton ton1 = (LazySingleton) ois.readObject();
			ois.close();
			System.out.println(ton);
			System.out.println(ton1);
		}
		
		
		{
			SynthesisSingleton ton = SynthesisSingleton.ssl();
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/SynthesisSingleton.txt"));
			oos.writeObject(ton);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/SynthesisSingleton.txt")); 
			SynthesisSingleton ton1 = (SynthesisSingleton) ois.readObject();
			ois.close();
			System.out.println(ton);
			System.out.println(ton1);
		}
		
		
		{
			EnumSingleton ton = EnumSingleton.TON;
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:/EnumSingleton.txt"));
			oos.writeObject(ton);
			oos.flush();
			oos.close();
			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:/EnumSingleton.txt")); 
			EnumSingleton ton1 = (EnumSingleton) ois.readObject();
			ois.close();
			System.out.println(ton);
			System.out.println(ton1);
		}
	}
	
	public static void main(String[] args) throws Exception{
		serializ();
		reflectTest();
	}
	
}
