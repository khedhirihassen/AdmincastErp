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

import com.hassen.depot.entities.Categorie;
import com.hassen.depot.services.CategorieService;

@Controller
@RequestMapping("categories")
public class CategorieController {
	
	@Autowired
	CategorieService categorieService;
	
	@GetMapping
	public String showAllCategories(Model model) {
		
		model.addAttribute("categories", categorieService.getAllCategories());
		return "categories/listeCategories";
	}
	
	@GetMapping("addCategorie")
	public String showAddForm(Categorie categorie) {
		
		return "categories/addCategorie" ;
	}
	
	@PostMapping("add")
	public String addCategorie (Model model,@Valid Categorie categorie, BindingResult result ) {
		
		if (result.hasErrors()) {
			return "categories/addCategorie";
		}

		categorieService.save(categorie);
		return "redirect:/categories";
		
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Categorie categorie = categorieService.getCategorieById(id);
		model.addAttribute("categorie", categorie);
		return "categories/updateCategorie";
	}

	@PostMapping("update/{id}")
	public String updateCategorie(@PathVariable("id") Long id, @Valid Categorie categorie, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			categorie.setId(id);
			return "categories/updateCategorie";
		}

		categorieService.update(categorie);
		return "redirect:/categories";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		categorieService.delete(id);
		return "redirect:/categories";
	}

}
