package clubactivity.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.ImageDAO;
import clubactivity.exception.ImageDeleteException;
import clubactivity.vo.Image;

@Component
public class ImageListService {

	@Autowired
	private ImageDAO imageDAO;

	@Transactional(rollbackFor = SQLException.class)
	public List<Image> selectImageList(int memberNumber) {
		List<Image> imageList = imageDAO.selectImageList(memberNumber);

		return imageList;
	}

	@Transactional(rollbackFor = SQLException.class)
	public int getImageNumber(String imagePath) {
		int imageNumber = imageDAO.selectImageNumber(imagePath);

		return imageNumber;
	}

	@Transactional(rollbackFor = SQLException.class)
	public void deleteImage(String imagePath) {
		int result = imageDAO.deleteImage(imagePath);
		if (result != 1) {
			throw new ImageDeleteException("image Delete Error");
		}
	}

}
