package net.itinajero.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@GetMapping("/index")
	public String index(Model model){
		
		model.addAttribute("listaUsuario",usuarioService.findAll());
		return "/usuarios/listUsuarios";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id , RedirectAttributes attributes){
		//A los usuarios no hay que eliminarlos hay que desactivarlos  
		Usuario user = usuarioService.findById(id);
		Perfil perfilObj = perfilService.findByCuenta(user.getCuenta());
		System.out.println(user);
		System.out.println(perfilObj);
		user.setActivo(0);
		usuarioService.save(user);
		
		attributes.addFlashAttribute("mensaje", "El usuarios fue desactivado");
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/activar/{id}")
	public String activar(@PathVariable("id") int id , RedirectAttributes attributes){
		//A los usuarios no hay que eliminarlos hay que desactivarlos  
		Usuario user = usuarioService.findById(id);
		Perfil perfilObj = perfilService.findByCuenta(user.getCuenta());
		System.out.println(user);
		System.out.println(perfilObj);
		user.setActivo(1);
		usuarioService.save(user);
		
		attributes.addFlashAttribute("mensaje", "El usuarios fue reactivado");
		return "redirect:/usuarios/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id,Model model){
		
		model.addAttribute("usuario", usuarioService.findById(id));
		return "/usuarios/formUsuario";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Usuario usuario){
		return "/usuarios/formUsuario";
	}
	
	@PostMapping("/save")
	public String guarda(@ModelAttribute Usuario usuario, @RequestParam("perfil") String perfil, RedirectAttributes attributes){
		
		String tempPass = usuario.getPwd();
		String encriptado = tempPass;
		
		if (usuario.getPwd().length()<40) {
			encriptado = encoder.encode(tempPass);
		}
		
		if(usuario.getId()==0){
			//Logica para hacer un save
			usuario.setPwd(encriptado);
			usuario.setActivo(1);
			usuarioService.save(usuario);
			System.out.println("save: "+usuario);
			
			Perfil perfilTmp = new Perfil();
			perfilTmp.setCuenta(usuario.getCuenta());
			perfilTmp.setPerfil(perfil);
			perfilService.save(perfilTmp);
			System.out.println("save: "+perfilTmp);
			
			
		}else{
			//Logica para hacer un update
			Usuario usuarioTmp = usuarioService.findById(usuario.getId());
			usuario.setPwd(encriptado);
			usuario.setActivo(usuarioTmp.getActivo());
			System.out.println("update: "+usuario);
			
			Perfil perfilTmp = perfilService.findByCuenta(usuarioTmp.getCuenta());
			perfilTmp.setCuenta(usuario.getCuenta());
			perfilTmp.setPerfil(perfil);
			System.out.println("update: "+perfilTmp);
			
		}
		
		
		attributes.addFlashAttribute("mensaje", "El registro fue guardado");
		
		return "redirect:/usuarios/index";
	}
	

}

