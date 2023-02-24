package com.movie.info.service.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movie.info.service.error.MovieAlreadyExistsException;
import com.movie.info.service.error.MovieNotFound;
import com.movie.info.service.error.NoSuchMovieExistsException;
import com.movie.info.service.models.Movie;
import com.movie.info.service.reposistry.MovieRepo;

@Service
public class MovieImplementation implements MovieServices {
	
	@Autowired
	MovieRepo repo;

	@Override 
	public void saveMovie(Movie movie) {
		
		Movie existMovie = repo.findById(movie.getMovieId()).orElse(null);
		if(existMovie == null) {
			repo.save(movie);
		}
		else {
			throw new MovieAlreadyExistsException("InSide controller level");
		}
		
			
//		if (repo.existsById(movie.getMovieId())) {
//			 throw new  MovieNotFound();
//		}
//		 else {
//			repo.save(movie);
//		}
	}
	
	@Override
	public Movie getMovie(Integer id) {
			

		Movie movie = repo.findById(id).get();
		if(movie == null) {
			throw new NoSuchMovieExistsException();
			
		}
		else {
			return movie;
		}
		
		
	}
	

	@Override
	public List<Movie> getMovieAll() {
		
		return repo.findAll();
	}

	@Override
	public void deleteMovie(Integer id) {
		Movie movie = repo.findById(id).get();
		if(movie == null) {
			throw new NoSuchElementException();
		}
		else {
			repo.deleteById(id);
		}
		
	}

	@Override
	public Movie updatetMovie(Movie movie) {
		Movie movie2 = repo.save(movie);
		return movie2;
	}
}