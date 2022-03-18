package ma.gestiongr.exeption.technical;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllegalNullParamException extends TechnicalExeption{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IllegalNullParamException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IllegalNullParamException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
