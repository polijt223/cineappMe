package net.itinajero.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.stereotype.Service;
import net.itinajero.app.model.Pelicula;


//@Service
public class PeliculasServiceImp implements IPeliculaService{
	
	private List<Pelicula> lista  = new LinkedList<>();
	
	public PeliculasServiceImp(){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		
		
		try {
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Power Rangers");
			pelicula1.setDuracion(145);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstreno(formatter.parse("02-05-2019"));
			//pelicula1.setDetalle();
			
			Pelicula pelicula2 = new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La bella y la bestia");
			pelicula2.setDuracion(126);
			pelicula2.setClasificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstreno(formatter.parse("10-05-2019"));
			pelicula2.setImagen("bella.png");
			
			Pelicula pelicula3 = new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(120);
			pelicula3.setClasificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstreno(formatter.parse("15-06-2019"));
			pelicula3.setImagen("Contratiempo.png");
			
			Pelicula pelicula4 = new Pelicula();
			pelicula4.setId(4);
			pelicula4.setTitulo("Kong La Isla Calavera");
			pelicula4.setDuracion(146);
			pelicula4.setClasificacion("B");
			pelicula4.setGenero("Accion y Aventura");
			pelicula4.setFechaEstreno(formatter.parse("24-06-2019"));
			pelicula4.setImagen("Kong.png");
			pelicula4.setEstatus("Inactiva");
			
			Pelicula pelicula5 = new Pelicula();
			pelicula5.setId(5);
			pelicula5.setTitulo("Life: Vida Inteligente");
			pelicula5.setDuracion(104);
			pelicula5.setClasificacion("B");
			pelicula5.setGenero("Drama");
			pelicula5.setFechaEstreno(formatter.parse("10-06-2019"));
			pelicula5.setImagen("estreno5.png");
			pelicula5.setEstatus("Activa");
			
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			lista.add(pelicula4);
			lista.add(pelicula5);
			
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			
		}
	}
	
	@Override
	public List<Pelicula> buscarTodas() {
		
		return lista;
	}

	@Override 
	public Pelicula buscarPorId(int id) {
		
		for (Pelicula p : lista) {
			if (p.getId() == id ) {
				return p;
			}
		}
		
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {
		lista.add(pelicula);
		
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarTodasDisponibleHoy() {
		// TODO Auto-generated method stub
		return null;
	}


}
