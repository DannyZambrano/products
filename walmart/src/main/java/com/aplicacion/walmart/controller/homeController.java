package com.aplicacion.walmart.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aplicacion.walmart.model.Entidad;
import com.aplicacion.walmart.service.walmartService;

@Controller
public class homeController {
	
	@Autowired
	private walmartService service; 
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		
		
		return "home";
		
		
	}
	
	

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String guardar(@RequestParam("busqueda") String busqueda,Model model) { 	
    	
    	
		List<Entidad> resp = service.consulta(busqueda,isNumeric(busqueda),esPalindromo(busqueda));
		
		model.addAttribute("entidad", resp);
		
		return "home";
   


    }
    
    
    public static boolean isNumeric(String cadena) {

     boolean resultado;

     try {

            Integer.parseInt(cadena);

            resultado = true;

        } catch (NumberFormatException excepcion) {

            resultado = false;

        }

         return resultado;

    }
    
    
	public static boolean esPalindromo(String cadena) {

		cadena = cadena.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");

		String invertida = new StringBuilder(cadena).reverse().toString();

		return invertida.equals(cadena);
	}

}
