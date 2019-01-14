package pruebarelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculaRepository;

public class AppFindAll {
	

	public static void main (String [] args){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculaRepository repo = context.getBean("peliculaRepository",PeliculaRepository.class);
		
		List<Pelicula> lista = repo.findAll();
		for (Pelicula pelicula : lista) {
			System.out.println(pelicula);
		}
		
		context.close();
	}
	
}
