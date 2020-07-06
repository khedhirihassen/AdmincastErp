package com.hassen.commerciale.services;

import java.util.List;

import com.hassen.commerciale.entities.Region;

public interface RegionService {

	public List<Region> getAllRegions();
	
	public Region getRegionById(Long id);
	
	public void save (Region region);
	
	public void update (Region region);
	
	public void delete (Long id);
	
	
}
