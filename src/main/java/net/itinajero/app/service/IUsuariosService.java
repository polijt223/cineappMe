package net.itinajero.app.service;

import java.util.List;

import net.itinajero.app.model.Usuario;

public interface IUsuariosService {
	void save(Usuario usuario);
	void delete(int id);
	List<Usuario> findAll();
	Usuario findById(int id);
}
