package net.itinajero.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="noticias")
public class Noticia {
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE) se utiliza para oracle
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="titulo",length=250,nullable=false)
	private String titulo;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="detalle")
	private String detalle;
	@Column(name="estatus")
	private String status;
	
	public Noticia (){
		this.fecha = new Date();
		this.status = "activa";
	}
	
	public Noticia (String titulo, String detalle, String status){
		this.fecha = new Date();
		this.status = status;
		this.titulo = titulo;
		this.detalle = detalle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", detalle=" + detalle + ", status="
				+ status + "]";
	}
	
	
	
	
}
