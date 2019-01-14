package net.itinajero.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import org.springframework.stereotype.Service;

import net.itinajero.app.model.Noticia;

//@Service 
public class NoticiasServiceImp implements INoticiasService {
	
	
	Noticia noticia = new Noticia();
	
	@Override
	public void guardar(Noticia noticia) {
		
		this.noticia = noticia;
		
		System.out.println(this.noticia);
	}

	@Override
	public List<Noticia> listaNoticiasActivas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Noticia> listaNoticias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Noticia> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Noticia buscarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNoticia(int id) {
		// TODO Auto-generated method stub
		
	}

}
