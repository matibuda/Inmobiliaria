package ar.edu.unlam.pb1;

public class Terreno extends Propiedad {
	private Double metrosCuadrados;

	public Terreno(String calle, Integer numero, String ciudad, Double precio, Double metrosCuadrados,
			Boolean estaDisponible, TIPO_DE_OPERACION tipo,Cliente propietario) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario);
		this.metrosCuadrados = metrosCuadrados;
	}

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

}
