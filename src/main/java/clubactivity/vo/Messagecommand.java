package clubactivity.vo;

public class Messagecommand {

	private String memberNumber;
	private String title;
	private String message;

	public Messagecommand() {
		super();
	}

	public Messagecommand(String memberNumber, String title, String message) {
		super();
		this.memberNumber = memberNumber;
		this.title = title;
		this.message = message;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
