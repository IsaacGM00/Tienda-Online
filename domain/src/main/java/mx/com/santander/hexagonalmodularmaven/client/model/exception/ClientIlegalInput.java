package mx.com.santander.hexagonalmodularmaven.client.model.exception;

public class ClientIlegalInput extends RuntimeException{
    
    private String errorMsj;

    public ClientIlegalInput(String errorMsj){
        super(errorMsj);
    }

    public ClientIlegalInput(){
        super();
    }

    public String getErrorMesg() {
        return errorMsj;
    }

    public void setErrorMsg(String errorMsj) {
        this.errorMsj = errorMsj;
    }
}