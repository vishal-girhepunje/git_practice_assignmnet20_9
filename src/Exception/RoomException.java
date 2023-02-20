package Exception;



public class RoomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoomException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getMessage();
	}
  
}
