package com.hassen.commerciale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.commerciale.entities.Marche;
import com.hassen.commerciale.repositories.MarcheRepository;

@Service
public class MarcheServiceImpl implements MarcheService {

	@Autowired
	private MarcheRepository marcheRepository ;

	@Override
	public List<Marche> getAllMarche() {
		
		return marcheRepository.findAll();
	}

	@Override
	public Marche getMarcheById(Long id) {
		
		return marcheRepository.getOne(id);
	}

	@Override
	public void save(Marche marche) {
		
		marcheRepository.save(marche);
	}

	@Override
	public void update(Marche marche) {
		
		marcheRepository.save(marche);
	}

	@Override
	public void delete(Long id) {
		
		marcheRepository.deleteById(id);
	}
	
}
