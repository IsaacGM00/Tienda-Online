package mx.com.santander.hexagonalmodularmaven.client.model.exception;

public class ClientException extends RuntimeException{
    
    private String errorMsj;

    public ClientException(){
        super();
    }

    public ClientException(String errorMsj){
        super(errorMsj);
    }

    public String getErrorMsj(){
        return errorMsj;
    }

    public void setErrorMsj(String errorMsj){
        this.errorMsj = errorMsj;
    }

}