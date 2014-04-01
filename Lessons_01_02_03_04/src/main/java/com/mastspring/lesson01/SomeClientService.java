package com.mastspring.lesson01;

public class SomeClientService {
	private String nameOfService;
	
	private SomeClientService (String nameOfService) {
		this.nameOfService = nameOfService;
		//System.out.println("New SomeClientService Object in Creation...");
	}
	
	// Has to be static.
	public static SomeClientService getInstance(String whatIsMyName) {
		return new SomeClientService(whatIsMyName);
	}
	
	public void printServiceDetails() {
		System.out.println("We are happy to serve: " + nameOfService);
	}
}