package net.itinajero.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AcercadeController {

	@GetMapping(value="/acercade")
	public String mostrarAcercaDe(Model model){
		String imagen = "30739484_1863202897025376_3940938351750613206_n.jpg";
		model.addAttribute("imagen",imagen);
		return "/acercade";
	}
	
	@GetMapping(value="/menuBienvenido")
	public String admin(Authentication authentication){
		System.out.println("Username: " + authentication.getName());
		
		for (GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("Rol: " + rol.getAuthority() );
		}
		
		
		
		return "/admin";
	}
}
