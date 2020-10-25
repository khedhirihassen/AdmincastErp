package com.hassen.depot.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hassen.depot.entities.Fournisseur;
import com.hassen.depot.services.FournisseurService;

@Controller
@RequestMapping("fournisseurs")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurService;
	
	@GetMapping
	public String showAllFournisseurs(Model model) {
		
		model.addAttribute("fournisseurs", fournisseurService.getAllFournisseurs());
		return "fournisseurs/listFournisseurs";
	}
	
	@GetMapping("addFournisseur")
	public String showAddForm(Fournisseur fournisseur) {
		
		return "fournisseurs/addFournisseur" ;
	}
	
	@PostMapping("add")
	public String addFournisseur (Model model,@Valid Fournisseur fournisseur, BindingResult result ) {
		
		if (result.hasErrors()) {
			return "fournisseurs/addFournisseur";
		}

		fournisseurService.save(fournisseur);
		return "redirect:/fournisseurs";
		
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
		model.addAttribute("fournisseur", fournisseur);
		return "fournisseurs/updateFournisseur";
	}

	@PostMapping("update/{id}")
	public String updateFournisseur(@PathVariable("id") Long id, @Valid Fournisseur fournisseur, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			fournisseur.setId(id);
			return "fournisseurs/updateFournisseur";
		}

		fournisseurService.update(fournisseur);
		return "redirect:/fournisseurs";
	}
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		fournisseurService.delete(id);
		return "redirect:/fournisseurs";
	}
}
