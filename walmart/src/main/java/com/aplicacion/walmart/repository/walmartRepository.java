package com.aplicacion.walmart.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aplicacion.walmart.model.Entidad;

@Repository
public interface walmartRepository extends MongoRepository<Entidad, String> {

	
}



