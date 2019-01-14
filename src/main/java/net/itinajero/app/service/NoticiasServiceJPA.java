package net.itinajero.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;
import net.itinajero.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Autowired
	NoticiasRepository noticiasRepo ;
	
	@Override
	public void guardar(Noticia noticia) {
		noticiasRepo.save(noticia);
		
	}

	@Override
	public List<Noticia> listaNoticiasActivas() {
		return noticiasRepo.findTop3ByStatusOrderByIdDesc("Activa");
	}

	@Override
	public List<Noticia> listaNoticias() {
		return noticiasRepo.findBy();
	}

	@Override
	public Page<Noticia> buscarTodas(Pageable page) {
		return noticiasRepo.findAll(page);
	}

	@Override
	public Noticia buscarPorId(int id) {
		Optional<Noticia> optional = noticiasRepo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}

	@Override
	public void deleteNoticia(int id) {
		noticiasRepo.deleteById(id);
		
	}
	
}
