package pruebasKeywordsqueryjpa;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppKeywordAnd {

	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository",NoticiasRepository.class);
		
		List<Noticia>  list = null;
		
		try {
			//Ejemplo Keyword findBy
			list =repo.findByStatusAndFecha("Activa", format.parse("2017-09-08"));
			
			for (Noticia noticia : list ) {
				System.out.println(noticia);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		context.close();
	}

}
