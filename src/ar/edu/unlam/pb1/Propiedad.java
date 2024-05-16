package ar.edu.unlam.pb1;

public class Propiedad {
	protected static Integer contador = 1;
	private String calle;
	private Integer numero;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TIPO_DE_OPERACION tipo;

	public Propiedad(String calle, int numero, String ciudad, double precio, boolean estaDisponible,
			TIPO_DE_OPERACION tipo) {
		this.calle = calle;
		this.numero = numero;
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
		return "Propiedad calle=" + calle + ", numero=" + numero + ", ciudad=" + ciudad + "\n";
	}
	
}
