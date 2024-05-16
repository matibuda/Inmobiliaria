package ar.edu.unlam.pb1;

import java.util.ArrayList;

public class Cliente {
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private String mail;
	private ArrayList<Campo> campos;
	private ArrayList<Casa> casas;
	private ArrayList<Departamento> departamentos;
	private ArrayList<Ph> phs;
	private ArrayList<Terreno> terrenos;

	public Cliente(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
		this.campos = new ArrayList<>();
		this.casas = new ArrayList<>();
		this.departamentos = new ArrayList<>();
		this.phs = new ArrayList<>();
		this.terrenos = new ArrayList<>();
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

	public ArrayList<Campo> getCampos() {
		return campos;
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public ArrayList<Ph> getPhs() {
		return phs;
	}

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public Boolean agregarNuevoCampo(Campo nuevo) {
		for (Campo actual : campos) {
			if (actual == null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean addCasa(Casa nueva) {
		return casas.add(nueva);
	}

	public Boolean addDepto(Departamento nuevo) {
		return departamentos.add(nuevo);
	}

	public Boolean addCampo(Campo nuevo) {
		return campos.add(nuevo);
	}

	public Boolean addPh(Ph nuevo) {
		return phs.add(nuevo);
	}

	public Boolean addTerreno(Terreno nuevo) {
		return terrenos.add(nuevo);
	}

}
