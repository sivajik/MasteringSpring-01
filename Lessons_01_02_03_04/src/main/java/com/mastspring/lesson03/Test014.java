package com.mastspring.lesson03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

public class Test014 {
	public static void main(String[] args) {
		// See this, we are using another application context here... 
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DataSrcConfig.class);
		System.out.println(ctx.getBean("oracleds", MyDataSource.class));
		System.out.println(ctx.getBean("oracleds", MyDataSource.class));
		System.out.println(ctx.getBean("mysqlds", MyDataSource.class));
		System.out.println(ctx.getBean("hsqlds", MyDataSource.class));
		((AbstractApplicationContext) ctx).close(); 
	}
}

class MyDataSource {
	String dsInformation;
	
	public MyDataSource(String dsInformation) {
		super();
		this.dsInformation = dsInformation;
	}
	
	public static void initSomething() {
		//System.out.println("I am running some static init code ...");
	}
	
	public static void kill() {
		System.out.println("I am dieing.. Please help me...");
	}
	
	public String toString() {
		return dsInformation + "{" + getClass().getName() + "@" + Integer.toHexString(hashCode()) + "}";
	}
}

@Configuration
class DataSrcConfig {
	
	@Bean (name="oracleds", initMethod="initSomething", destroyMethod="kill")
	//@Scope ("prototype") // Run this code by un commenting this line
	public MyDataSource oracleDS() {
		return new MyDataSource("{OracleDriver+oracle@localhost+scott/tiger}");
	}
	
	@Bean (name="mysqlds") // See no init method this time.
	public MyDataSource mysqlDS() {
		return new MyDataSource("{MySQLDriver+MySQL@localhost+root/root}");
	}
	
	@Bean // See no bean name give so method name is bean name
	public MyDataSource hsqlds() {
		return new MyDataSource("{HSQLDriver+HSQLL@localhost+hsql/hsql}");
	}
}