package clubactivity.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memberNumber;
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String memberPhoneNumber;
	private Date memberRegisterDate;
	private Memberlevel memberlevel;
	private String memberWebsite;
	private Memberonline memberonline;
	private Image image;
	private List<Messagecommand> messagecommand;

	public Member() {
		super();
	}

	public Member(int memberNumber, String memberId, String memberPassword, String memberName, String memberPhoneNumber,
			Date memberRegisterDate, Memberlevel memberlevel, String memberWebsite, Memberonline memberonline,
			Image image, List<Messagecommand> messagecommand) {
		super();
		this.memberNumber = memberNumber;
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.memberPhoneNumber = memberPhoneNumber;
		this.memberRegisterDate = memberRegisterDate;
		this.memberlevel = memberlevel;
		this.memberWebsite = memberWebsite;
		this.memberonline = memberonline;
		this.image = image;
		this.messagecommand = messagecommand;
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

	public Memberonline getMemberonline() {
		return memberonline;
	}

	public void setMemberonline(Memberonline memberonline) {
		this.memberonline = memberonline;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public List<Messagecommand> getMessagecommand() {
		return messagecommand;
	}

	public void setMessagecommand(List<Messagecommand> messagecommand) {
		this.messagecommand = messagecommand;
	}

	public void changePassword(String newPassword) {
		this.memberPassword = newPassword;
	}

	public void changeProfile(Object object) {
		if (object instanceof ChangeNumberCommand) {
			this.memberPhoneNumber = ((ChangeNumberCommand) object).getMemberPhoneNumber();
		} else if (object instanceof ChangeWebsiteCommand) {
			this.memberWebsite = ((ChangeWebsiteCommand) object).getMemberWebsite();
		}
	}

}