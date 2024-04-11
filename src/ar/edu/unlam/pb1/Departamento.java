package ar.edu.unlam.pb1;

import java.util.Objects;

public class Departamento {
	private static Integer contador = 1;
	private String codigo;
	private String calle;
	private Integer numero;
	private String pisoYNumero;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TIPO_DE_OPERACION tipo;
	
	public Departamento(String calle, Integer numero, String pisoYNumero, String ciudad, Double precio,
			Boolean estaDisponible, TIPO_DE_OPERACION tipo) {
		this.codigo = "DE" + contador++;
		this.calle = calle;
		this.numero = numero;
		this.pisoYNumero = pisoYNumero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getPiso() {
		return pisoYNumero;
	}

	public void setPiso(String pisoYNumero) {
		this.pisoYNumero = pisoYNumero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public TIPO_DE_OPERACION getTipo() {
		return tipo;
	}

	public void setTipo(TIPO_DE_OPERACION tipo) {
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", calle=" + calle + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, numero, pisoYNumero, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(numero, other.numero) && Objects.equals(pisoYNumero, other.pisoYNumero)
				&& Objects.equals(precio, other.precio);
	}
	
	

	

}
