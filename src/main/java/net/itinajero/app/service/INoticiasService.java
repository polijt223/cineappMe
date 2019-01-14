package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Noticia;

public interface INoticiasService {

	void guardar (Noticia noticia);
	List<Noticia> listaNoticiasActivas();
	List<Noticia> listaNoticias();
	Page<Noticia> buscarTodas(Pageable page);
	Noticia buscarPorId(int id);
	void deleteNoticia(int id);
}
