package mx.com.santander.hexagonalmodularmaven.photo.model.exception;

public class PhotoException extends RuntimeException {

	private static final long serialVersionUID = 2L;

	private String errorMessage;

	public PhotoException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public PhotoException() {

	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
