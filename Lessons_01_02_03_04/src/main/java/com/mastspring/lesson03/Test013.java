package com.mastspring.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test013 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		BeanZero zero = ctx.getBean("myBeanZeroBeanName", BeanZero.class);
		System.out.println(zero);
		
		BeanOne one = ctx.getBean("beanone", BeanOne.class);
		System.out.println(one);
		
		BeanTwoDependsOnBeanOne two = ctx.getBean("seemyname", BeanTwoDependsOnBeanOne.class);
		System.out.println(two);
	}
}

// Like any regular class.
class BeanZero {
	private String village;

	public BeanZero(String village) {
		super();
		this.village = village;
	}
	
	public String toString() {
		return village + " is wonderful village";
	}
}

@Component("beanone")
@Scope ("singleton")
class BeanOne {
	private String city;
	
	BeanOne() {}
	
	@Value ("Reading")
	public void setCity(String city) {
		this.city = city;
	}
	
	// I am creating a bean instance with below name.
	@Bean (name="myBeanZeroBeanName")
	BeanZero getBeanZero() {
		return new BeanZero("Bracknell");
	}
	
	public String toString() {
		return city + " was a good city";
	}
}

@Component ("beantwo")
@Scope ("prototype")
class BeanTwoDependsOnBeanOne {
	private String country;
	private BeanOne beanOne;

	public BeanTwoDependsOnBeanOne() {}
	
	// I am not passing country name here...
	// I pass this from @Configuration
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Autowired
	public void setBeanOne(BeanOne beanOne) {
		this.beanOne = beanOne;
	}
	
	public String toString() {
		return country + " is full of fried chicken shops";
	}
}

// This is like XML representation of config
@Configuration
class MyConfiguration {
	
	@Bean (name="seemyname")
	public BeanTwoDependsOnBeanOne whoAmI() {
		BeanTwoDependsOnBeanOne obj = new BeanTwoDependsOnBeanOne();
		obj.setCountry("United Kingdom");
		return obj;
	}
}
