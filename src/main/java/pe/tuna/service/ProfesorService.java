package pe.tuna.service;

import java.util.List;

import pe.tuna.entity.Profesor;

public interface ProfesorService {
	public List<Profesor> getAndFindProfesores(String apePaterno);
	public int addProfesor(Profesor profesor);
}