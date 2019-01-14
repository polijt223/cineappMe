package pruebasjaprepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;
import org.springframework.data.domain.Page;

public class AppPagingAndShor {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		Page<Noticia> page = repo.findAll(PageRequest.of(0,10,Sort.by("fecha")));
		for (Noticia noticia : page) {
			System.out.println(noticia);
		}
		context.close();
	}

}
