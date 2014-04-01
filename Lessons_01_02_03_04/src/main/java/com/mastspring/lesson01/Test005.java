package com.mastspring.lesson01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test005 {

	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		FunnyCompany funnyBean = ctx.getBean("myCompany", FunnyCompany.class);
		System.out.println(funnyBean);
	}
}