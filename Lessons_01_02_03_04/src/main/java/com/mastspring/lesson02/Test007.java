package com.mastspring.lesson02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test007 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		System.out.println(ctx.getBean("emp1", FourthEmployee.class));
		System.out.println(ctx.getBean("emp1", FourthEmployee.class));
		System.out.println(ctx.getBean("emp1", FourthEmployee.class));
		System.out.println(ctx.getBean("emp1", FourthEmployee.class));
		System.out.println(ctx.getBean("emp1", FourthEmployee.class));
	}
}