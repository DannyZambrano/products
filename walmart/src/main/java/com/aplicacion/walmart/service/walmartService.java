package com.aplicacion.walmart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aplicacion.walmart.model.Entidad;
import com.aplicacion.walmart.repository.walmartRepository;

@Service
public class walmartService {

	@Autowired
	walmartRepository repository;
	
	String protocolo = "https://";
	
	@SuppressWarnings("null")
	public List<Entidad> consulta(String busqueda, boolean numerico,boolean palindromo) {

		List<Entidad> it = repository.findAll();

		List<Entidad> listAux = null;
		
		listAux = new ArrayList<Entidad>(); 

		for (Entidad e : it) {
			
			Entidad resp = new Entidad();

			if (numerico) {

				if (e.getIdProducto().trim().equals(busqueda)) {

					resp.setBrand(e.getBrand());

					resp.setDescription(e.getDescription());

					resp.setImage(protocolo.concat(e.getImage()));

					resp.setPrice(e.getPrice());

					resp.setIdProducto(e.getIdProducto());

					listAux.add(resp);
				
					
					break;

				}

			} else {

				if (e.getDescription().trim().contains(busqueda) || e.getBrand().trim().contains(busqueda)) {
					

					resp.setBrand(e.getBrand());

					resp.setDescription(e.getDescription());

					resp.setImage(protocolo.concat(e.getImage()));
					
					
					
					if (palindromo) {

						double priceAux = Double.parseDouble(e.getPrice());

						priceAux = priceAux * 0.50;

						resp.setPrice(String.valueOf(priceAux));

					} else {

						resp.setPrice(e.getPrice());
					}
					

					resp.setIdProducto(e.getIdProducto());

					listAux.add(resp);

				}

			}

		}

	
		return listAux;

		

	}
	
	
	
}
