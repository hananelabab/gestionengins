package ma.gestiongr.exeption.business;

public class BusinessExeption extends RuntimeException{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessExeption(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BusinessExeption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
