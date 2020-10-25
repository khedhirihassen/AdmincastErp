package com.hassen.depot.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Fournisseur {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id ;
	
	@NotBlank
	private String code ;
	
	@NotBlank
	@Size(min = 3, max = 50)
	private String nom ;
	
	@NotBlank
	private String adress ; 
	
	@NotBlank
	private String matriculeFiscale ;
	
	@NotBlank
	private String mobile ;
	
	private String fax ;
	
	private String representant ;

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMatriculeFiscale() {
		return matriculeFiscale;
	}

	public void setMatriculeFiscale(String matriculeFiscale) {
		this.matriculeFiscale = matriculeFiscale;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getRepresentant() {
		return representant;
	}

	public void setRepresentant(String representant) {
		this.representant = representant;
	}
	
}
