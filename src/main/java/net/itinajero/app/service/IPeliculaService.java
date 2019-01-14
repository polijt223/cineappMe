package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Pelicula;

public interface IPeliculaService {
	
	List<Pelicula> buscarTodas();
	List<Pelicula> buscarTodasDisponibleHoy();
	Pelicula buscarPorId(int id);
	void insertar(Pelicula pelicula);
	List<String> buscarGenero ();
	void eliminar(int idpelicula);
	Page<Pelicula> buscarTodas(Pageable page);
	
}