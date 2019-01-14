package pruebasjaprepository;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAllShortForVariosCampos {

	public static void main(String [] args){
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		List<Noticia> lista = repo.findAll(Sort.by("titulo").descending().and(Sort.by("fecha").ascending()));
		
		for (Noticia noticia : lista) {
			System.out.println(noticia);
		}
		
		context.close();
	}
	
	
}
