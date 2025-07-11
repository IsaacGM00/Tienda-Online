package mx.com.santander.hexagonalmodularmaven.product.rest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import mx.com.santander.hexagonalmodularmaven.product.adapter.ErrorResponseProduct;
import mx.com.santander.hexagonalmodularmaven.product.model.exception.ProductException;
import mx.com.santander.hexagonalmodularmaven.product.model.exception.ProductIlegalInput;
import mx.com.santander.hexagonalmodularmaven.product.model.exception.ProductNotFound;

@ControllerAdvice
public class ControllerAdviceProduct {
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponseProduct> handleProductExeption(ProductException productException){
        ErrorResponseProduct errorResponseProduct = new ErrorResponseProduct(HttpStatus.BAD_REQUEST,
        "Producto sin reconocer", productException.getMessage());
        return new ResponseEntity<>(errorResponseProduct, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductIlegalInput.class)
    public ResponseEntity<ErrorResponseProduct> handleProductIlegalInput(ProductIlegalInput productIlegalInput){
        ErrorResponseProduct errorResponseProduct = new ErrorResponseProduct(HttpStatus.BAD_REQUEST, 
        "Datos erróneos", productIlegalInput.getMessage());
        return new ResponseEntity<>(errorResponseProduct, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<ErrorResponseProduct>handleProductNotFound(ProductNotFound productNotFound){
        ErrorResponseProduct errorResponseProduct = new ErrorResponseProduct(HttpStatus.NOT_FOUND,
        "Producto sin encontrar", productNotFound.getMessage());
        return new ResponseEntity<>(errorResponseProduct,HttpStatus.NOT_FOUND);
    }
}