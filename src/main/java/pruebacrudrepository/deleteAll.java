package pruebacrudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import net.itinajero.app.repository.NoticiasRepository;

public class deleteAll {
	
		public static void main(String[] args) {
	
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
			NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
	
			//elimina todos los registros de la tabla
			repo.deleteAll();
			
			context.close();
		}
}
