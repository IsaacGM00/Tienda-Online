package mx.com.santander.hexagonalmodularmaven.client.adapter;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseClient {
    private int httpStatus;
    private LocalDateTime date;
    private String msj;
    private String error;

    public ErrorResponseClient(HttpStatus httpStatus, String msj, String error){
        this.httpStatus = httpStatus.value();
        this.date = LocalDateTime.now();
        this.msj = msj;
        this.error = error;
    }
}