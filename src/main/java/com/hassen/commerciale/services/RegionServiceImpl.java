package com.hassen.commerciale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.commerciale.entities.Region;
import com.hassen.commerciale.repositories.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	private RegionRepository regionRepository ;
	
	@Override
	public List<Region> getAllRegions() {
		// TODO Auto-generated method stub
		return regionRepository.findAll();
	}

	@Override
	public Region getRegionById(Long id) {
		// TODO Auto-generated method stub
		return regionRepository.getOne(id);
	}

	@Override
	public void save(Region region) {
		// TODO Auto-generated method stub
		regionRepository.save(region);
	}

	@Override
	public void update(Region region) {
		// TODO Auto-generated method stub
		regionRepository.save(region);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		regionRepository.deleteById(id);
	}

}
