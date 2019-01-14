package net.itinajero.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.itinajero.app.model.Horario;

public interface IHorarioService {
	
	List<Horario> buscarPorIdPalicula(int idPelicula, Date fecha);
	List<Horario> findByFecha(Date date);
	List<Date> buscarfechasActivas();
	List<Horario> getAll();
	List<Integer> getByFechaDisponibleshoy(Date date);
	List<Integer> getByFechaDisponibleshoyActiva(Date date);
	List<Horario> findByFechaOrderByHora(Date date);
	Page<Horario> buscarTodasPage(Pageable page);
	void save(Horario horario);
	void delete(int idHorario);
	Horario findById(int id);
}
