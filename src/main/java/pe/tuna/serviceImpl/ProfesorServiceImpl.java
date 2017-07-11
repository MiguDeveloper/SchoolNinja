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

}
