package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.itinajero.app.model.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Integer> {
	
		@Query("select distinct h.fecha from Horario h")
		public List<Date> getByFechaDisponibles();

		public List<Horario> findByPeliculaIdAndFechaOrderByHora(int idPelicula, Date date);
		
		public List<Horario> findByFechaOrderByHora(Date date);
		
		public List<Horario> findByFecha(Date fecha);
		
		@Query("select distinct h.pelicula.id from Horario h  where h.fecha= :fecha order by h.pelicula.id")
		public List<Integer> getByFechaDisponibleshoy(@Param("fecha") Date fecha);
		
		@Query("select distinct h.pelicula.id from Horario h  where h.fecha= :fecha and h.pelicula.estatus='Activa' order by h.pelicula.id")
		public List<Integer> getByFechaDisponibleshoyActiva(@Param("fecha") Date fecha);
		
		


		
	
}
