package com.hassen.commerciale.services;

import java.util.List;

import com.hassen.commerciale.entities.Chauffeur;

public interface ChauffeurService {

	public List<Chauffeur> getAllChauffeurs();
	
	public Chauffeur getChauffeurById(Long id);
	
	public void save (Chauffeur chauffeur);
	
	public void update (Chauffeur chauffeur);
	
	public void delete (Long id);
	
	
}
