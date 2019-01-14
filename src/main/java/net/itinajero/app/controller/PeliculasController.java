package net.itinajero.app.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IDetalleService;
import net.itinajero.app.service.IPeliculaService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	IPeliculaService peliculaService;
	@Autowired
	IDetalleService detalleService;
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula,Model model){
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula,BindingResult result,RedirectAttributes attributes,@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request){
		
		if(result.hasErrors()){
			System.out.println("Existieron errores");
			return "peliculas/formPelicula";
		}
		
		if (!multiPart.isEmpty()) {
			pelicula.setImagen(Utileria.guardarImagen(multiPart, request));
		}
		
		System.out.println("Antes: "+pelicula.getDetalle());
		detalleService.insertar(pelicula.getDetalle());
		System.out.println("Despues: "+pelicula.getDetalle());
		peliculaService.insertar(pelicula);
		attributes.addFlashAttribute("mensaje","El registro fue guardado");
		return "redirect:/peliculas/indexPaginate?page=0";
	}
	
	@GetMapping(value="/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula,Model model){
		
		Pelicula pelicula = peliculaService.buscarPorId(idPelicula);
		model.addAttribute("pelicula",pelicula);
		return "peliculas/formPelicula";
	}
	
	@GetMapping(value="/delete/{id}")
	public String delete(@PathVariable("id") int idPelicula,RedirectAttributes attributes){
		
		Pelicula pelicula = peliculaService.buscarPorId(idPelicula);
		peliculaService.eliminar(idPelicula);
		
		detalleService.eliminar(pelicula.getDetalle().getId());
		
		attributes.addFlashAttribute("mensaje","El registro fue guardado");
		return "redirect:/peliculas/indexPaginate?page=0";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = peliculaService.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}					
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return peliculaService.buscarGenero();
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	


	
	
	
}
