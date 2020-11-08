package com.goldenkey.module2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SpecimenService implements ISpecimenService {

 
	@Autowired
	public IPhotoDAO photoDAO;
	 
 
	@Override
	public void saveImage(MultipartFile imageFile, PhotoDTO photoDTO) throws Exception {
		photoDAO.savePhotoImage(photoDTO, imageFile);
		photoDAO.save(photoDTO);
	}
	
 
}
