package pruebacrudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

public class AppFindAll {

		public static void main(String[] args) {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
			NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);

			//Recuperar todos los registros (metodo findAll del repositorio)
			Iterable<Noticia> it=repo.findAll();
			for (Noticia noticia : it) {
				System.out.println(noticia);
			}
			context.close();
		}
	

}
