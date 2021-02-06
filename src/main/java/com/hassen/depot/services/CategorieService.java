package com.hassen.depot.services;

import java.util.List;

import com.hassen.depot.entities.Categorie;

public interface CategorieService {

	public List<Categorie> getAllCategories();
	
	public Categorie getCategorieById(Long id);
	
	public void save(Categorie categorie);
	
	public void update(Categorie categorie);
	
	public void delete(Long id);
	
	
}
