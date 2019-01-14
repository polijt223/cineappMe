package net.itinajero.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IHorarioService;
import net.itinajero.app.service.IPeliculaService;

@Controller
@RequestMapping(value="/horarios")
public class HorariosController {
	
	
//private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IPeliculaService servicePeliculas;
	@Autowired
	private IHorarioService serviceHorarios;

	
	
	@GetMapping(value="/index")
	public String index(Model model) throws ParseException{
		
		
		//String fechaP = dateFormat.format(new Date());
		List<Horario> horariosP = serviceHorarios.getAll();
		
		//model.addAttribute("fechaActualBusqueda", dateFormat.format(new Date()));
		model.addAttribute("listaHorarios",horariosP);
		return "/horarios/listHorarios";
	}
	
	@GetMapping(value ="/delete/{id}")
	public String delete(@PathVariable("id") int id,RedirectAttributes attributes) {				
		
		serviceHorarios.delete(id);
		attributes.addFlashAttribute("mensaje","El registro fue eliminado");
		return "redirect:/horarios/index";
	}
	
	
	@GetMapping(value = "/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas);
		model.addAttribute("horario",serviceHorarios.findById(id));
		return "/horarios/formHorario";
	}
	/*
	@PostMapping(value="/search")
	public String buscar(Model model,@RequestParam("fechaActualBusqueda") String fecha) throws ParseException{
		
		List<Horario> horariosP = serviceHorarios.findByFecha(dateFormat.parse(fecha));
		
		model.addAttribute("fechaActualBusqueda", fecha);
		model.addAttribute("listaHorarios",horariosP);
		return "/horarios/listHorarios";
	}
	*/
	
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Horario horario, Model model ) {
		List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
		model.addAttribute("peliculas", listaPeliculas);
		return "horarios/formHorario";
	}
		
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Horario horario, BindingResult result, Model model,RedirectAttributes attributes) {				
		
		if (result.hasErrors()){
			System.out.println("Ingreso en has Error");
			List<Pelicula> listaPeliculas = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", listaPeliculas);
			return "horarios/formHorario";
		}
		
		serviceHorarios.save(horario);
		
		attributes.addFlashAttribute("mensaje","El registro fue guardado");
		return "redirect:/horarios/index";
	}
	

	
	
	
	
	/**
	 * Personalizamos el Data Binding para todas las propiedades de tipo Date
	 * @param binder
	 */
	@InitBinder("horario")
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));		
	}
	
}
