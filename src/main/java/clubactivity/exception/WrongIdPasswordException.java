package clubactivity.exception;

public class WrongIdPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WrongIdPasswordException(String message) {
		super(message);
	}
}
