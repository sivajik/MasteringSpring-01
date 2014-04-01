package com.mastspring.lesson03;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test015 {
	public static void main(String[] args) {
		// Reading bean definitions from XML but see we are using MessageSource.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		System.out.println(ctx.getBean("messageSource", MessageSource.class));
		
		MessageSource msg = (MessageSource) ctx;
		String message = msg.getMessage("fn", new Object[] {"English"}, "SOME DEFAULT TEXT", Locale.UK);
		System.out.println(message);
		
		String message1 = msg.getMessage("fn", new Object[] {"English"}, "SOME DEFAULT TEXT", Locale.US);
		System.out.println(message1);
		
		String message2 = msg.getMessage("fn", new Object[] {"English"}, "SOME DEFAULT TEXT", null);
		System.out.println(message2);
	}
}