package pruebacrudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Dragon ball z Broli (2018). Revelan voces en latino de la nueva pelicula");
		noticia.setDetalle("La vos de Son Goku sera interpretada por el galardona Guillermo del Toro");
		
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		
		
		context.close();

	}

}
