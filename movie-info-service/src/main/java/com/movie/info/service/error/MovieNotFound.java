package com.movie.info.service.error;


import lombok.Data;

@Data

public class MovieNotFound extends RuntimeException {
	private String message;
}
