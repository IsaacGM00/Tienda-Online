package mx.com.santander.hexagonalmodularmaven.product.model.exception;

public class ProductNotFound extends RuntimeException{
    private String errorMsj;

    public ProductNotFound(String errorMsj) {
        super(errorMsj);
    }

    public ProductNotFound(){
        super();
    }

    public String getErrorMsj() {
        return errorMsj;
    }

    public void setErrorMsj(String errorMsj) {
        this.errorMsj = errorMsj;
    }
}