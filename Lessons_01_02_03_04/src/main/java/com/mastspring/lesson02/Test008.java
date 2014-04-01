package com.mastspring.lesson02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test008 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		CustomisingBeanNature bean = ctx.getBean("customBean", CustomisingBeanNature.class);
		((AbstractApplicationContext) ctx).close();
	}
}