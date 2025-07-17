package mx.com.santander.hexagonalmodularmaven.sale.model.exception;

public class SaleNotFound extends RuntimeException{
    private final String errorMsj;

    public SaleNotFound(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public SaleNotFound() {
        super();
        this.errorMsj = null;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}