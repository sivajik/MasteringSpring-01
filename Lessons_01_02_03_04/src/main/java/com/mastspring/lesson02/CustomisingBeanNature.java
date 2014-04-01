package com.mastspring.lesson02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CustomisingBeanNature implements InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware{

	public void destroy() throws Exception {
		System.out.println("In DispoableBean.destroy() method..");		
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("In InitializingBean.afterPropertiesSet() method..");
	}

	public void customInit() {
		System.out.println("In Custom init() method..");
	}
	
	public void customDestroy() {
		System.out.println("In Custom destroy() method..");
	}
	
	@PostConstruct
	public void jsr250Init() {
		System.out.println("In JSR 250 init() method..");
	}
	
	@PreDestroy
	public void jsr250Destroy() {
		System.out.println("In JSR 250 destroy() method..");
	}

	public void setBeanName(String name) {
		System.out.println(" I got bean name as : " + name);
	}

	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		for(String beanName : arg0.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}
}
