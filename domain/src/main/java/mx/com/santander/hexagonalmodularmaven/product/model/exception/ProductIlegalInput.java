package mx.com.santander.hexagonalmodularmaven.product.model.exception;

public class ProductIlegalInput extends RuntimeException{
    private final String errorMsj;

    public ProductIlegalInput(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public ProductIlegalInput() {
        super();
        this.errorMsj = null;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}