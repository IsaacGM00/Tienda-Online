package mx.com.santander.hexagonalmodularmaven.product.model.exception;

public class ProductException extends RuntimeException{
    private String errorMsj;

    public ProductException(){
        super();
    }

    public ProductException(String errorMsj){
        super(errorMsj);
    }

    public String getErrorMsj(){
        return errorMsj;
    }

    public void setErrorMsj(String errorMsj){
        this.errorMsj = errorMsj;
    }
}