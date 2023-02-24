package com.movie.info.service.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieAllFieldsRequiredExpection extends RuntimeException {

	
	public String message;
}
