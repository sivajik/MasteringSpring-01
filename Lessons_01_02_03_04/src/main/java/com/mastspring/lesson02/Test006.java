package com.mastspring.lesson02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test006 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		System.out.println("1st call: " + ctx.getBean("queen", Queen.class));
		System.out.println("2nd call: " + ctx.getBean("queen", Queen.class));
		System.out.println("3rd call: " + ctx.getBean("queen", Queen.class));
		System.out.println("======== now lets call soldier ========");
		System.out.println("1st call: " + ctx.getBean("soldier", Soldier.class));
		System.out.println("2nd call: " + ctx.getBean("soldier", Soldier.class));
		System.out.println("3rd call: " + ctx.getBean("soldier", Soldier.class));
	}
}

class Queen {
	Queen() {
		//System.out.println("Hey World, I am THE Queen");
	}
	
	private Soldier personalSec;

	public Soldier getPersonalSec() {
		return personalSec;
	}

	public void setPersonalSec(Soldier personalSec) {
		this.personalSec = personalSec;
	}
}

class Soldier {
	Soldier() {
		//System.out.println("Morning world, I am a Soldier, I obey queen's orders...");
	}
}