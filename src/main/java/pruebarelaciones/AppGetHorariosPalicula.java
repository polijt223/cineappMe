package pruebarelaciones;


import java.util.Optional;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculaRepository;

public class AppGetHorariosPalicula {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		PeliculaRepository repo = context.getBean("peliculaRepository",PeliculaRepository.class);
		
		Optional<Pelicula> optional = repo.findById(2);
		
		System.out.println("Cantidad de Horarios para la pelicula Id 2: "+optional.get().getHorarios().size());
		
		context.close();
	}

}
