package com.hassen.commerciale.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassen.commerciale.entities.Client;
import com.hassen.commerciale.repositories.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository ;

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.getOne(id);
	}

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public void update(Client client) {
		// TODO Auto-generated method stub
		clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clientRepository.deleteById(id);
	}

	
	
}
