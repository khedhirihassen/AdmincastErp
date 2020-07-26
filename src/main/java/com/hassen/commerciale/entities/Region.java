package com.hassen.commerciale.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Region {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id ;
	
	@NotBlank
	private String codeRegion ;
	
	@NotBlank
	private String nom ;
	
	@NotBlank
	private String description ;
	
	@OneToMany (mappedBy = "region")
	private List<Marche> listMarche = new ArrayList<Marche>();

	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeRegion() {
		return codeRegion;
	}

	public void setCodeRegion(String codeRegion) {
		this.codeRegion = codeRegion;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Marche> getListMarche() {
		return listMarche;
	}

	public void setListMarche(List<Marche> listMarche) {
		this.listMarche = listMarche;
	}
	
	
	
	
}
