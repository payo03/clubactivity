package clubactivity.vo;

import java.io.File;
import java.text.SimpleDateFormat;

import org.springframework.util.FileCopyUtils;

public class ImageUploadRequest {

	private int memberNumber;
	private String imagePath;

	public ImageUploadRequest() {
		super();
	}

	public ImageUploadRequest(int memberNumber, String imagePath) {
		super();
		this.memberNumber = memberNumber;
		this.imagePath = imagePath;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public static String uploadFile(String originalName, byte[] fileData, String rootPath) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String rndName = sdf.format(new java.util.Date()) + System.currentTimeMillis();
		String savedName = rndName + "." + originalName.substring(originalName.lastIndexOf(".") + 1);
		File target = new File(rootPath, savedName);
		FileCopyUtils.copy(fileData, target);

		return savedName;
	}
}
