package com.hassen.commerciale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.commerciale.entities.Camion;
import com.hassen.commerciale.repositories.CamionRepository;

@Service
public class CamionServiceImpl implements CamionService {

	@Autowired
	private CamionRepository camionRepository ;
	
	
	@Override
	public List<Camion> getAllCamion() {
		// TODO Auto-generated method stub
		return camionRepository.findAll();
	}

	@Override
	public Camion getCamionById(Long id) {
		// TODO Auto-generated method stub
		return camionRepository.getOne(id);
	}

	@Override
	public void save(Camion camion) {
		// TODO Auto-generated method stub
		camionRepository.save(camion);
	}

	@Override
	public void update(Camion camion) {
		// TODO Auto-generated method stub
		camionRepository.save(camion);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		camionRepository.deleteById(id);
	}

}
