package pe.tuna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.tuna.entity.Tipo_documentos;

@Repository("tipo_documentosRepository")
public interface Tipo_documentosRepository extends JpaRepository<Tipo_documentos, Integer> {

	// Listar los tipo de documentos de identificacion
	@Query(value = "call getAndFindTipoDocumentos(?)", nativeQuery = true)
	List<Tipo_documentos> getAndFindTipoDocumentos(String descripcion);

	// Crear tipo de documento de identificacion
	@Query(value = "call addTipoDocumentos(?)", nativeQuery = true)
	int addTipoDocumentos(String descripcion);

	// Obtener por id el tipo de documento para su posterior actualizacion
	@Query(value = "call getByIdTipoDocumentos(?)", nativeQuery = true)
	Tipo_documentos getByIdTipoDocumentos(int id);

	// Actualizamos el tipo de documento
	@Query(value = "call updateTipoDocumentos(?,?)", nativeQuery = true)
	int updateTipoDocumentos(int id, String descripcion);

	// Desable tipo de documeto con 0
	@Query(value = "call deleteTipoDocumentos(?)", nativeQuery = true)
	int deleteTipoDocumentos(int id);
}
