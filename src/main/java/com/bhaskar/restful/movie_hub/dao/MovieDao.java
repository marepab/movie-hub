package com.bhaskar.restful.movie_hub.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bhaskar.restful.movie_hub.model.Movie;

/**
 * Dao class for Movie object. It has methods for all crud operations.
 * This class does the changes in the database.
 * @author Bhaskar Marepalli
 *
 */
public class MovieDao {
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory(); 
	Session session = sessionFactory.openSession();
	
	/**
	 * Method to get all the movies
	 * @return List of all Movie objects
	 */
	public List<Movie> getAllMovies() {
		List<Movie> movies = null;
		try {
			session.beginTransaction();
			movies = session.createQuery("from Movie").list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return movies;
	}
	
	/**
	 * Method to get a single movie object based on the movieId
	 * @param int movieId
	 * @return Movie
	 */
	public Movie getMovie(int movieId) {
		Movie movie = null;
		try {
			session.beginTransaction();
			String hql = "FROM Movie M WHERE M.movieId = :movieId";
			Query query = session.createQuery(hql);
			query.setParameter("movieId",movieId);
			List<Movie> results = query.list();
			if(results != null) {
				movie = results.get(0);
			}
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
		return movie;
	}

	/**
	 * Method to add a new movie.
	 * @param Movie movie
	 * @return Movie - the newly added movie object is returned
	 */
	public Movie addMovie(Movie movie) {
		try {
			session.beginTransaction();
			session.save(movie);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return movie;
		
	}

	/**
	 * Method to update a movie.
	 * @param Movie movie
	 * @return Movie - the updated movie object is returned
	 */
	public Movie updateMovie(Movie movie) {
		try {
			session.beginTransaction();
			session.update(movie);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			sessionFactory.close();
		}
		return movie;
	}

	/**
	 * Method to remove a movie based on the movieId
	 * @param int movieId
	 * @return Movie - the removed movie is returned
	 */
	public void removeMovie(int movieId) {
		try {
			session.beginTransaction();
			Movie movie = (Movie)session.get(Movie.class, movieId);
			session.delete(movie);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}		
	
}
