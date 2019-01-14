package net.itinajero.app.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.itinajero.app.model.Banner;
import net.itinajero.app.model.Horario;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.service.IHorarioService;
import net.itinajero.app.service.INoticiasService;
import net.itinajero.app.service.IPeliculaService;

@Controller
public class HomeController {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@Autowired
	private IPeliculaService servicePeliculas;
	@Autowired
	private IBannerService serviceBanner;
	@Autowired
	private INoticiasService serviceNoticias;
	@Autowired
	private IHorarioService serviceHorario;
	
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) throws ParseException{
		
		List<Pelicula> peliculasDisponiblesHoy = new LinkedList<>();
		String fechaP = dateFormat.format(new Date());
		List<Integer> horariosP = serviceHorario.getByFechaDisponibleshoyActiva(dateFormat.parse(fechaP));
		for (int date : horariosP) {
			peliculasDisponiblesHoy.add(servicePeliculas.buscarPorId(date));
		}
		
		List<Banner> listBanners = serviceBanner.findAll();
		
		List <Integer> ItemsCarrucel = new ArrayList<>();
		int primerbannerId = 99999999 ;
		int countBanner ;
		int e = 0;
		for(Banner banner : listBanners){
			countBanner = banner.getId();
			if(primerbannerId > countBanner){
				primerbannerId = countBanner;
			}
			ItemsCarrucel.add(e);
			e++;
		}
		//Borro una iteracion sobrante, ya que el 0 va active por default en el jsp 
		ItemsCarrucel.remove(0);
		
		model.addAttribute("listaNoticias",serviceNoticias.listaNoticiasActivas());
		model.addAttribute("itemsCarrucel",ItemsCarrucel);
		model.addAttribute("primerbanner",listBanners.get(primerbannerId-1));
		model.addAttribute("banners",listBanners);
		model.addAttribute("peliculas", peliculasDisponiblesHoy);
		model.addAttribute("fechaActualBusqueda", dateFormat.format(new Date()));
		
		return "/home";
	}
	
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String buscar(@RequestParam("fechaActualBusqueda") String fecha ,Model model) throws ParseException{
		
		//List<String> listaFechas = new LinkedList<>();
		//List<Date> Fechas = serviceHorario.buscarfechasActivas();
		List<Pelicula> peliculas = new LinkedList<>();
		List<Integer> horariosP = serviceHorario.getByFechaDisponibleshoyActiva(dateFormat.parse(fecha));
		for (int date : horariosP) {
			peliculas.add(servicePeliculas.buscarPorId(date));
		}
		
		List<Banner> listBanners = serviceBanner.findAll();
		
		
		List <Integer> ItemsCarrucel = new ArrayList<>();
		int primerbannerId = 99999999 ;
		int countBanner ;
		int e = 0;
		for(Banner banner : listBanners){
			countBanner = banner.getId();
			if(primerbannerId > countBanner){
				primerbannerId = countBanner;
			}
			ItemsCarrucel.add(e);
			e++;
		}
		//Borro una iteracion sobrante, ya que el 0 va active por default en el jsp 
		ItemsCarrucel.remove(0);
		
		model.addAttribute("listaNoticias",serviceNoticias.listaNoticiasActivas());
		model.addAttribute("itemsCarrucel",ItemsCarrucel);
		model.addAttribute("primerbanner",listBanners.get(primerbannerId-1));
		model.addAttribute("banners",listBanners);
		//model.addAttribute("fechas",listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaActualBusqueda", fecha);
		
		System.out.println("Buscando todas la peliculas activas en el : "+fecha);
		return "/home";
	}

	//@RequestMapping(value="/detail/{id}/{fechaActualBusqueda}",method=RequestMethod.GET)    ----- RequestMapping para URL dinamicas  
	//@RequestMapping(value="/detail",method=RequestMethod.GET)     // --------- RequestMapping para URL esatica mayor mente utilizada para RestFull
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fechaActualBusqueda") String fechaEstreno){       -- @PathVariable usado para url dinamicas
	@RequestMapping(value = "/detail/{id}/{fechaActualBusqueda}",method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fechaActualBusqueda") String fecha){					//--@RequestParam usado para URL estaticas
		
		List<Horario> horarios = new LinkedList<>();
		try{
			horarios= serviceHorario.buscarPorIdPalicula(idPelicula,dateFormat.parse(fecha));
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		for (Horario horario : horarios) {
			System.out.println(horario);
		}
		
		
		
		model.addAttribute("horarios",horarios);
		model.addAttribute("fechaBusqueda",fecha);
		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		
		
		return "detalle";
	}
	
	@GetMapping(value="/formLogin")
	public String mostrarLogin(){
		
		return "/formLogin";
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
}
