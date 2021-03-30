package clubactivity.vo;

import java.io.Serializable;

public class Messagecommand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memberNumber;
	private int messageNumber;
	private String title;
	private String message;
	private boolean read;
	private int fromMemberNumber;
	private Member member;

	public Messagecommand() {
		super();
	}

	public Messagecommand(int memberNumber, int messageNumber, String title, String message, boolean read,
			int fromMemberNumber, Member member) {
		super();
		this.memberNumber = memberNumber;
		this.messageNumber = messageNumber;
		this.title = title;
		this.message = message;
		this.read = read;
		this.fromMemberNumber = fromMemberNumber;
		this.member = member;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
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

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public int getFromMemberNumber() {
		return fromMemberNumber;
	}

	public void setFromMemberNumber(int fromMemberNumber) {
		this.fromMemberNumber = fromMemberNumber;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}
