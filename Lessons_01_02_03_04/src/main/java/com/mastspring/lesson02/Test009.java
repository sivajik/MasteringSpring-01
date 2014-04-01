package com.mastspring.lesson02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mastspring.lesson01.Employee;

public class Test009 {
	public static void main(String[] args) {
		// I am using a brand new xml here so that BPP effect applies to only beans in this file
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/bpp-app-context.xml");
		Employee scott = ctx.getBean("Scotty", Employee.class);
		System.out.println("Lets see who is our employee: " + scott);
	}
}