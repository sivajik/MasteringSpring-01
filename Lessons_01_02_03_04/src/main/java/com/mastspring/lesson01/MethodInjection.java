package com.mastspring.lesson01;

import org.springframework.context.ApplicationContextAware;

public abstract class MethodInjection implements ApplicationContextAware {

	public void process() {
		// Now you got the new instance, do whatever you want to do with this..
		BeanB b = createBeanB();
		System.out.println("But my code is using spring specific APIs, which I dont like...");
	}

	abstract BeanB createBeanB() ;
}

class BeanB {
	// Nothing...
}