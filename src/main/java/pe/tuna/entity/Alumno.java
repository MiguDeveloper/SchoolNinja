package pe.tuna.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ALUMNOS")
@SqlResultSetMapping(
		name="lstAllAlumnos",
		classes={
				@ConstructorResult(
						targetClass=Alumno.class,
						columns={
								@ColumnResult(name="ID"),
								@ColumnResult(name="NOMBRES"),
								@ColumnResult(name="APE_PATERNO"),
								@ColumnResult(name="APE_MATERNO"),
								@ColumnResult(name="TIPO_DOCUMENTOS_ID"),
								@ColumnResult(name="TIPO_DOCUMENTO"),
								@ColumnResult(name="NRO_DOCUMENTO"),
								@ColumnResult(name="FECHA_NACIMIENTO"),
								@ColumnResult(name="FLG_ESTADO")
						}
				)
		}
)
@NamedNativeQuery(name = "getAndFindAlumnos", query="call getAndFindAlumnos(?)", resultSetMapping="lstAllAlumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@NotEmpty
	@Size(min = 2, max = 59)
	@Column(name = "NOMBRES")
	private String nombres;

	@NotEmpty
	@Size(min = 2, max = 99)
	@Column(name = "APE_PATERNO")
	private String ape_paterno;

	@NotEmpty
	@Size(min = 2, max = 99)
	@Column(name = "APE_MATERNO")
	private String ape_materno;

	@Min(1)
	@Column(name = "TIPO_DOCUMENTOS_ID")
	private int tipo_documentos_id;

	@Transient
	private String tipo_documento;

	@Column(name = "NRO_DOCUMENTO")
	private String nro_documento;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Column(name = "FECHA_NACIMIENTO")
	private Date fecha_nacimiento;

	@Column(name = "FLG_ESTADO")
	private String flg_estado;

	public Alumno() {
	}

	public Alumno(int id, String nombres, String ape_paterno, String ape_materno, int tipo_documentos_id,
			String tipo_documento, String nro_documento, Date fecha_nacimiento, String flg_estado) {
		this.id = id;
		this.nombres = nombres;
		this.ape_paterno = ape_paterno;
		this.ape_materno = ape_materno;
		this.tipo_documentos_id = tipo_documentos_id;
		this.tipo_documento = tipo_documento;
		this.nro_documento = nro_documento;
		this.fecha_nacimiento = fecha_nacimiento;
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

	public int getTipo_documentos_id() {
		return tipo_documentos_id;
	}

	public void setTipo_documentos_id(int tipo_documentos_id) {
		this.tipo_documentos_id = tipo_documentos_id;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNro_documento() {
		return nro_documento;
	}

	public void setNro_documento(String nro_documento) {
		this.nro_documento = nro_documento;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFlg_estado() {
		return flg_estado;
	}

	public void setFlg_estado(String flg_estado) {
		this.flg_estado = flg_estado;
	}

}
