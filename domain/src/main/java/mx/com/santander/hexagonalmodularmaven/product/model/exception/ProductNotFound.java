package mx.com.santander.hexagonalmodularmaven.product.model.exception;

public class ProductNotFound extends RuntimeException{
    private final String errorMsj;

    public ProductNotFound(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public ProductNotFound() {
        super();
        this.errorMsj = null;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}