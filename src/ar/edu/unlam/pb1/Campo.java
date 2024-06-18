package ar.edu.unlam.pb1;

public class Campo extends Propiedad {
	private Double metrosCuadrados;

	public Campo(String calle, Integer numero, String ciudad, Double precio, Double metrosCuadrados,
			Boolean estaDisponible, TIPO_DE_OPERACION tipo) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo);
		this.metrosCuadrados = metrosCuadrados;
	}

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

}
