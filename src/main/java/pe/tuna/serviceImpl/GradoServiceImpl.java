package pe.tuna.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.tuna.entity.Grado;
import pe.tuna.repository.GradoRepository;
import pe.tuna.service.GradoService;

@Service("gradoServiceImpl")
public class GradoServiceImpl implements GradoService {

	// implementamos los errores por consola
	private static final Logger logger = Logger.getLogger(GradoServiceImpl.class);

	// implementamos la comunicacion con la capa DAO
	@Autowired
	@Qualifier("gradoRepository")
	private GradoRepository gradoRepository;

	// Metodo para obtener todos los empleado o obtener algunos por su
	// nombre(método like de la consulta SQL)
	@Override
	public List<Grado> getAndFindGrados(String descripcion) {
		logger.info("listando grados, parametro descripción es: '" + descripcion + "'");
		return gradoRepository.getAndFindGrados(descripcion);
	}

	// Crea un nuevo Grado en la base de datos
	@Override
	public int addGrado(String nombre) {
		logger.info("Agregando un grado");
		return gradoRepository.addGrado(nombre);
	}

	// obtenemos un grado para mostrarlo en el formulario de actualizacion de
	// datos
	@Override
	public Grado getById(int id) {
		logger.info("Obtenemos un grado por su ID: " + id);
		return gradoRepository.getById(id);
	}

	// Método para actualizar los datos de un grado
	@Override
	public int updateGrado(int id, String nombre) {
		logger.info("Actualizamos grado, parametro nombre es: " + nombre);
		return gradoRepository.updateGrado(id,nombre);
	}

	// Método para poner en estado desactivado pero no eliminado
	@Override
	public int deleteGrado(int id) {
		logger.info("Desactivando grado con id: " + id);
		return gradoRepository.deleteGrado(id);
	}

}
