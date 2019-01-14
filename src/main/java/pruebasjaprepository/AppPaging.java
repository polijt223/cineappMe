package pruebasjaprepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		//La paginacion inicia desde cero "0" es decir la primer pagina es 0
		//el primer valor indica la pagina y el segundo valor indica la cantidad de elementos a paginar
		Page<Noticia> page = repo.findAll(PageRequest.of(2, 10));
		for (Noticia noticia : page) {
			System.out.println(noticia);
		}
		
		context.close();
		
	}

}
