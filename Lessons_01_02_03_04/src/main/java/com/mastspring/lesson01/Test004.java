package com.mastspring.lesson01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test004 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		CollectionsExampleBean collBean = ctx.getBean("collectionExample", CollectionsExampleBean.class);
		System.out.println("From List: " + collBean.getMyList().get(1));
		System.out.println("From Set: " + collBean.getMySet().toArray()[1]);
		System.out.println("From Map: " + (Employee)collBean.getMyMap().get("personobj"));
		System.out.println("From Properties: " + collBean.getMyProperties().get("Occupation"));
	}
}