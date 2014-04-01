package com.mastspring.lesson01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test001 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		MessageWisherService msgWisher1 = ctx.getBean("consolewisher", MessageWisherService.class);
		msgWisher1.wish();
		
		// Modern Annotations based configuration
		AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(MyCongif.class);
		MessageWisherService msgWisher2 = actx.getBean("annotationconfigconsolewisherbean", MessageWisherService.class);
		msgWisher2.wish();
	}
}

@Configuration
class MyCongif {
	@Bean (name="annotationconfigconsolewisherbean")
	public MessageWisherService cIonsolewisher() {
		MessageWisherService mws = new ConsoleMessageWisher();
		mws.setWishingMessage("This is Still Rocking...");
		//System.out.println("Will I be executing this code again and again ??");
		return mws;
	}
}