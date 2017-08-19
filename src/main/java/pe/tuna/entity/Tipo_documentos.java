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
@Table(name = "TIPO_DOCUMENTOS")
public class Tipo_documentos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@NotEmpty
	@Size(min = 2, max = 99)
	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "FLG_ESTADO")
	private String flg_estado;

	public Tipo_documentos() {
	}

	public Tipo_documentos(int id, String descripcion, String flg_estado) {
		this.id = id;
		this.descripcion = descripcion;
		this.flg_estado = flg_estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFlg_estado() {
		return flg_estado;
	}

	public void setFlg_estado(String flg_estado) {
		this.flg_estado = flg_estado;
	}

}
