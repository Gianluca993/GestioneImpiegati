package com.gianluca.bc.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Img {

	CommonsMultipartFile img;

	public CommonsMultipartFile getImg() {
		return img;
	}

	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}
	
	
}
