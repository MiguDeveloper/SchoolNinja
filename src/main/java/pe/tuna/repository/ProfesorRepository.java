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

	@Query(value = "call addProfesor(?,?,?,?,?)", nativeQuery = true)
	int addProfesor(String nombres, String apePaterno, String apeMaterno, String dni, String telefono);

	@Query(value = "call getByIdProfesor(?)", nativeQuery = true)
	Profesor getByIdProfesor(int id);

	@Query(value = "call updateProfesor(?,?,?,?,?,?)", nativeQuery = true)
	int updateProfesor(int id, String nombres, String ape_paterno, String ape_materno, String dni, String nro_telefono);

	@Query(value = "call deleteProfesor(?)", nativeQuery = true)
	int deleteProfesor(int id);

}
