package pe.tuna.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.tuna.entity.Alumno;
import pe.tuna.repository.AlumnoRepository;
import pe.tuna.service.AlumnoService;

@Service("alumnoServiceImpl")
public class AlumnoServiceImpl implements AlumnoService {

	private static final Logger logger = Logger.getLogger(AlumnoServiceImpl.class);

	@Autowired
	@Qualifier("alumnoRepository")
	private AlumnoRepository alumnoRepository;

	@Override
	public List<Alumno> getAndFindAlumno(String apePaterno) {
		logger.info("Listando todos los alumnos/buscando por apellido : " + apePaterno);
		return alumnoRepository.getAndFindAlumno(apePaterno);
	}

	@Override
	public int addAlumno(Alumno alumno) {
		logger.info("Agregando un nuevo alumno: " + alumno.getNombres() + " " + alumno.getApe_paterno());
		return alumnoRepository.addAlumno(alumno.getNombres(), alumno.getApe_paterno(), alumno.getApe_materno(),
				alumno.getTipo_documentos_id(), alumno.getNro_documento(), alumno.getFecha_nacimiento());
	}

	@Override
	public Alumno getByIdAlumno(int id) {
		logger.info("Obteniedo alumno por id: " + id);
		return alumnoRepository.getByIdAlumno(id);
	}

	@Override
	public int updateAlumno(Alumno alumno) {
		logger.info("Actualizando alumno ID: " + alumno.getId() + ", nombres y apellidos: " + alumno.getNombres() + " "
				+ alumno.getApe_paterno() + " " + alumno.getApe_materno() + ", Fecha Macimiento: " + alumno.getFecha_nacimiento());
		return alumnoRepository.updateAlumno(alumno.getId(), alumno.getNombres(), alumno.getApe_paterno(),
				alumno.getApe_materno(), alumno.getTipo_documentos_id(), alumno.getNro_documento(),
				alumno.getFecha_nacimiento());
	}

	@Override
	public int deleteAlumno(int id) {
		logger.info("Desactivando un alumno a estado 0");
		return alumnoRepository.deleteAlumno(id);
	}

}
