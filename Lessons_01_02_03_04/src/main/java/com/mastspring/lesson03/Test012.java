package com.mastspring.lesson03;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test012 {
	public static void main(String[] args) {
		// Classic XML based configuration
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		CinemaTheatre oc = ctx.getBean("oc", CinemaTheatre.class);
		System.out.println(oc);
		System.out.println(ctx);
	}
}

class Cinema {
	String name;
	int length;

	Cinema() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String toString() {
		return "Movie " + name + " runs for " + length + " minutes";
	}
}

class CinemaScreen {
	int numOfSeats;
	String screenName;

	CinemaScreen() {
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String toString() {
		return "Screen " + screenName + " has got " + numOfSeats + " Seats";
	}
}

class MovieSchedule {
	Cinema cinema;
	CinemaScreen screen;
	
	MovieSchedule() {}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public void setScreen(CinemaScreen screen) {
		this.screen = screen;
	}	
	
	public String toString() {
		return cinema.name + " Will be on " + screen.screenName;
	}
}


class CinemaTheatre {
	@Autowired
	Cinema[] listing; // using it on property names

	Set<CinemaScreen> screens;

	String name; // we configure this in XML. So mix and match is always possible.

	@Autowired // Used on Maps. Here keys will be bean names, Keys must be always String
	Map<String, MovieSchedule> tonightSchedule;
	
	CinemaTheatre() {
	}

	public CinemaTheatre(Cinema[] listing, Set<CinemaScreen> screens,
			String name) {
		super();
		this.listing = listing;
		this.screens = screens;
		this.name = name;
	}

	public Cinema[] getListing() {
		return listing;
	}

	public void setListing(Cinema[] listing) {
		this.listing = listing;
	}

	public Set<CinemaScreen> getScreens() {
		return screens;
	}

	// Not a classic setter method but still we could use
	// Example for Collections
	@Autowired
	public void setThisScreens(Set<CinemaScreen> screens) {
		this.screens = screens;
	}

	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	private ApplicationContext aContext; //autowired automatically.
	
	public String toString() {
		String screensStr = "";
		for (CinemaScreen scr : screens) {
			screensStr += scr + "\n";
		}

		String listingStr = "";
		for (Cinema cinema : listing) {
			listingStr += cinema + "\n";
		}
		
		String scheduleStr = "";
		for ( String schedule : tonightSchedule.keySet()) {
			scheduleStr += schedule + ")" + tonightSchedule.get(schedule) + "\n"; 
		}

		return "\n" + name + "\n\n" + listingStr + "\n" + screensStr + "\n" + scheduleStr + "\n" + aContext;
	}
}