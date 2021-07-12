package com.petshop.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.petshop.demo.model.ClienteEntity;

@Repository
public interface ClienteRepository 
			extends CrudRepository<ClienteEntity, Long> {

}
