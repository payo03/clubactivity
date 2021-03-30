package clubactivity.vo;

import java.io.Serializable;

public class Memberlevel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memberLevelCode;
	private String memberLevelDescription;
	
	public int getMemberLevelCode() {
		return memberLevelCode;
	}
	public void setMemberLevelCode(int memberLevelCode) {
		this.memberLevelCode = memberLevelCode;
	}
	public String getMemberLevelDescription() {
		return memberLevelDescription;
	}
	public void setMemberLevelDescription(String memberLevelDescription) {
		this.memberLevelDescription = memberLevelDescription;
	}	

}
