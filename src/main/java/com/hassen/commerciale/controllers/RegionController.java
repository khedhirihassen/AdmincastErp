package com.hassen.commerciale.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hassen.commerciale.entities.Region;
import com.hassen.commerciale.services.RegionService;

@Controller
@RequestMapping("regions")
public class RegionController {
	
	@Autowired
	private RegionService regionService ;
	
	@GetMapping
	public String showRegions(Model model) {
		
		model.addAttribute("regions",regionService.getAllRegions());
		return "regions/listeRegions";
		
	}
	
	@GetMapping("addRegion")
	public String showAddForm(Model model) {
		
		Region region = new Region();
		model.addAttribute("region",region);
		return "regions/addRegion";
		
	}
	
	@PostMapping("add")
	public String addRegion(@Valid Region region, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "regions/addRegion";
		}

		regionService.save(region);
		return "redirect:/regions";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Region region = regionService.getRegionById(id);
		model.addAttribute("region", region);
		return "regions/updateRegion";
	}

	@PostMapping("update/{id}")
	public String updateRegion(@PathVariable("id") Long id, @Valid Region region, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			region.setId(id);
			return "regions/updateRegion";
		}

		regionService.update(region);
		return "redirect:/regions";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		regionService.delete(id);
		return "redirect:/regions";
	}

}
