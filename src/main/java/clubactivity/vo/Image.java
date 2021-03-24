package clubactivity.vo;

public class Image {

	private int memberNumber;
	private String imagePath;
	private int imageNumber;

	public Image() {
		super();
	}

	public Image(int petRegistrationNumber, String imagePath, int memberNumber, int imageNumber) {
		super();
		this.imagePath = imagePath;
		this.memberNumber = memberNumber;
		this.imageNumber = imageNumber;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public int getImageNumber() {
		return imageNumber;
	}

	public void setImageNumber(int imageNumber) {
		this.imageNumber = imageNumber;
	}
}
