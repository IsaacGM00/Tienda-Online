package mx.com.santander.hexagonalmodularmaven.sale.model.exception;

public class SaleException extends RuntimeException{
    private final String errorMsj;

    public SaleException() {
        super();
        this.errorMsj = null;
    }

    public SaleException(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}