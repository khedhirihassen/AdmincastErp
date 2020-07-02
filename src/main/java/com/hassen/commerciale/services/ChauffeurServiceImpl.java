package com.hassen.commerciale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.commerciale.entities.Chauffeur;
import com.hassen.commerciale.repositories.ChauffeurRepository;

@Service
public class ChauffeurServiceImpl implements ChauffeurService {

	@Autowired
	private ChauffeurRepository chauffeurRepository ; 
	
	@Override
	public List<Chauffeur> getAllChauffeurs() {
		// TODO Auto-generated method stub
		return chauffeurRepository.findAll();
	}

	@Override
	public Chauffeur getChauffeurById(Long id) {
		// TODO Auto-generated method stub
		return chauffeurRepository.getOne(id);
	}

	@Override
	public void save(Chauffeur chauffeur) {
		// TODO Auto-generated method stub
		chauffeurRepository.save(chauffeur);
	}

	@Override
	public void update(Chauffeur chauffeur) {
		// TODO Auto-generated method stub
		chauffeurRepository.save(chauffeur);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		chauffeurRepository.deleteById(id);
	}

	
	
}
