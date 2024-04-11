package ar.edu.unlam.pb1;

import java.util.Objects;

public class Casa {
	private static Integer contador = 1;
	private String codigo;
	private String calle;
	private Integer numero;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TIPO_DE_OPERACION tipo;

	public Casa(String calle, int numero, String ciudad, double precio, boolean estaDisponible,
			TIPO_DE_OPERACION tipo) {
		this.codigo = "CS" + contador++;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public TIPO_DE_OPERACION getTipo() {
		return tipo;
	}

	public void setTipo(TIPO_DE_OPERACION tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Casa [Codigo=" + codigo + ", calle=" + calle + ", numero=" + numero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(calle, ciudad, numero, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casa other = (Casa) obj;
		return Objects.equals(calle, other.calle) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(numero, other.numero) && Objects.equals(precio, other.precio);
	}

	
	
	

}
