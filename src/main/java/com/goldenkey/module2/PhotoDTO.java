package com.goldenkey.module2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="photos")
public class PhotoDTO {


	@Id
	@GeneratedValue
	private int photoId;
	private String photographer;
	private String path;
	private String fileName;
	private String comments;
	
 
	public String getPhotographer() {
		return photographer;
	}
	public void setPhotographer(String photographer) {
		this.photographer = photographer;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
 
	
	
	
}
