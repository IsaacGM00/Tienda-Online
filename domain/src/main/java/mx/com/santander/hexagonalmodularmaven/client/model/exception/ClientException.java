package mx.com.santander.hexagonalmodularmaven.client.model.exception;

public class ClientException extends RuntimeException {
    
    private final String errorMsj;

    public ClientException() {
        super();
        this.errorMsj = null;
    }

    public ClientException(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}