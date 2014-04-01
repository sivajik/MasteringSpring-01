package com.mastspring.lesson02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import com.mastspring.lesson01.Employee;

public class MyBeanPostProcessor implements BeanPostProcessor, Ordered{

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// Literally I can do anything here with bean object. Like I can completely
		// skip the instantiation process conditionally.
		System.out.println( "BI: My Bean : " + beanName + "@" + bean);
		if (bean instanceof Employee) { // dangerous code
			Employee e = (Employee) bean; 
			e.setName("Michael Jackson");
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println( "AI: My Bean : " + beanName + "@" + bean);
		return bean;
	}

	public int getOrder() {
		// Play around by changing order 0 to 100 then this runs
		// after YourBeanPostProcessor as lesser order = higher preference.
		return 0;
	}
}

class YourBeanPostProcessor implements BeanPostProcessor, Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println( "BI: Your Bean : " + beanName + "@" + bean);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println( "AI: Your Bean : " + beanName + "@" + bean);
		if (bean instanceof Employee) { // dangerous code
			Employee e = (Employee) bean; 
			e.setName("Elvis");
		}
		return bean;
	}

	public int getOrder() {
		return 4;
	}
}
