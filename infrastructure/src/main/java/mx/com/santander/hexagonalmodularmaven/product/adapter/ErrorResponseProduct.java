package mx.com.santander.hexagonalmodularmaven.product.adapter;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseProduct {
    private int httpStatus;
    private LocalDateTime date;
    private String msj;
    private String error;

    public ErrorResponseProduct(HttpStatus httpStatus, String msj, String error){
        this.httpStatus = httpStatus.value();
        this.date = LocalDateTime.now();
        this.msj = msj;
        this.error = error;
    }
}