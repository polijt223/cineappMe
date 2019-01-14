package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import net.itinajero.app.model.Banner;
import net.itinajero.app.service.IBannerService;
import net.itinajero.app.util.Utileria;

@Controller
@RequestMapping("/banners")
public class BannerController {

	@Autowired
	IBannerService bannerService ;
	
	@GetMapping("/index")
	public String mostrarIndex (Model model){
		model.addAttribute("banners",bannerService.findAll());
		return "banner/listBanner";
	}
	
	@GetMapping("/delete/{id}")
	public String delete (@PathVariable("id") int id,RedirectAttributes atributes){
		bannerService.delete(id);
		atributes.addFlashAttribute("mensaje","El registro fue eliminado");
		return "redirect:/banners/index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") int id, Model model){
		model.addAttribute("banner",bannerService.findById(id));
		return "/banner/formBanner";
	}
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Banner banner,Model model){
		return "banner/formBanner";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Banner banner,BindingResult result,RedirectAttributes attributes,@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request){
		banner.setFecha(new Date());
		
		if(result.hasErrors()){
			return "banner/formBanner";
		}
		
		if (!multiPart.isEmpty()) {
			banner.setImagen(Utileria.guardarImagen(multiPart, request));
		}
		
		bannerService.save(banner);
		attributes.addFlashAttribute("mensaje","El registro fue guardado");
		return "redirect:/banners/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
