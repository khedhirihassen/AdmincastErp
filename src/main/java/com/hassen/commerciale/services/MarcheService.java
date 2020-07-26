package com.hassen.commerciale.services;

import java.util.List;

import com.hassen.commerciale.entities.Marche;


public interface MarcheService {

	public List<Marche> getAllMarche();
	
	public Marche getMarcheById(Long id);
	
	public void save (Marche marche);
	
	public void update (Marche marche);
	
	public void delete (Long id);
	
	
}
