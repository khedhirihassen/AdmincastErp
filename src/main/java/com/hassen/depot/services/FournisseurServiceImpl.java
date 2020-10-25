package com.hassen.depot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.depot.entities.Fournisseur;
import com.hassen.depot.repositories.FournisseurRepository;

@Service
public class FournisseurServiceImpl implements FournisseurService {

	@Autowired
	private FournisseurRepository fournisseurRepository ;

	@Override
	public List<Fournisseur> getAllFournisseurs() {
		// TODO Auto-generated method stub
		return fournisseurRepository.findAll();
	}

	@Override
	public Fournisseur getFournisseurById(Long id) {
		// TODO Auto-generated method stub
		return fournisseurRepository.getOne(id);
	}

	@Override
	public void save(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		fournisseurRepository.save(fournisseur);
	}

	@Override
	public void update(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		fournisseurRepository.save(fournisseur);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		fournisseurRepository.deleteById(id);
	}
}
