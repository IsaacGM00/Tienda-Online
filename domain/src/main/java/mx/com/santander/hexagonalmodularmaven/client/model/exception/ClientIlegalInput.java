package mx.com.santander.hexagonalmodularmaven.client.model.exception;

public class ClientIlegalInput extends RuntimeException {

    private final String errorMsj;

    public ClientIlegalInput(String errorMsj) {
        super(errorMsj);
        this.errorMsj = errorMsj;
    }

    public ClientIlegalInput() {
        super();
        this.errorMsj = null;
    }

    public String getErrorMsj() {
        return errorMsj;
    }
}