package net.itinajero.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Perfil;
import net.itinajero.app.model.Usuario;
import net.itinajero.app.service.PerfilesServiceJPA;
import net.itinajero.app.service.UsuariosServiceJPA;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UsuariosServiceJPA usuarioService;
	@Autowired
	private PerfilesServiceJPA perfilService;
	
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
		
		String tempPass = usuario.getPwd();
		String encriptado = encoder.encode(tempPass);
		
		usuario.setPwd(encriptado);
		usuario.setActivo(1);
		usuarioService.save(usuario);
		
		Perfil perfilTmp = new Perfil();
		perfilTmp.setCuenta(usuario.getCuenta());
		perfilTmp.setPerfil(perfil);
		
		perfilService.save(perfilTmp);
		
		
		
		return "redirect:/usuarios/index";
	}
	

}

