package pe.tuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.tuna.entity.Profesor;

@Repository("profesorRepository")
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
	
	@Query(value = "call getAndFindProfesores(?)", nativeQuery = true)
	List<Profesor> getAndFindProfesores(String apePaterno);
	
}
