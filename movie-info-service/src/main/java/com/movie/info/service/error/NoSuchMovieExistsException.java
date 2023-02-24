package com.movie.info.service.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoSuchMovieExistsException extends RuntimeException {

	private String message;
}
