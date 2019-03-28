/**
 * 
 */
package com.cs.pro.init;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



/**
 * @author Administrator
 * 监听ContextRefreshedEvent事件，当所有的bean都初始化完成并被成功装载后会触发该事件，
 * 实现ApplicationListener<ContextRefreshedEvent>接口可以收到监听动作，然后可以写自己的逻辑。
 */
@Component("InitTest")
public class InitTest implements ApplicationListener<ContextRefreshedEvent>{
	@Override
	public void onApplicationEvent(ContextRefreshedEvent evt)
	{
		evt.getApplicationContext().getParent();
		init();
	}	
	
	public static void init(){
		for(int i=0; i<20 ;i++){
			for(int j=0;j<=i;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
