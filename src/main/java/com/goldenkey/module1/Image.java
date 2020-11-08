package com.goldenkey.module1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "IMAGE")
public class Image implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IMAGE_ID")
	private Long id;
	
	@Column(name="NOM_IMAGE")
	private String nom;
	
	@Column(name="EXTENSION")
	private String extension;
	
	
	@Column(name="URL")
	private String url;

	public Image() {
		super();
	}

	public Image(String nom, String extension, String url) {
		super();
		this.nom = nom;
		this.extension = extension;
		this.url = url;
	}

	public Image(Long id, String nom, String extension, String url) {
		super();
		this.id = id;
		this.nom = nom;
		this.extension = extension;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", nom=" + nom + ", extension=" + extension + ", url=" + url
				+ "]";
	}
	
	
	
	
	
	
	
	

}
