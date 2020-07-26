package com.hassen.commerciale.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hassen.commerciale.entities.Marche;
import com.hassen.commerciale.entities.Region;
import com.hassen.commerciale.services.MarcheService;
import com.hassen.commerciale.services.RegionService;

@Controller
@RequestMapping ("marches")
public class MarcheController {

	@Autowired
	private MarcheService marcheService ;
	
	@Autowired
	private RegionService regionService ;
	
	@GetMapping
	public String showMarches(Model model) {
		
		model.addAttribute("marches", marcheService.getAllMarche());
		return "marches/listeMarches";
		
	}
	
	@GetMapping("addMarche")
    public String showAddForm(Marche marche , Model model) {
		List<Region> listRegions = regionService.getAllRegions();
		model.addAttribute("listRegions",listRegions);
		return "marches/addMarche";

    }
	
	@PostMapping("add")
	public String addMarche(@Valid Marche marche, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "marches/addMarche";
		}

		marcheService.save(marche);
		return "redirect:/marches";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Marche marche = marcheService.getMarcheById(id);
		model.addAttribute("marche", marche);
		model.addAttribute("listRegions",regionService.getAllRegions());
		return "marches/updateMarche";
	}

	@PostMapping("update/{id}")
	public String updateMarche(@PathVariable("id") Long id, @Valid Marche marche, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			marche.setId(id);
			return "marches/updateMarche";
		}

		marcheService.update(marche);
		return "redirect:/marches";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		marcheService.delete(id);
		return "redirect:/marches";
	}
	
}
