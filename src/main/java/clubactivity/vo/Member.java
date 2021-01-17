package clubactivity.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private int memberNumber;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberPhoneNumber;
	private Date memberRegisterDate;
	private Memberlevel memberlevel;
	private String memberWebsite;

	public Member() {
		super();
	}

	public Member(int memberNumber, String memberId, String memberPassword, String memberName, String memberPhoneNumber,
			Date memberRegisterDate, Memberlevel memberlevel, String memberWebsite) {
		super();
		this.memberNumber = memberNumber;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberlevel = memberlevel;
		this.memberWebsite = memberWebsite;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void changePassword(String oldPassword, String newPassword) {
		this.memberPassword = newPassword;
	}

	public void changeNumber(String newNumber) {
		this.memberPhoneNumber = newNumber;
	}

}