package com.hassen.depot.services;

import java.util.List;

import com.hassen.depot.entities.Fournisseur;

public interface FournisseurService {

	public List<Fournisseur> getAllFournisseurs();
	
	public Fournisseur getFournisseurById(Long id);
	
	public void save(Fournisseur fournisseur);
	
	public void update(Fournisseur fournisseur);
	
	public void delete(Long id);
	
	
	
}
