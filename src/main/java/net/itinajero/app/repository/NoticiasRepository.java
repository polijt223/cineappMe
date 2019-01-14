package net.itinajero.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import net.itinajero.app.model.Noticia;


//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
@Repository
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {

	// select * from Noticia
	List<Noticia> findBy();
	
	@Query("SELECT n FROM Noticia n where n.status='Activa' order by n.id desc")  //Crashea la app cuando se usa la sentencia limit 
	List<Noticia> getStatusActiva();
	
	List<Noticia> findTop3ByStatusOrderByIdDesc(String Status); 
	
	// select * from Noticia where fecha = ?
	List<Noticia> findByFecha(Date date);
	
	// select * from Noticia where estatus=? AND fecha=?
	List<Noticia> findByStatusAndFecha(String estatus,Date date);
	
	// select * from Noticia where estatus=? OR fecha=?
	List<Noticia> findByStatusOrFecha(String estatus,Date date);
		
	// select * from Noticia between '2017-09-07' AND '2017-09-07';
	List<Noticia> findByFechaBetween(Date date1 , Date date2);
	
	//select * from Noticia where id between 15 AND 20;
	List<Noticia> findByIdBetween(int id1,int id2);
	
	
		
}
