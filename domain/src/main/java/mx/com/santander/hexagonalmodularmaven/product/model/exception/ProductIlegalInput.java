package mx.com.santander.hexagonalmodularmaven.product.model.exception;

public class ProductIlegalInput extends RuntimeException{
    private String errorMsj;

    public ProductIlegalInput(String errorMsj){
        super(errorMsj);
    }

    public ProductIlegalInput(){
        super();
    }

    public String getErrorMesg() {
        return errorMsj;
    }

    public void setErrorMsg(String errorMsj) {
        this.errorMsj = errorMsj;
    }
}