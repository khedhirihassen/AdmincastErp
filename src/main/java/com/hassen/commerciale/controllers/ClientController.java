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

import com.hassen.commerciale.entities.Client;
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
	
	@GetMapping("addClient")
    public String showAddForm(Client client) {
		
		return "clients/addClient";

    }
	
	@PostMapping("add")
	public String addStudent(@Valid Client client, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "clients/addClient";
		}

		clientService.save(client);
		return "redirect:/clients";
	}
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") Long id, Model model) {
		Client client = clientService.getClientById(id);
		model.addAttribute("client", client);
		return "clients/updateClient";
	}

	@PostMapping("update/{id}")
	public String updateClient(@PathVariable("id") Long id, @Valid Client client, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			client.setId(id);
			return "clients/updateClient";
		}

		clientService.update(client);
		//model.addAttribute("clients", clientService.getAllClients());
		return "redirect:/clients";
	}

	
	

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {

		clientService.delete(id);
		return "redirect:/clients";
	}
	

}
