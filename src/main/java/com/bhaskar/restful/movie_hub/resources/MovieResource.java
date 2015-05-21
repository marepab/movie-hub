package com.bhaskar.restful.movie_hub.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bhaskar.restful.movie_hub.model.Movie;
import com.bhaskar.restful.movie_hub.service.MovieService;


/**
 * Movie resource (exposed at "movies" path)
 * Consumes and produces JSON format.
 * @author Bhaskar Marepalli
 */
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
public class MovieResource {
	
	MovieService movieService = new MovieService();
	
	/**
	 * Method handling HTTP GET requests to get all Movies. 
	 * @return Response JSON format, status code returned is 200 OK
	 */
	@GET	
	public Response getAllMovies() {
		List<Movie> allMovies = movieService.getAllMovies();
		GenericEntity<List<Movie>> list = new GenericEntity<List<Movie>>(allMovies){};
		return Response.ok(list).build();
	}

	/**
	 * Method handling HTTP GET request to get a single Movie based on the movieId
	 * The response is in JSON format. The path param accepts a param movieId and converts into int.
	 * @param int movieId
	 * @return Response JSON format, status code returned is 200 OK
	 */
	@GET
	@Path("/{movieId}")
	public Response getMovie(@PathParam("movieId") int movieId) {
		Movie movie = movieService.getMovie(movieId);
		return Response.ok(movie).build();
		
	}
	
	/**Method to add a new movie object. Handles HTTP POST requests. 
	 * Consumes a JSON object. 
	 * @param movie
	 * @return Response JSON format, status code returned is 201 created. 
	 * 		   And Response also contains header locations with URI of the newly created Movie abject.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMovie(Movie movie, @Context UriInfo uriInfo) {
		Movie newMovie =  movieService.addMovie(movie);
		String newMovieId = String.valueOf(newMovie.getMovieId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newMovieId).build();
		return	Response.created(uri).entity(newMovie).build();	
	}
	
	/**Method handling HTTP PUT requests to update a Movie object
	 * Returns the JSON format of the updated object
	 * @param Movie movie 
	 * @param int movieId - id of the movie to be updated.
	 * @return Response JSON format, status code returned is 200 OK
	 */
	@PUT
	@Path("/{movieId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateMovie(Movie movie, @PathParam("movieId") int movieId) {
		Movie updatedMovie =  movieService.updateMovie(movie);
		return Response.ok(updatedMovie).build();
	}
	
	/**Method handling HTTP DELETE requests to remove a movie.
	 * Does not return anything. The status code returned is 204. 
	 * @param movieId
	 * @return Response noContent 204
	 */
	@DELETE
	@Path("/{movieId}")	
	public Response removeMovie(@PathParam("movieId") int movieId) {
		movieService.removeMovie(movieId);
		return Response.noContent().build();
	}
}
