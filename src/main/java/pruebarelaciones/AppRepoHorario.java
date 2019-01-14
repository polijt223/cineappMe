package pruebarelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorarioRepository;

public class AppRepoHorario {

	public static void main(String[] args) {


		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		HorarioRepository repo = context.getBean("horarioRepository",HorarioRepository.class);
		
		
		List<Horario> lista = repo.findAll();
		System.out.println("Numero de entidades en la lista: "+lista.size());

		for (Horario horario : lista) {
			System.out.println(horario);
		}
		
		context.close();
	}

}
