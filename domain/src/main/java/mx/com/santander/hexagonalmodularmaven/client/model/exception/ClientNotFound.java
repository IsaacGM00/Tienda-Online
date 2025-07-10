package mx.com.santander.hexagonalmodularmaven.client.model.exception;

public class ClientNotFound extends RuntimeException{

    private String errorMsj;

    public ClientNotFound(String errorMsj) {
        super(errorMsj);
    }

    public ClientNotFound(){
        super();
    }

    public String getErrorMsj() {
        return errorMsj;
    }

    public void setErrorMsj(String errorMsj) {
        this.errorMsj = errorMsj;
    }
}