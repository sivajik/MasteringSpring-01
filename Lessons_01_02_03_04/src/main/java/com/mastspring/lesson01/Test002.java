package com.mastspring.lesson01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test002 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		SomeClientService iceCreamService = ctx.getBean("icecreamservice", SomeClientService.class);
		iceCreamService.printServiceDetails();
		
		//Modern Annotations based configuration
		AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(MyCongifFactoryMethod.class);
		SomeClientService popCornService = actx.getBean("popcornservice", SomeClientService.class);
		popCornService.printServiceDetails();
	}
}

@Configuration
class MyCongifFactoryMethod {
	@Bean (name="popcornservice")
	public SomeClientService someMethodName() {
		return SomeClientService.getInstance("Pop Corn");
	}
}