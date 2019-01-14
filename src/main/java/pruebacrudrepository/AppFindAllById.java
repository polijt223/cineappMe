package pruebacrudrepository;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Integer> ids = new LinkedList<>();
		ids.add(6);
		ids.add(7);
		ids.add(8);
		ids.add(9);
		ids.add(10);
		
		Iterable<Noticia> it = repo.findAllById(ids);
		for (Noticia noticia : it) {
			System.out.println(noticia);
		}
		
		context.close();
	}

}
