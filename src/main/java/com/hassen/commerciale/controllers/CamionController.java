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

import com.hassen.commerciale.entities.Camion;
import com.hassen.commerciale.entities.Chauffeur;
import com.hassen.commerciale.services.CamionService;
import com.hassen.commerciale.services.ChauffeurService;

@Controller
@RequestMapping("camions")
public class CamionController {

	@Autowired
	private CamionService camionService ;
	
	@Autowired
	private ChauffeurService chauffeurService;
	
	@GetMapping
	public String showCamions(Model model) {

		model.addAttribute("camions", camionService.getAllCamion());
		return "camions/listeCamions";

	}
	
	@GetMapping("addCamion")
    public String showAddForm(Camion camion , Model model) {
		List<Chauffeur> listChauffeurs = chauffeurService.getAllChauffeurs();
		model.addAttribute("listChauffeurs",listChauffeurs);
		return "camions/addCamion";

    }
	
	@PostMapping("add")
	public String addCamion(@Valid Camion camion, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "camions/addCamion";
		}

		camionService.save(camion);
		return "redirect:/camions";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Camion camion = camionService.getCamionById(id);
		model.addAttribute("camion", camion);
		model.addAttribute("listChauffeurs",chauffeurService.getAllChauffeurs());
		return "camions/updateCamion";
	}

	@PostMapping("update/{id}")
	public String updateCamion(@PathVariable("id") Long id, @Valid Camion camion, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			camion.setId(id);
			return "camions/updateCamion";
		}

		camionService.update(camion);
		return "redirect:/camions";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		camionService.delete(id);
		return "redirect:/camions";
	}
	
	
}
