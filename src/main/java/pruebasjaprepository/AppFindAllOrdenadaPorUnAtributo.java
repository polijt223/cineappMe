package pruebasjaprepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAllOrdenadaPorUnAtributo {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		
		//Por default se ordena de forma ascendente para modificarlo abria que agregar lo siguiente  Sort.by("titulo").descending()
		//List<Noticia> list = repo.findAll(Sort.by("titulo").descending());
		List<Noticia> list = repo.findAll(Sort.by("titulo").descending());
		for (Noticia noticia : list) {
			System.out.println(noticia);
		}
		context.close();

	}

}
