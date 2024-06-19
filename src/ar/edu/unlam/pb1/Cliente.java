package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente implements Inquilino{
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private String mail;
	private ArrayList<Propiedad> propiedades;
	private ArrayList<Propiedad> propiedadesAlquiladas;

	public Cliente(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.propiedades = new ArrayList<>();
		this.propiedadesAlquiladas= new ArrayList<>();
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
	
	@Override
	public ArrayList<Propiedad> getPropiedadesAlquiladas() {
		return propiedadesAlquiladas;
	}

	public Boolean agregarPosesionDePropiedadAlCliente(Propiedad nueva) {
		return propiedades.add(nueva);
	}
	
	public Boolean eliminarPosesionDeLaPropiedad(Propiedad aEliminar) {
		return propiedades.remove(aEliminar);
	}
	
	@Override
	public Boolean agregarPropiedadAlInquilino(Propiedad nueva) {
		return propiedadesAlquiladas.add(nueva);
	}
	@Override
	public Boolean eliminarPropiedadAlInquilino(Propiedad aEliminar) {
		return propiedadesAlquiladas.remove(aEliminar);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

}
