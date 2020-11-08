package com.goldenkey.module2;

import org.springframework.web.multipart.MultipartFile;

 
public interface ISpecimenService {
	public void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception;
 
}