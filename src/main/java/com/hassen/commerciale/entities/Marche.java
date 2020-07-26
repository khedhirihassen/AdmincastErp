package com.hassen.commerciale.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Marche {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id ;
	
	@NotBlank
	private String codeMarche ; 
	
	@NotBlank
	private String beneficiaire ;
	
	@ManyToOne
	private Region region ;

	public Marche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeMarche() {
		return codeMarche;
	}

	public void setCodeMarche(String codeMarche) {
		this.codeMarche = codeMarche;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
	
}
