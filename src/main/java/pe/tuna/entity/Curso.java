package pe.tuna.entity;

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

@Entity
@Table(name = "CURSOS")
@SqlResultSetMapping(
		name = "lstAllCursos",
		classes = {
				@ConstructorResult(
						targetClass = Curso.class,
						columns = {
								@ColumnResult(name="ID"),
								@ColumnResult(name="CODIGO"),
								@ColumnResult(name="NOMBRE"),
								@ColumnResult(name="DETALLE"),
								@ColumnResult(name="GRADOS_ID"),
								@ColumnResult(name="GRADO"),
								@ColumnResult(name="FLG_ESTADO"),
						}
				)
		}
)
@NamedNativeQuery(name = "getAndFindCursor" , query = "call getAndFindCursor(?)", resultSetMapping = "lstAllCursos" )
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@NotEmpty
	@Size(min=1, max=45)
	@Column(name="CODIGO")
	private String codigo;
	
	@NotEmpty
	@Size(min=2, max=100)
	@Column(name="NOMBRE")
	private String nombre;
	
	@Size( max=199)
	@Column(name="DETALLE")
	private String detalle;
	
	@Min(1)
	@Column(name="GRADO_ID")
	private int grados_id;
	
	@Transient
	private String grado;
	
	@Column(name="FLG_ESTADO")
	private String flg_estado;

	public Curso() {
	}

	public Curso(int id, String codigo, String nombre, String detalle, int grados_id, String grado, String flg_estado) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.detalle = detalle;
		this.grados_id = grados_id;
		this.grado = grado;
		this.flg_estado = flg_estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public int getGrados_id() {
		return grados_id;
	}

	public void setGrados_id(int grados_id) {
		this.grados_id = grados_id;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getFlg_estado() {
		return flg_estado;
	}

	public void setFlg_estado(String flg_estado) {
		this.flg_estado = flg_estado;
	}

}
