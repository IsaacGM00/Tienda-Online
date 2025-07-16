package mx.com.santander.hexagonalmodularmaven.client.model.exception;

public class ClientNotFound extends RuntimeException {

    private final String errorMsj;

    public ClientNotFound(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public ClientNotFound() {
        super();
        this.errorMsj = null;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}