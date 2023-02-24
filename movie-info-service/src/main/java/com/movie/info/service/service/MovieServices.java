package com.movie.info.service.service;

import java.util.List;

import com.movie.info.service.models.Movie;

public interface MovieServices {

	public void saveMovie(Movie movie);
	public Movie getMovie(Integer id);
	public List<Movie> getMovieAll();
	public void deleteMovie(Integer id);
	public Movie updatetMovie(Movie movie);
	
}
