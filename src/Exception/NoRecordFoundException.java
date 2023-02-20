package Exception;

public class NoRecordFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoRecordFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}	
}
