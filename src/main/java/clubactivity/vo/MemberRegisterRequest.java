package clubactivity.vo;

public class MemberRegisterRequest {
	
	private String memberId;
	private String memberPassword;
	private String checkPassword;
	private String memberName;
	private String memberPhoneNumber;
	
	public MemberRegisterRequest() {
		super();
	}

	public MemberRegisterRequest(String memberId, String memberPassword, String checkPassword, String memberName,
			String memberPhoneNumber) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.checkPassword = checkPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
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

	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
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
	
	public boolean isPasswordEqualToCheckPassword() {
		return memberPassword.equals(checkPassword);
	}
}
