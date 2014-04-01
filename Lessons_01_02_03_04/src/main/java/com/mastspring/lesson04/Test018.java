package com.mastspring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

public class Test018 {
	public static void main(String[] args) {
		//Obsreve XML i am loading this time is different.
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/resabstraction-app-context.xml");
		MyResourceLoaderAwareImpl impl = ctx.getBean("myresldrimpl", MyResourceLoaderAwareImpl.class);
		System.out.println("1)" + ctx);
		System.out.println("2)" + impl.getLoader());
		System.out.println("3)" + impl.getMyLoaderAutoWired());
	}
}

@Component ("myresldrimpl")
class MyResourceLoaderAwareImpl implements ResourceLoaderAware {
	// not auto wired
	private ResourceLoader loader;
	
	@Autowired
	private ResourceLoader myLoaderAutoWired;
	
	public ResourceLoader getMyLoaderAutoWired() {
		return myLoaderAutoWired;
	}

	public ResourceLoader getLoader() {
		return loader;
	}

	/*
	 * Just because ResourceLoader is ApplicationContext, dont use it load beans.
	 * Use it just to load resources only.
	 */
	public void setResourceLoader(ResourceLoader arg0) {
		loader = arg0;
		System.out.println("This resource loader is spring container itself..");
	}
}