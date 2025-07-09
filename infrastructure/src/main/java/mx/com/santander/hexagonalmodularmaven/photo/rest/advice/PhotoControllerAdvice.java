package mx.com.santander.hexagonalmodularmaven.photo.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.photo.model.exception.PhotoException;

@ControllerAdvice
public class PhotoControllerAdvice {
	
	@ExceptionHandler(PhotoException.class)
	public ResponseEntity<String> handleEmtyInput(PhotoException emptyInputException){
		return new ResponseEntity<>(emptyInputException.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}

}
