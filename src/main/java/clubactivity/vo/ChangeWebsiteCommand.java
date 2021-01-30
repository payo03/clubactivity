package clubactivity.vo;

import javax.validation.constraints.NotBlank;

public class ChangeWebsiteCommand {

	private int memberNumber;
	@NotBlank
	private String memberWebsite;

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getMemberWebsite() {
		return memberWebsite;
	}

	public void setMemberWebsite(String memberWebsite) {
		this.memberWebsite = memberWebsite;
	}

}
