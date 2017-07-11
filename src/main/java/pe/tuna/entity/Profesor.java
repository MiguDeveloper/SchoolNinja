package pe.tuna.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PROFESORES")
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@NotEmpty
	@Size(min = 2, max = 60)
	@Column(name = "NOMBRES")
	private String nombres;

	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "APE_PATERNO")
	private String ape_paterno;

	@NotEmpty
	@Size(min = 2, max = 100)
	@Column(name = "APE_MATERNO")
	private String ape_materno;

	@NotEmpty
	@Size(min = 8, max = 8)
	@Column(name = "DNI")
	private String dni;

	@Column(name = "NRO_TELEFONO")
	private String nro_telefono;

	@Column(name = "FLG_ESTADO")
	private String flg_estado;

	public Profesor() {
	}

	public Profesor(int id, String nombres, String ape_paterno, String ape_materno, String dni, String nro_telefono,
			String flg_estado) {
		this.id = id;
		this.nombres = nombres;
		this.ape_paterno = ape_paterno;
		this.ape_materno = ape_materno;
		this.dni = dni;
		this.nro_telefono = nro_telefono;
		this.flg_estado = flg_estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApe_paterno() {
		return ape_paterno;
	}

	public void setApe_paterno(String ape_paterno) {
		this.ape_paterno = ape_paterno;
	}

	public String getApe_materno() {
		return ape_materno;
	}

	public void setApe_materno(String ape_materno) {
		this.ape_materno = ape_materno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNro_telefono() {
		return nro_telefono;
	}

	public void setNro_telefono(String nro_telefono) {
		this.nro_telefono = nro_telefono;
	}

	public String getFlg_estado() {
		return flg_estado;
	}

	public void setFlg_estado(String flg_estado) {
		this.flg_estado = flg_estado;
	}

}
