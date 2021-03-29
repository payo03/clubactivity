package clubactivity.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import clubactivity.vo.Image;
import clubactivity.vo.ImageUploadRequest;

@Mapper
@Component
public interface ImageDAO {

	int insertImage(@Param("imageUploadRequest") ImageUploadRequest imageUploadRequest);

	int getImageNumber(@Param("imagePath") String imagePath);

	Image checkImage(@Param("memberNumber") int memberNumber);

	int deleteImage(@Param("imagePath") String imagePath);

	List<Image> selectImageList(@Param("memberNumber") int memberNumber);

}
