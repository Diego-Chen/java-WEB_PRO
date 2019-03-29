/**
 * 
 */
package com.cs.异常;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class ExceptionTest {
	
	public void test(){
		try {
//			int re = 3/0;
//			System.out.println(re);
//			System.out.println(Integer.valueOf("ab"));
//			Integer.parseInt("10L");
		} catch (NumberFormatException  e) {
			// TODO Auto-generated catch block
			System.out.println("忽略NumberFormatException异常");
		} catch (ArithmeticException e1) {
			// TODO Auto-generated catch block
			System.out.println("忽略ArithmeticException异常");
		} finally {
			System.out.println("最终程序进入这里");
		}
	}
	
	public  void test1(){
		try {
			int re = 3/0;
			System.out.println(re);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("e.getMessage()" + e.getMessage());
			System.out.println("e.toString()" + e.toString());
			System.out.println("e.getStackTrace()" +e.getStackTrace());
			e.printStackTrace();
		} finally {
			System.out.println("最终程序进入这里");
		}
	}
	
	public  void test2(){
		try {
			ArrayList<Integer> ins = new ArrayList<Integer>();
			ins.add(1);
			
			ins.remove(0);
			ins.remove(0);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("e.getMessage()" + e.getMessage());
			System.out.println("e.toString()" + e.toString());
			System.out.println("e.getStackTrace()" +e.getStackTrace());
			e.printStackTrace();
		} finally {
			System.out.println("最终程序进入这里");
			System.out.println("最终程序进入这里1");
		}
	}
	

	public  int avg(int number1 ,int number2) throws MyException{
		if(number1 < 0 || number2 < 0){
			throw new MyException("传入参数小于0");
		}
		if(number1 > 100 || number2 > 100){
			throw new MyException("传入参数大于100");
		}
		return number1 * number2;
		
	}
	
	
//	public static void main(String[] args) {
//		ExceptionTest t = new ExceptionTest();
//		try {
//			int re = t.avg(60, 59);
//			System.out.println(re);
//		}catch (NullPointerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
//	public static void start() throws IOException, RuntimeException{
//		 
//		   throw new RuntimeException("Not able to Start");
//	}
//		 
//	public static void main(String args[]) {
//	   try {
//	         start();
//	   } catch (Exception ex) {
//	           ex.printStackTrace();
//	   } 
//	}
	
	@SuppressWarnings("finally")
	public  static int start(){
		try {
			for (int i = 2; i >= -2; i--) {
				System.out.println(12/i) ;
				System.out.println("i==" +i);
			}
		}catch (RuntimeException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return 100;
		}
	}
	
	
	public static void main(String[] args) {
		try {
//			System.out.println("接口实现类：");
//			for (Class<?> c : getAllAssignedClass(Intf.class)) {
//				System.out.println(c.getName());
//			}
			System.out.println("子类：");
			for (Class<?> c : getAllAssignedClass(Exception.class)) {
				System.out.println(c.getName());
			}
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	 
	/**
	* 获取同一路径下所有子类或接口实现类
	* 
	* @param intf
	* @return
	* @throws IOException
	* @throws ClassNotFoundException
	*/
	public static List<Class<?>> getAllAssignedClass(Class<?> cls) throws IOException,ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		for (Class<?> c : getClasses(cls)) {
			if (cls.isAssignableFrom(c) && !cls.equals(c)) {
				classes.add(c);
			}
		}
		return classes;
	}
	 
	/**
	* 取得当前类路径下的所有类
	* 
	* @param cls
	* @return
	* @throws IOException
	* @throws ClassNotFoundException
	*/
	public static List<Class<?>> getClasses(Class<?> cls) throws IOException,ClassNotFoundException {
		String pk = cls.getPackage().getName();
		String path = pk.replace('.', '/');
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(path);
		return getClasses(new File(url.getFile()), pk);
	}
	 
	/**
	* 迭代查找类
	* 
	* @param dir
	* @param pk
	* @return
	* @throws ClassNotFoundException
	*/
	private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!dir.exists()) {
			return classes;
		}
		for (File f : dir.listFiles()) {
			if (f.isDirectory()) {
				classes.addAll(getClasses(f, pk + "." + f.getName()));
			}
			String name = f.getName();
			if (name.endsWith(".class")) {
				classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
			}
		}
		return classes;
	}
	
}
