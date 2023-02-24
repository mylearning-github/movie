package com.movie.info.service.error;





import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalErrorHandling extends ResponseEntityExceptionHandler   {

	
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		return new ResponseEntity<>("This method is not allowed please check it out", HttpStatus.BAD_REQUEST); 
	}
	
	@ExceptionHandler(MovieAlreadyExistsException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ErrorMessages handleMovieAlreadyExistsException(MovieAlreadyExistsException me) {
		
		return new ErrorMessages(HttpStatus.CONFLICT, "This Movie is all ready exist");
	}
	
//	@ExceptionHandler(NoSuchMovieExistsException.class)
//	public ResponseEntity<ErrorMessages> errhandleNoSuchMovieExistsException(NoSuchMovieExistsException me) {
//		ErrorMessages em = new ErrorMessages();
//		em.setStatusCode(HttpStatus.NOT_FOUND);
//		em.setMessage("No Movie exist on this Id");
//		return	new ResponseEntity<ErrorMessages>(em, HttpStatus.NOT_FOUND);
//		
//	}
	
	@ExceptionHandler(NoSuchMovieExistsException.class)
	public ErrorMessages errhandleNoSuchMovieExistsException(NoSuchMovieExistsException me) {
		ErrorMessages em = new ErrorMessages();
		em.setStatusCode(HttpStatus.NOT_FOUND);
		em.setMessage("No Movi found on this Id");
		return	em;
		
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorMessages> noSuchElementxception(NoSuchElementException me) {
		ErrorMessages em = new ErrorMessages();
		em.setStatusCode(HttpStatus.NOT_FOUND);
		em.setMessage("No Such element exist");
		return	new ResponseEntity<ErrorMessages>(em, HttpStatus.NOT_FOUND);
		
	}
	
	
}
	

