package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ContactoServiceImp implements IContactoService {

	List<String> tiposLista= new LinkedList<>();
	
	public ContactoServiceImp() {
		tiposLista.add("Estrenos");
		tiposLista.add("Promociones");
		tiposLista.add("Noticias");
		tiposLista.add("Preventas");
				
	}
	
	@Override
	public List<String> getNotificaciones() {

		return tiposLista;
	}

}
