package com.movie.info.service.error;

import lombok.Data;

@Data
public class MovieExistExpection extends RuntimeException {

	public String message;
	
}
