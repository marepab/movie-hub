package com.bhaskar.restful.movie_hub.service;

import java.util.List;

import com.bhaskar.restful.movie_hub.dao.MovieDao;
import com.bhaskar.restful.movie_hub.model.Movie;

/**
 * Service class for Movie. 
 * Provides methods to perform various actions on the Movie object
 * @author Bhaskar Marepalli
 */
public class MovieService {

	private MovieDao movieDao = new MovieDao();
	
	/**
	 * Method to get all the movies
	 * @return ArrayList of all Movie objects
	 */
	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}
	
	/**
	 * Method to get a single movie object based on the movieId
	 * @param int movieId
	 * @return Movie
	 */
	public Movie getMovie(int movieId) {
		return movieDao.getMovie(movieId);
	}
	
	/**
	 * Method to add a new movie.
	 * @param Movie movie
	 * @return Movie - the newly added movie object is returned
	 */
	public Movie addMovie(Movie movie) {
		return movieDao.addMovie(movie);
	}
	
	/**
	 * Method to update a movie.
	 * @param Movie movie
	 * @return Movie - the updated movie object is returned
	 */
	public Movie updateMovie(Movie movie) {
		return movieDao.updateMovie(movie);
	}
	
	/**
	 * Method to remove a movie based on the movieId
	 * @param int movieId
	 * @return Movie - the removed movie is returned
	 */
	public void removeMovie(int movieId) {
		movieDao.removeMovie(movieId);		
	}
}
