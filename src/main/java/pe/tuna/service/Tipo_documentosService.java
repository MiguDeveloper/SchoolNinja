package pe.tuna.service;

import java.util.List;

import pe.tuna.entity.Tipo_documentos;

public interface Tipo_documentosService {

	public List<Tipo_documentos> getAndFindTipoDocumentos(String descripcion);
	public int addTipoDocumentos(String descripcion);
	public Tipo_documentos getByIdTipoDocumentos(int id);
	public int updateTipoDocumentos(Tipo_documentos tipoDoc);
	public int deleteTipoDocumentos(int id);
	
}
