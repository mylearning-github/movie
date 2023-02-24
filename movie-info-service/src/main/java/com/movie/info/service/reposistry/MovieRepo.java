package com.movie.info.service.reposistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.info.service.models.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

	public Movie findByname(String name);

	
}
