package pruebacrudrepository;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConeccion {

	public static void main(String[] args) {

			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
			
			context.close();
	}

}
