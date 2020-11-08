package com.goldenkey.module2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

 

@CrossOrigin("*")
@RestController
@RequestMapping("/upload")
public class PlantPlacesController {
	
 
 	@Autowired
 	private ISpecimenService specimenService;
 
  
	@PostMapping(value="/savespecimen")
	public ModelAndView saveSpecimen(@RequestParam("imageFile") MultipartFile imageFile ) {
		ModelAndView modelAndView = new ModelAndView();
	 	
		
		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setFileName(imageFile.getOriginalFilename());
		photoDTO.setPath("/photo/");
//		photoDTO.setSpecimenDTO(specimenDTO);
		modelAndView.setViewName("success");
		try {
			specimenService.saveImage(imageFile, photoDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error saving photo");
			modelAndView.setViewName("error");
			return modelAndView;
		}
		
		modelAndView.addObject("photoDTO", photoDTO);
//		modelAndView.addObject("specimenDTO", specimenDTO);
		return modelAndView;
	}
 
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile) {
		String returnValue = "start";
		
		PhotoDTO photoDTO = new PhotoDTO();
		photoDTO.setFileName(imageFile.getOriginalFilename());
		photoDTO.setPath("/photo/");
		System.out.println(photoDTO);
		try {
			specimenService.saveImage(imageFile, photoDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println( "Error saving photo"+ e);
			returnValue = "error";
		}
		
		return returnValue;
	}
//	@PostMapping("/uploadImage")
//	public String uploadImage(@RequestParam("imageFile") MultipartFile[] imageFile) {
//		String returnValue = "start";
//		
//		PhotoDTO photoDTO = new PhotoDTO();
//		photoDTO.setFileName(imageFile[0].getOriginalFilename());
//		photoDTO.setPath("/photo/");
//		
//		 
//		try {
//			specimenService.saveImage(imageFile[0], photoDTO);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println( "Error saving photo"+ e);
//			returnValue = "error";
//		}
//		
//		return returnValue;
//	}
 
}
