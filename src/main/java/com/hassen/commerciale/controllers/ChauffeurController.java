package com.hassen.commerciale.controllers;

import java.util.Arrays;
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

import com.hassen.commerciale.entities.Chauffeur;
import com.hassen.commerciale.services.ChauffeurService;

@Controller
@RequestMapping("chauffeurs")
public class ChauffeurController {

	@Autowired
	private ChauffeurService chauffeurService ;
	
	@GetMapping
	public String showChauffeurs(Model model) {

		model.addAttribute("chauffeurs", chauffeurService.getAllChauffeurs());
		return "chauffeurs/listeChauffeurs";

	}
	
	@GetMapping("addChauffeur")
    public String showAddForm(Model model) {
		
		Chauffeur chauffeur = new Chauffeur();
		model.addAttribute("chauffeur",chauffeur);
		List<String> listTypePermis = Arrays.asList("A","B","C","D","E","F");
		model.addAttribute("listTypePermis",listTypePermis);
		
		return "chauffeurs/addChauffeur";

    }
	
	@PostMapping("add")
	public String addChauffeur(@Valid Chauffeur chauffeur, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "chauffeurs/addChauffeur";
		}

		chauffeurService.save(chauffeur);
		return "redirect:/chauffeurs";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Chauffeur chauffeur = chauffeurService.getChauffeurById(id);
		model.addAttribute("chauffeur", chauffeur);
		List<String> listTypePermis = Arrays.asList("A","B","C","D","E","F");
		model.addAttribute("listTypePermis",listTypePermis);
		return "chauffeurs/updateChauffeur";
	}

	@PostMapping("update/{id}")
	public String updateChauffeur(@PathVariable("id") Long id, @Valid Chauffeur chauffeur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			chauffeur.setId(id);
			return "chauffeurs/updateChauffeur";
		}

		chauffeurService.update(chauffeur);
		return "redirect:/chauffeurs";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		chauffeurService.delete(id);
		return "redirect:/chauffeurs";
	}
}
