package clubactivity.vo;

public class AdminMemberCommand {

	private int memberNumber;
	private String memberLevelDescription;
	private String memberName;
	private String memberPassword;
	private String memberId;
	private String memberPhoneNumber;
	private int memberLevelCode;

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberLevelDescription() {
		return memberLevelDescription;
	}

	public void setMemberLevelDescription(String memberLevelDescription) {
		this.memberLevelDescription = memberLevelDescription;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPhoneNumber() {
		return memberPhoneNumber;
	}

	public void setMemberPhoneNumber(String memberPhoneNumber) {
		this.memberPhoneNumber = memberPhoneNumber;
	}

	public int getMemberLevelCode() {
		return memberLevelCode;
	}

	public void setMemberLevelCode(int memberLevelCode) {
		this.memberLevelCode = memberLevelCode;
	}

	public void insertLevelCode(AdminMemberCommand adminMemberCommand) {
		if (adminMemberCommand.getMemberLevelDescription().equals("회원")) {
			adminMemberCommand.setMemberLevelCode(0);
		} else {
			adminMemberCommand.setMemberLevelCode(1);
		}
	}

}
