package pe.tuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.tuna.entity.Grado;

@Repository("gradoRepository")
public interface GradoRepository extends JpaRepository<Grado, Integer> {

	// listar los grados
	@Query(value = "call getAndFindGrados(?)", nativeQuery = true)
	List<Grado> getAndFindGrados(String descripcion);

	// Crear un grado
	@Query(value = "call addGrado(?)", nativeQuery = true)
	int addGrado(String nombre);

	// Obtener por id
	@Query(value = "call getByIdGrado(?)", nativeQuery = true)
	Grado getById(int id);

	// Actualizar
	@Query(value = "call updateGrado(?,?)", nativeQuery = true)
	int updateGrado(int id, String nombre);

	// Eliminar
	@Query(value = "call deleteGrado(?)", nativeQuery = true)
	int deleteGrado(int id);

}
