package pruebacrudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppExists {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int idNoticia = 100;
		System.out.println("\nLa noticia con el id "+idNoticia+" ."+repo.existsById(idNoticia)+ " existe en la base de datos");
		
		context.close();
		
	}

}
