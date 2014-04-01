package com.mastspring.lesson04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class Test019 {
	public static void main(String[] args) {
		//Observe ClassPathXMLApplicationContext being used here:
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/resabstraction-app-context.xml");
		ResourceBucket bkt = ctx.getBean("rb", ResourceBucket.class);
		System.out.println(bkt);

		//Observe FileSystemXmlApplicationContext being used here:
		ApplicationContext fctx = new FileSystemXmlApplicationContext("classpath:META-INF/spring/resabstraction-app-context.xml");
		ResourceBucket bkt1 = fctx.getBean("rb", ResourceBucket.class);
		System.out.println(bkt1);
	}
}

class ResourceBucket {
	Resource resource1;
	Resource resource2;
	Resource resource3;
	
	public void setResource1(Resource resource1) {
		this.resource1 = resource1;
	}
	public void setResource2(Resource resource2) {
		this.resource2 = resource2;
	}
	public void setResource3(Resource resource3) {
		this.resource3 = resource3;
	}
	ResourceBucket() {}
	
	public ResourceBucket(Resource resource1, Resource resource2, Resource resource3) {
		super();
		this.resource1 = resource1;
		this.resource2 = resource2;
		this.resource3 = resource3;
	}
	
	public String toString() {
		return "Resource 1: " + resource1 + "\nResource 2: " + resource2 + "\nResource 3: " + resource3;
	}
}