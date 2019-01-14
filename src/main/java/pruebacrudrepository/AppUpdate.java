package pruebacrudrepository;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//1- primero buscamos la entidad que vamos a modificar (findById)
		Optional<Noticia> opcional = repo.findById(1);
		
		if(opcional.isPresent()){
			Noticia noticia = opcional.get();
			System.out.println(noticia);
			noticia.setStatus("Inactiva");
			repo.save(noticia);
		}
		
		context.close();
		
		
		
	}

}
