package com.mastspring.lesson03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test016 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		System.out.println("1. Spring Container : " + ctx);
		MyCustomEventPublisher publisher = ctx.getBean("pubaware", MyCustomEventPublisher.class);
		publisher.shout();
	}
}

class MyCustomEvent extends ApplicationEvent {
		
	public MyCustomEvent(Object source) {
		super(source);
	}
	
	public String toString() {
		return "EVT 1234@" + source.toString();
	}
}

// Silently this guy listens to any event happenings
@Component
class MyCustomEventApplicationListener implements ApplicationListener<MyCustomEvent> {

	public void onApplicationEvent(MyCustomEvent arg0) {
		System.out.println(">>>> I am still listening..");
		System.out.println(">>>> I got a : " + arg0);
	}
}

/*
 * whenever container see a bean that implements ApplicationEventPublisherAware then
 * it passes ApplicationEventPublisher in fact this is "Spring Container itself"
 */
@Component ("pubaware")
class MyCustomEventPublisher implements ApplicationEventPublisherAware {
	ApplicationEventPublisher pub;
	
	MyCustomEventPublisher() {}
	
	// watch this space. We never configure this but we get this.
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		System.out.println("Container will set me this value... ");
		System.out.println("2. Spring Container : " + arg0);
		this.pub = arg0;		
	}
	
	public void shout() {
		MyCustomEvent event = new MyCustomEvent(this);
		System.out.println("About to publish : " + event);
		pub.publishEvent(event);
	}	
}