package pe.tuna.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import pe.tuna.entity.Tipo_documentos;
import pe.tuna.repository.Tipo_documentosRepository;
import pe.tuna.service.Tipo_documentosService;

@Service("Tipo_documentosServiceImpl")
public class Tipo_documentosServiceImpl implements Tipo_documentosService{

	private static final Logger logger = Logger.getLogger(Tipo_documentosServiceImpl.class);
	
	@Autowired
	@Qualifier("tipo_documentosRepository")
	private Tipo_documentosRepository tipoDocRepo;
	
	@Override
	public List<Tipo_documentos> getAndFindTipoDocumentos(String descripcion) {
		logger.info("Listando tipo de documento / buscando con parametro: " + descripcion);
		List<Tipo_documentos> lstTipoDoc = new ArrayList<Tipo_documentos>();
		lstTipoDoc = tipoDocRepo.getAndFindTipoDocumentos("");
		
		return lstTipoDoc;
	}

	@Override
	public int addTipoDocumentos(String descripcion) {
		logger.info("Agregando nuevo tipo de documento: " + descripcion);
		return tipoDocRepo.addTipoDocumentos(descripcion);
	}

	@Override
	public Tipo_documentos getByIdTipoDocumentos(int id) {
		logger.info("Retornando tipo documento con ID: " + id);
		return tipoDocRepo.getByIdTipoDocumentos(id);
	}

	@Override
	public int updateTipoDocumentos(Tipo_documentos tipoDoc) {
		logger.info("Actualizando tipo de documento, parametro recibido: " + tipoDoc.getId());
		return tipoDocRepo.updateTipoDocumentos(tipoDoc.getId(), tipoDoc.getDescripcion());
	}

	@Override
	public int deleteTipoDocumentos(int id) {
		logger.info("Desabilitando tipo documento con ID:" + id);
		return tipoDocRepo.deleteTipoDocumentos(id);
	}

}
