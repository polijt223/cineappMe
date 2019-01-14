package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.itinajero.app.model.Noticia;
import net.itinajero.app.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	
	@Autowired
	INoticiasService noticiaService ;
	
	
	@GetMapping(value="/create")
	public String crear(@ModelAttribute Noticia pelicula,Model model){
		return "/noticias/formNoticia";
		
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") int id,RedirectAttributes attributes){
		
		noticiaService.deleteNoticia(id);
		
		attributes.addFlashAttribute("mensaje","El registro fue eliminado");
		return "redirect:/noticias/indexPaginate?page=0";
	}
	
	
	//USO DE DATA BINDING LOS name del jsp deben ser igual al nombre de los atributos del Objeto bean al que se matea
	@PostMapping(value="/save")
	public String guardar(@ModelAttribute Noticia noticia,RedirectAttributes attributes){
		/* 
		if (noticia.getFecha()==null) {
			noticia.setFecha(new Date());
		}
		*/
		System.out.println(noticia);
		noticiaService.guardar(noticia);	
		System.out.println(noticia);
		String mensaje = "El registro id : "+noticia.getId()+" fue guardado";
		attributes.addFlashAttribute("mensaje",mensaje);
		return "redirect:/noticias/indexPaginate?page=0";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model,Pageable page) {
		Page<Noticia> lista = noticiaService.buscarTodas(page);
		model.addAttribute("listaNoticias",lista);
		return "/noticias/listNoticias";
	}
	
	@GetMapping(value="/edit/{id}")
	public String edit(@PathVariable("id") int id , RedirectAttributes attributes,Model model){
		
		Noticia noticia = noticiaService.buscarPorId(id);
		model.addAttribute("noticia",noticia);
		return "/noticias/formNoticia";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
