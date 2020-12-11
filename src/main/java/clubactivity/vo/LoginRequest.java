package clubactivity.vo;

public class LoginRequest {

	private String memberId;
	private String memberPassword;
	private boolean memory;

	public LoginRequest(String memberId, String memberPassword, boolean memory) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memory = memory;
	}

	public LoginRequest() {
		super();
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

	public boolean isMemory() {
		return memory;
	}

	public void setMemory(boolean memory) {
		this.memory = memory;
	}
}
