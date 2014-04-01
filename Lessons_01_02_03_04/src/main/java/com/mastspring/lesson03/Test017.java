package com.mastspring.lesson03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test017 {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:META-INF/spring/app-context.xml");
		MovieRecommender reco = ctx.getBean("movierecommender", MovieRecommender.class);
		reco.showComedyRecommendations();
		reco.showActionRecommendations();
		reco.showHorrorRecommendations();
	}
}

 @Retention (RetentionPolicy.RUNTIME)
 @Target ({ElementType.PARAMETER, ElementType.FIELD})
 @interface CinemaCategory {
	 String value();
 }

class Movie {
	String name;

	Movie() {
	}

	Movie(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return ">>> Movie: " + name;
	}
}

class MovieCatalog {
	List<Movie> movies;

	MovieCatalog() {
	}

	MovieCatalog(List<Movie> catalogOfMovies) {
		this.movies = catalogOfMovies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public String toString() {
		String str = "";
		for (Movie m : movies) {
			str += m + "\n";
		}
		return str;
	}
}

@Component("movierecommender")
class MovieRecommender {
	@Autowired
	@CinemaCategory("comedy")
	MovieCatalog comedyMovies;

	@Autowired
	@CinemaCategory("action")
	MovieCatalog actionMovies;
	
	
	@Autowired
	@Qualifier("horror")
	MovieCatalog horrorMovies;

	public MovieRecommender() {
	}

	public void showComedyRecommendations() {
		System.out.println("Comedy Recommendations : \n" + comedyMovies);
	}

	public void showActionRecommendations() {
		System.out.println("Action Recommendations : \n" + actionMovies);
	}
	
	public void showHorrorRecommendations() {
		System.out.println("Horror Recommendations : \n" + horrorMovies);
	}
}