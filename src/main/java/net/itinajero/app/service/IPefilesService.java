package net.itinajero.app.service;

import net.itinajero.app.model.Perfil;

public interface IPefilesService {
	
	void save(Perfil perfil);
	void deleteByCuenta(String cuenta);
	Perfil findByCuenta(String cuenta);
}
