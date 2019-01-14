package net.itinajero.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Pelicula;
import net.itinajero.app.repository.PeliculaRepository;


@Service
public class peliculasServiceJPA implements IPeliculaService {
	
	@Autowired
	private PeliculaRepository peliculasRepo;
	
	@Override
	public List<Pelicula> buscarTodas() {
		
		return peliculasRepo.findAll();
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	}
	
	@Override
	public Pelicula buscarPorId(int id) {
		Optional<Pelicula> opcional = peliculasRepo.findById(id);
		if (opcional.isPresent()) {
			return opcional.get();
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
		
	}

	@Override
	public List<String> buscarGenero() {
		List<String> generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");

		
		return generos;
	}

	@Override
	public void eliminar(int idpelicula) {
		peliculasRepo.deleteById(idpelicula);
		
	}

	@Override
	public List<Pelicula> buscarTodasDisponibleHoy() {
		// TODO Auto-generated method stub
		return null;
	}

}
