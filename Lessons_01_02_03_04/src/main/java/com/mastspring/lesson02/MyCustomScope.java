package com.mastspring.lesson02;

import java.util.HashMap;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

public class MyCustomScope implements Scope{
	static final HashMap<String, Integer> map = new HashMap<String, Integer>();
	static final HashMap<String, Object> mapOfObjects = new HashMap<String, Object>();
	static final int MAX_COUNT = 3;
	
	/*
	 * The following method returns the object from the underlying scope. (non-Javadoc)
	 * For the first 3 times, you get SAME object from map.
	 * For the 4th time onwards, it gives you a brand new object.
	 */
	public Object get(String arg0, ObjectFactory<?> arg1) {
		if (map.containsKey(arg0)) {
			int currentInstanceCount = (Integer) map.get(arg0);
			if (currentInstanceCount >= MAX_COUNT) {
				return arg1.getObject(); // return a new object
			} else {
				currentInstanceCount = currentInstanceCount + 1;
				map.put(arg0, currentInstanceCount);
				return mapOfObjects.get(arg0); // return existing object from map
			}
		} else { // create a new object and keep it in map for next 3 calls.
			Object obj = arg1.getObject();
			map.put(arg0, 1);
			mapOfObjects.put(arg0, obj);
			return obj;
		}
	}

	/*
	 * The following method obtains the conversation identifier for the underlying scope
	 */
	public String getConversationId() {
		return "Ben & Jerrys Scoop";
	}

	/*
	 * The following method registers the callbacks the scope should execute when it is destroyed or when 
	 * the specified object in the scope is destroyed. 
	 */
	public void registerDestructionCallback(String arg0, Runnable arg1) {
		// TODO Auto-generated method stub
	}

	// The following method removes the object from the underlying scope
	public Object remove(String arg0) {
		System.out.println("Deleting from Scope : " + arg0);
		return null;
	}

	public Object resolveContextualObject(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}

class FourthEmployee {
	public FourthEmployee() throws InterruptedException {
		System.out.println(">>> I am being instantiated: " + (new java.util.Date()).toString());
		Thread.sleep(1000);
	}
}