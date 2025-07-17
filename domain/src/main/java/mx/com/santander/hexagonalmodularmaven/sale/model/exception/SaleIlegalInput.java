package mx.com.santander.hexagonalmodularmaven.sale.model.exception;

public class SaleIlegalInput extends RuntimeException{
    private final String errorMsj;

    public SaleIlegalInput(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public SaleIlegalInput() {
        super();
        this.errorMsj = null;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}