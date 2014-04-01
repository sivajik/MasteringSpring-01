package com.mastspring.lesson02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test010 {

	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		Human human = ctx.getBean("human", Human.class);
		System.out.println(human);
		
		Human spiderman = ctx.getBean("spiderman", Human.class);
		System.out.println(spiderman);
	}
}

class Human {
	private String fname;
	private String lname;
	private String location;
	private String job;

	Human() {}
	
	public Human(String fname, String lname, String location, String job) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.location = location;
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "Human [fname=" + fname + ", lname=" + lname + ", location="
				+ location + ", job=" + job + "]";
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}