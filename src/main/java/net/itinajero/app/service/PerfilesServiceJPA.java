package net.itinajero.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Perfil;
import net.itinajero.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPefilesService {

	@Autowired
	private PerfilesRepository perfilRepo;
	
	
	@Override
	public void save(Perfil perfil) {
		perfilRepo.save(perfil);

	}


	@Override
	public void deleteByCuenta(String cuenta) {
		perfilRepo.deleteByCuenta(cuenta);
		
	}


	@Override
	public Perfil findByCuenta(String cuenta) {
		return perfilRepo.findByCuenta(cuenta);
	}

}
