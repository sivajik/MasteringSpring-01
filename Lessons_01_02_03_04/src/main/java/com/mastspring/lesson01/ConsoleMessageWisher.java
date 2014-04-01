package com.mastspring.lesson01;


public class ConsoleMessageWisher implements MessageWisherService {

	private String wishingMessage;

	public String getWishingMessage() {
		return wishingMessage;
	}

	public void setWishingMessage(String msg) {
		this.wishingMessage = msg;
	}

	public void wish() {
		System.out.println("\n\n" + wishingMessage + "\n");
	}
}
