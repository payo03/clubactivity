package clubactivity.exception;

public class MessageSendException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MessageSendException(String message) {
		super(message);
	}
}
