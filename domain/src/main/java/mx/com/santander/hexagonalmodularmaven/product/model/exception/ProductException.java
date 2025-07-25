package mx.com.santander.hexagonalmodularmaven.product.model.exception;

public class ProductException extends RuntimeException{
    private final String errorMsj;

    public ProductException() {
        super();
        this.errorMsj = null;
    }

    public ProductException(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}