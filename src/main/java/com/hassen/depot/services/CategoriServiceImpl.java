package com.hassen.depot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.depot.entities.Categorie;
import com.hassen.depot.repositories.CategorieRepository;

@Service
public class CategoriServiceImpl implements CategorieService {

	@Autowired
	CategorieRepository categorieRepository;
	
	@Override
	public List<Categorie> getAllCategories() {
		
		return categorieRepository.findAll();
	}

	@Override
	public Categorie getCategorieById(Long id) {
		// TODO Auto-generated method stub
		return categorieRepository.getOne(id);
	}

	@Override
	public void save(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieRepository.save(categorie);
	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub
		categorieRepository.save(categorie);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		categorieRepository.deleteById(id);
	}

}
