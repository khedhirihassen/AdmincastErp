package com.hassen.commerciale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hassen.commerciale.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
