package com.hassen.commerciale.services;

import java.util.List;

import com.hassen.commerciale.entities.Client;

public interface ClientService {
	
	
	public List<Client> getAllClients();
	
	public Client getClientById(Long id);
	
	public void save (Client client);
	
	public void update (Client client);
	
	public void delete (Long id);

}
