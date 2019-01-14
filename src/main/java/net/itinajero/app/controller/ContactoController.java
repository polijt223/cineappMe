package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.itinajero.app.model.Contacto;
import net.itinajero.app.service.IContactoService;
import net.itinajero.app.service.IPeliculaService;

@Controller
public class ContactoController {
	
	@Autowired
	IPeliculaService peliculaService ;
	@Autowired
	IContactoService contactoService;
	
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instaciaContacto") Contacto contacto,Model model){
		
		model.addAttribute("listaGenero",peliculaService.buscarGenero());
		model.addAttribute("listaNotificaciones",contactoService.getNotificaciones());
		
		return "formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instaciaContacto") Contacto contacto,Model model){
		System.out.println(contacto);	
		model.addAttribute("listaGenero",peliculaService.buscarGenero());
		model.addAttribute("listaNotificaciones",contactoService.getNotificaciones());
			
		return "formContacto";
	}
	
	
}
