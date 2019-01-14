package net.itinajero.app.controller;

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
}