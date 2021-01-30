package clubactivity.vo;

import java.util.Date;
import java.util.List;

public class AuthInfo {

	private String memberId;
	private int memberNumber;
	private String memberName;
	private String memberPhoneNumber;
	private Date memberRegisterDate;
	private Memberlevel memberlevel;
	private String memberWebsite;
	private Memberonline memberonline;
	private List<Messagecommand> messagecommand;

	public AuthInfo() {
		super();
	}

	public AuthInfo(String memberId, int memberNumber, String memberName, String memberPhoneNumber,
			Date memberRegisterDate, Memberlevel memberlevel, String memberWebsite, Memberonline memberonline,
			List<Messagecommand> messagecommand) {
		super();
		this.memberId = memberId;
		this.memberNumber = memberNumber;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberlevel = memberlevel;
		this.memberWebsite = memberWebsite;
		this.memberonline = memberonline;
		this.messagecommand = messagecommand;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public Date getMemberRegisterDate() {
		return memberRegisterDate;
	}

	public void setMemberRegisterDate(Date memberRegisterDate) {
		this.memberRegisterDate = memberRegisterDate;
	}

	public Memberlevel getMemberlevel() {
		return memberlevel;
	}

	public void setMemberlevel(Memberlevel memberlevel) {
		this.memberlevel = memberlevel;
	}

	public String getMemberWebsite() {
		return memberWebsite;
	}

	public void setMemberWebsite(String memberWebsite) {
		this.memberWebsite = memberWebsite;
	}

	public Memberonline getMemberonline() {
		return memberonline;
	}

	public void setMemberonline(Memberonline memberonline) {
		this.memberonline = memberonline;
	}

	public List<Messagecommand> getMessagecommand() {
		return messagecommand;
	}

	public void setMessagecommand(List<Messagecommand> messagecommand) {
		this.messagecommand = messagecommand;
	}

}