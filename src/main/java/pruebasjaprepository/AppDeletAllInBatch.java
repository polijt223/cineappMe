package pruebasjaprepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.repository.NoticiasRepository;

public class AppDeletAllInBatch {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//Este metodo se diferencia del deleteAll(), en que elimina todos los registros con una sola 
		//instruccion por lo que lo hace mas efiociente si se requiere eliminar miles de registros
		
		repo.deleteAllInBatch();
		
		context.close();
		
	}

}
