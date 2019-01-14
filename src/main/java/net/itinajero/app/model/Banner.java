package net.itinajero.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="banners")
public class Banner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String estatus = "Activa";
	private String imagen = "cinema.png";
	private String titulo;
	private Date fecha;
	
	public Banner(){
		
	}
	
	public Banner(int id, String estatus, String imagen, String titulo, Date fecha) {
		super();
		this.id = id;
		this.estatus = estatus;
		this.imagen = imagen;
		this.titulo = titulo;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
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

	@Override
	public String toString() {
		return "Banner [id=" + id + ", estatus=" + estatus + ", imagen=" + imagen + ", titulo=" + titulo + ", fecha="
				+ fecha + "]";
	}
	
	
	
	
	
}
