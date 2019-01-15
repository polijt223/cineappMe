package net.itinajero.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.itinajero.app.model.Perfil;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {
	
	Perfil findByCuenta(String cuenta);
	
	void deleteByCuenta(String cuenta);
	
	
}
