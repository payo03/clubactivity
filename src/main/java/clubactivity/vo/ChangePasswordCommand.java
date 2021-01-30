package clubactivity.vo;

import javax.validation.constraints.NotBlank;

public class ChangePasswordCommand {

	private int memberNumber;
	@NotBlank
	private String currentPassword;
	@NotBlank
	private String newPassword;

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
