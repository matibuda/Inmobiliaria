package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Cliente{
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private String mail;
	private ArrayList<Propiedad> propiedades;

	public Cliente(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.propiedades = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getDni() {
		return dni;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public Boolean agregarPropiedad(Propiedad nueva) {
		return propiedades.add(nueva);
	}
	
	public Boolean eliminarPropiedad(Propiedad aEliminar) {
		return propiedades.remove(aEliminar);
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

}
