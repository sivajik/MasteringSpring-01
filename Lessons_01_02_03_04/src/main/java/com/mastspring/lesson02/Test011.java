package com.mastspring.lesson02;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test011 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		System.out.println(ctx.getBean(SomeCustomBean.class));
		System.out.println(ctx.getBean(SomeCustomBean.class));
		System.out.println(ctx.getBean(SomeCustomBean.class));
		
		
		MyBeanFactory beanFactory = ctx.getBean("&beanfactory", MyBeanFactory.class);
		System.out.println(beanFactory);
	}
}

class SomeCustomBean {
	private String name;
	SomeCustomBean() {}
	SomeCustomBean(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Bean : " + name + ", [" + getClass().getName() + "@" + Integer.toHexString(hashCode()) + "]";
	}
}

class MyBeanFactory implements FactoryBean<SomeCustomBean> {

	public SomeCustomBean getObject() throws Exception {
		String name = "SKI-" + (new java.util.Random()).nextInt(9999);
		return new SomeCustomBean(name);
	}

	public Class getObjectType() {
		return SomeCustomBean.class;
	}

	public boolean isSingleton() {
		return true; // Keep it as false and see you get new obj everytime
	}
	
}