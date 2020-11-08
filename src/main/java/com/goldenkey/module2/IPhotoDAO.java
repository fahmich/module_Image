package com.goldenkey.module2;

import org.springframework.web.multipart.MultipartFile;

public interface IPhotoDAO {

	public void savePhotoImage(PhotoDTO photoDTO, MultipartFile imageFile) throws Exception;
	public void save(PhotoDTO photoDTO);

}