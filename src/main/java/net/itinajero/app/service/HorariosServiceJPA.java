package net.itinajero.app.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import net.itinajero.app.model.Horario;
import net.itinajero.app.repository.HorarioRepository;

@Service
public class HorariosServiceJPA implements IHorarioService {
	
	@Autowired
	HorarioRepository horariorepo;
	
	@Override
	public List<Horario> buscarPorIdPalicula(int idPelicula, Date fecha) {
		return horariorepo.findByPeliculaIdAndFechaOrderByHora(idPelicula, fecha);
		
	}

	@Override
	public List<Date> buscarfechasActivas() {
		return horariorepo.getByFechaDisponibles();
	}

	@Override
	public List<Horario> findByFecha(Date date) {
		return horariorepo.findByFecha(date);
	}

	@Override
	public List<Horario> getAll() {
		return horariorepo.findAll();
	}

	@Override
	public List<Integer> getByFechaDisponibleshoy(Date date) {
		return horariorepo.getByFechaDisponibleshoy(date);
	}

	@Override
	public List<Horario> findByFechaOrderByHora(Date date) {
		return horariorepo.findByFechaOrderByHora(date);
	}

	@Override
	public Page<Horario> buscarTodasPage(Pageable page) {
		return horariorepo.findAll(page);
	}

	@Override
	public void save(Horario horario) {
		horariorepo.save(horario);
		
	}

	@Override
	public void delete(int idHorario) {
		horariorepo.deleteById(idHorario);
		
	}

	@Override
	public Horario findById(int id) {
		Optional<Horario> optional = horariorepo.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		
		return null;
	}

	@Override
	public List<Integer> getByFechaDisponibleshoyActiva(Date date) {
		return horariorepo.getByFechaDisponibleshoyActiva(date);
	}
	
	

}
