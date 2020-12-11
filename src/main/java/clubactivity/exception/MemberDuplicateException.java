package clubactivity.exception;

public class MemberDuplicateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberDuplicateException(String message) {
		super(message);
	}
}
