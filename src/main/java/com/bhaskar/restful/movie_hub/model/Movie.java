package com.bhaskar.restful.movie_hub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Model class for movie.
 * It has various properties of a movie, and related behavior.
 * 
 * To convert it into JSON object using Moxy and the JAXB annotations
 * MOXy is the default JSON-binding provider for JAX-RS applications. Added the dependency of moxy in pom.xml
 * @author Bhaskar Marepalli
 */
@XmlRootElement
@XmlType(propOrder={"movieId","title","genre","yearReleased","director","leadActors","productionCompany","summary","ratings","reviews"})
@Entity
public class Movie {

	@Id
	private int movieId;
	private String title;	
	private int ratings;
	private String genre;
	private String summary;
	private String leadActors;
	private String director;
	private String reviews;
	private int yearReleased;
	private String productionCompany;
	
	public Movie() { }
		
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getLeadActors() {
		return leadActors;
	}
	public void setLeadActors(String leadActors) {
		this.leadActors = leadActors;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	
	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getProductionCompany() {
		return productionCompany;
	}
	public void setProductionCompany(String productionCompany) {
		this.productionCompany = productionCompany;
	}
	
	public String toString() {
		return title +" " + yearReleased + " " + productionCompany;
	}
	
}
