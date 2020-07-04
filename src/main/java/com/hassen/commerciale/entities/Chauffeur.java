package com.hassen.commerciale.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;


@Entity
public class Chauffeur {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id ;
	
	@NotBlank
	private String nom ;
	
	@NotBlank
	private String prenom ;
	
	@NotBlank
	private String permis ;
	
	@NotBlank
	private String typePermis ;
	
	//@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateObtention ;
	
	@OneToMany (mappedBy = "chauffeur")
	private List<Camion> chauffeursCamion = new ArrayList<Camion>();

	public Chauffeur() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPermis() {
		return permis;
	}

	public void setPermis(String permis) {
		this.permis = permis;
	}

	public String getTypePermis() {
		return typePermis;
	}

	public void setTypePermis(String typePermis) {
		this.typePermis = typePermis;
	}

	public Date getDateObtention() {
		return dateObtention;
	}

	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}

	public List<Camion> getChauffeursCamion() {
		return chauffeursCamion;
	}

	public void setChauffeursCamion(List<Camion> chauffeursCamion) {
		this.chauffeursCamion = chauffeursCamion;
	}
	
	
	
}
