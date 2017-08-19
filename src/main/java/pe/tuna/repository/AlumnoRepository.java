package pe.tuna.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.tuna.entity.Alumno;

@Repository("alumnoRepository")
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	// Listamos los alumnos
	@Query(name = "getAndFindAlumnos")
	List<Alumno> getAndFindAlumno(String apePaterno);

	// Creamos un alumno
	@Query(value = "call addAlumno(?,?,?,?,?,?)", nativeQuery = true)
	int addAlumno(String nombres, String ape_paterno, String ape_materno, int tipoDoc_id, String nroDoc, Date fechaNac);

	// obtener por id
	@Query(value = "call getByIdAlumno(?)", nativeQuery = true)
	Alumno getByIdAlumno(int id);

	// Actualizar alumno
	@Query(value = "call updateAlumno(?,?,?,?,?,?,?)", nativeQuery = true)
	int updateAlumno(int id, String nombres, String ape_paterno, String ape_materno, int tipoDoc_id, String nroDoc,
			Date fechaNac);

	// Eliminar
	@Query(value = "call deleteAlumno(?)", nativeQuery = true)
	int deleteAlumno(int id);

}
