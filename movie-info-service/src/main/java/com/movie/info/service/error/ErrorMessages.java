package com.movie.info.service.error;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessages {

	 private HttpStatus statusCode;
	 private String message;
	
}
