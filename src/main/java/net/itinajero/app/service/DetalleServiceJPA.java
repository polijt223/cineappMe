package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Detalle;
import net.itinajero.app.repository.DetallesRepository;

@Service
public class DetalleServiceJPA implements IDetalleService {

	@Autowired
	private DetallesRepository detalleRepo;
	
	@Override
	public void insertar(Detalle detalle) {
		
		detalleRepo.save(detalle);
		
	}
	
	@Override
	public void eliminar(int iddetalle){
		detalleRepo.deleteById(iddetalle);
	}

}
