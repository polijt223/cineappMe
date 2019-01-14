package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("index")
	public String index(){
		return "/usuarios/listUsuarios";
	}
	
	@GetMapping("create")
	public String crear(@ModelAttribute Usuario usuario){
		return "/usuarios/formUsuario";
	}
	
	@PostMapping("save")
	public String guarda(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil){
		System.out.println("Usuario: "+usuario);
		System.out.println("Role: "+perfil);
		
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/demo-bcrypt")
	public String pruebaBcrypt() {
		
		String password = "mari123";
		String encriptado = encoder.encode(password);
		System.out.println("Password encriptado: " + encriptado);
		return "usuarios/demo";
		
	}
}

