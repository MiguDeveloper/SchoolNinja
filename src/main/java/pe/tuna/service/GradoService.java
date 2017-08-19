package pe.tuna.service;

import java.util.List;

import pe.tuna.entity.Grado;

public interface GradoService {

	// listar los grados
	public List<Grado> getAndFindGrados(String descripcion);

	// Crear un grado
	public int addGrado(String nombre);

	// Obtener por id
	public Grado getById(int id);

	// Actualizar
	public int updateGrado(int id, String nombre);

	// Eliminar
	public int deleteGrado(int id);

}
