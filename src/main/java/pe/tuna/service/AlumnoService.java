package pe.tuna.service;

import java.util.List;

import pe.tuna.entity.Alumno;

public interface AlumnoService {
	public List<Alumno> getAndFindAlumno(String apePaterno);
	public int addAlumno(Alumno alumno);
	public Alumno getByIdAlumno(int id);
	public int updateAlumno(Alumno alumno);
	public int deleteAlumno(int id);
}
