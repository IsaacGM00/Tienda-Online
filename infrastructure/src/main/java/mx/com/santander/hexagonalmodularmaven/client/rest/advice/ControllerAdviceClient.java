package mx.com.santander.hexagonalmodularmaven.client.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.client.adapter.ErrorResponseClient;
import mx.com.santander.hexagonalmodularmaven.client.model.exception.ClientException;
import mx.com.santander.hexagonalmodularmaven.client.model.exception.ClientIlegalInput;
import mx.com.santander.hexagonalmodularmaven.client.model.exception.ClientNotFound;

@ControllerAdvice
public class ControllerAdviceClient {

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ErrorResponseClient> handleClientExeption(ClientException clientException){
        ErrorResponseClient errorResponseClient = new ErrorResponseClient(HttpStatus.BAD_REQUEST,
        "Cliente sin reconocer", clientException.getMessage());
        return new ResponseEntity<>(errorResponseClient, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientIlegalInput.class)
    public ResponseEntity<ErrorResponseClient> handleClientIlegalInput(ClientIlegalInput clientIlegalInput){
        ErrorResponseClient errorResponseClient = new ErrorResponseClient(HttpStatus.BAD_REQUEST, 
        "Datos erróneos", clientIlegalInput.getMessage());
        return new ResponseEntity<>(errorResponseClient, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientNotFound.class)
    public ResponseEntity<ErrorResponseClient>handleClientNotFound(ClientNotFound clientNotFound){
        ErrorResponseClient errorResponseClient = new ErrorResponseClient(HttpStatus.NOT_FOUND,
        "Cliente sin encontrar", clientNotFound.getMessage());
        return new ResponseEntity<>(errorResponseClient,HttpStatus.NOT_FOUND);
    }
}