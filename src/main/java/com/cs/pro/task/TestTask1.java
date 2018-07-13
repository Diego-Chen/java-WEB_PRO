/**
 * 
 */
package com.cs.pro.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 *
 */
@Component
public class TestTask1 {
	@Scheduled(cron = "/5 * * * * ?")
	public void update ()
	{
		System.err.println("TestTask1五秒执行一次定时任务");
	}
}
