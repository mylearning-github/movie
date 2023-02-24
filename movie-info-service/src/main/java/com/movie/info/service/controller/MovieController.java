package com.movie.info.service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.movie.info.service.error.ErrorMessages;
import com.movie.info.service.models.Movie;
import com.movie.info.service.reposistry.MovieRepo;
import com.movie.info.service.service.MovieImplementation;

@RestController
public class MovieController {

	@Autowired
	MovieImplementation mi;
	
	
	
	@PostMapping("/saveMovie") 
	private ErrorMessages saveMovie(@RequestBody Movie movie) { 
		mi.saveMovie(movie);
		ErrorMessages er = new ErrorMessages();
		er.setStatusCode(HttpStatus.CREATED);
		er.setMessage("Data Saved Successfully");
		return er;
	}
	
	
	@GetMapping("/getMovie/{id}")
	public ResponseEntity<Movie> getMovie(@PathVariable int id) {
		Movie movie = mi.getMovie(id);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}
	
	@GetMapping("/getAllMovie")
	public List<Movie> getAllMovie() {
		return mi.getMovieAll();
	}
	
	@DeleteMapping("deleteMovie/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable int id){
		mi.deleteMovie(id);
		return new ResponseEntity<>("Movie deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("updateMovie")
	public String updateMovie(@RequestBody Movie movie) {
		mi.updatetMovie(movie);
		return "Movie Updated Successfully";
	}

	
}
