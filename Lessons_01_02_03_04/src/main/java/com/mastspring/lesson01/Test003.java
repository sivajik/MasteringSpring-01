package com.mastspring.lesson01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test003 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		Employee scott = ctx.getBean("Scott", Employee.class);
		Employee tiger = ctx.getBean("Tiger", Employee.class);
		Employee eliza = ctx.getBean("Elizabeth", Employee.class);
		System.out.println(scott);
		System.out.println(tiger);
		System.out.println(eliza);
		
		//Modern Annotations based configuration
		AnnotationConfigApplicationContext actx = new AnnotationConfigApplicationContext(DIExampleConfig.class);
		Employee john = actx.getBean("John", Employee.class);
		Employee paul = actx.getBean("Paul", Employee.class);
		System.out.println(john);
		System.out.println(paul);
	}
}

@Configuration
class DIExampleConfig {
	@Bean (name="John")
	public Employee whoIsCahrles() {
		return new Employee("Johnson", 4, (byte) 55, 250000);
	}
	
	@Bean (name="Paul")
	public Employee whoIsPaul() {
		Employee e = new Employee();
		e.setName("Paul Stew");
		e.setAge( (byte) 35);
		e.setEmpId(5);
		e.setSalary(50000);;
		return e;
	}
}