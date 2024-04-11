package ar.edu.unlam.pb1;

public class Cliente {
	private Integer dni;
	private String nombre;
	private String apellido;
	private Integer telefono;
	private String mail;
	private Campo campos[];
	private Casa casas[];
	private Departamento departamentos[];
	private Ph phs[];
	private Terreno terrenos[];

	public Cliente(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.mail = mail;
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

	public Campo[] getCampos() {
		return campos;
	}

	public Casa[] getCasas() {
		return casas;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public Ph[] getPhs() {
		return phs;
	}

	public Terreno[] getTerrenos() {
		return terrenos;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public Boolean agregarNuevoCampo(Campo nuevo) {
		for(Campo actual : campos) {
			if(actual==null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean agregarNuevaCasa(Casa nuevo) {
		for(Casa actual : casas) {
			if(actual==null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean agregarNuevoDepartamento(Departamento nuevo) {
		for(Departamento actual : departamentos) {
			if(actual==null) {
				actual = nuevo;
				return true;
			}
		}
		return false;		
	}

	public Boolean agregarNuevoPh(Ph nuevo) {
		for(Ph actual : phs) {
			if(actual==null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean agregarNuevoTereno(Terreno nuevo) {
		for(Terreno actual : terrenos) {
			if(actual==null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
		
	}
	
	

}
