package clubactivity.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import clubactivity.dao.ImageDAO;
import clubactivity.exception.ImageUploadException;
import clubactivity.vo.ImageUploadRequest;

@Component
public class ImageUploadService {

	@Autowired
	private ImageDAO imageDAO;

	@Transactional(rollbackFor = SQLException.class)
	public int insertImage(ImageUploadRequest imageUploadRequest) {
		int result = imageDAO.insertImage(imageUploadRequest);
		if (result != 1) {
			throw new ImageUploadException("imageUploadException");
		}
		return result;
	}

}
