package com.hassen.commerciale.services;

import java.util.List;

import com.hassen.commerciale.entities.Camion;


public interface CamionService {

public List<Camion> getAllCamion();
	
	public Camion getCamionById(Long id);
	
	public void save (Camion camion);
	
	public void update (Camion camion);
	
	public void delete (Long id);
	
	
}
