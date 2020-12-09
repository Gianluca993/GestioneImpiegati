package com.gianluca.bc.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Impiegato {

	private long id;
	@Size(min=2, max=30, message="Da due a 30 caratteri")
	private String nome;
	@DecimalMin("800.00")
	private double stipendio;
	@Pattern(regexp = "^[a-zA-Z]{2,30}", message = "Solo lettere accettate, massimo 30 caratteri")
	private String reparto;
	private String imgUrl;
//	private Img img;
	private CommonsMultipartFile img;
	
	public Impiegato() {
	}
	
	public Impiegato(long id, String nome, double stipendio, String reparto, String imgUrl) {
		this.id = id;
		this.nome = nome;
		this.stipendio = stipendio;
		this.reparto = reparto;
		this.imgUrl = imgUrl;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getStipendio() {
		return stipendio;
	}
	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}
	public String getReparto() {
		return reparto;
	}
	public void setReparto(String reparto) {
		this.reparto = reparto;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public CommonsMultipartFile getImg() {
		return img;
	}
	public void setImg(CommonsMultipartFile img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Impiegato [id=" + id + ", nome=" + nome + ", stipendio=" + stipendio + ", reparto=" + reparto
				+ ", imgUrl=" + imgUrl + ", img=" + img + "]";
	}
}
