package com.goldenkey.module1;

import static com.goldenkey.module1.Keys.*;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/upload")
public class UploadController {

	@Autowired
	ImageService _service;
	
 	@RequestMapping(value = "/singleSave", method = RequestMethod.POST)
	public @ResponseBody String singleSave(@RequestParam("file") MultipartFile file) {
		String fileName = null;
		Image img = new Image();

		if (!file.isEmpty()) {
			try {
				fileName = file.getOriginalFilename();
				byte[] bytes = file.getBytes();

				BufferedOutputStream buffStream = new BufferedOutputStream(
						new FileOutputStream(new File(IMAGE_CP_LOCAL_PATH + fileName)));
				buffStream.write(bytes);
				buffStream.close();

				img = new Image(fileName, null, IMAGE_CP_LOCAL_PATH + fileName);
				this._service.savOrUpdate(img);
				return "You have successfully uploaded " + fileName;
			} catch (Exception e) {
				return "You failed to upload " + fileName + ": " + e.getMessage();
			}
		} else {
			return "Unable to upload. File is empty.";
		}
	}

 
	@RequestMapping(value = "/multipleSave", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Boolean multipleSave(@RequestParam("file") MultipartFile[] files) {

		System.out.println(files.length);
		if (files != null && files.length > 0) {
			try {
				for (MultipartFile file : files) {

					String fileName;
					Image img = new Image();
					fileName = file.getOriginalFilename();
					byte[] bytes = file.getBytes();

					File dir = new File(IMAGE_LOCAL_PATH);
					if (!dir.exists())
						dir.mkdirs();

					BufferedOutputStream buffStream = new BufferedOutputStream(
							new FileOutputStream(new File(IMAGE_LOCAL_PATH + fileName)));
					buffStream.write(bytes);
					buffStream.close();

					img = new Image(fileName, null, IMAGE_LOCAL_PATH + fileName);

					this._service.savOrUpdate(img);

				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

}
