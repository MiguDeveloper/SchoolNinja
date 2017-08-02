package pe.tuna.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.tuna.entity.Profesor;
import pe.tuna.repository.ProfesorRepository;
import pe.tuna.service.ProfesorService;

@Service("profesorServiceImpl")
public class ProfesorServiceImpl implements ProfesorService {

	private static final Logger logger = Logger.getLogger(ProfesorServiceImpl.class);

	@Autowired
	@Qualifier("profesorRepository")
	private ProfesorRepository profesorRepository;

	@Override
	public List<Profesor> getAndFindProfesores(String apePaterno) {
		logger.info("Listando o buscando profesor");
		return profesorRepository.getAndFindProfesores(apePaterno);
	}

	@Override
	public int addProfesor(Profesor profesor) {
		logger.info("Agregando nuevo profesor");
		int flgOperacion = profesorRepository.addProfesor(profesor.getNombres(), profesor.getApe_paterno(),
				profesor.getApe_materno(), profesor.getDni(), profesor.getNro_telefono());
		return flgOperacion;
	}

	@Override
	public Profesor getByIdProfesor(int id) {
		logger.info("obteniendo profesor por id: " + id);
		Profesor profesor = profesorRepository.getByIdProfesor(id);
		return profesor;
	}

	@Override
	public int updateProfesor(Profesor profesor) {
		int flgOperacion = profesorRepository.updateProfesor(profesor.getId(), profesor.getNombres(), profesor.getApe_paterno(),
				profesor.getApe_materno(), profesor.getDni(), profesor.getNro_telefono());
		return flgOperacion;
	}

}
