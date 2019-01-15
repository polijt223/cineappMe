package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Usuario;
import net.itinajero.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuarioRepo;
	
	@Override
	public void save(Usuario usuario) {
		usuarioRepo.save(usuario);

	}

	@Override
	public void delete(int id) {
		usuarioRepo.deleteById(id);
		
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepo.findAll();
	}

	@Override
	public Usuario findById(int id) {
		Optional<Usuario> optional = usuarioRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
