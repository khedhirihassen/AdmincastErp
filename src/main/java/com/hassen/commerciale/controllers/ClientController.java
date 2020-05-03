package com.hassen.commerciale.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hassen.commerciale.services.ClientService;

@Controller
@RequestMapping("clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public String showClients(Model model) {

		model.addAttribute("clients", clientService.getAllClients());
		return "clients/listeClients";

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		clientService.delete(id);
		return "redirect:/clients";
	}
	

}
