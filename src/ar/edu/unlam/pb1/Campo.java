package ar.edu.unlam.pb1;

public class Campo {
	private static Integer contador = 1;
	private String codigo;
	private String calle;
	private Integer numero;
	private String ciudad;
	private Double precio;
	private Double metrosCuadrados;
	private Boolean estaDisponible;
	private TIPO_DE_OPERACION tipo;

	public Campo(String calle, Integer numero, String ciudad, Double precio, Double metrosCuadrados,
			Boolean estaDisponible, TIPO_DE_OPERACION tipo) {
		this.codigo = "CM" + contador;
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.metrosCuadrados = metrosCuadrados;
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

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
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
		return "Campo [codigo=" + codigo + ", calle=" + calle + ", numero=" + numero + "]";
	}

}