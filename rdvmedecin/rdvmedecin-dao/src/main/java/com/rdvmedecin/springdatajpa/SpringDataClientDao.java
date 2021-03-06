package com.rdvmedecin.springdatajpa;

import org.springframework.data.repository.Repository;

import com.rdvmedecin.dao.ClientDao;
import com.rdvmedecin.entity.Client;

public interface SpringDataClientDao extends ClientDao, Repository<Client, Long> {
}
