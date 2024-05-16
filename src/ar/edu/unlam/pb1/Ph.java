package ar.edu.unlam.pb1;

public class Ph extends Propiedad {
	private String codigo;

	public Ph(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TIPO_DE_OPERACION tipo) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo);
		this.codigo = "PH" + contador;
	}

	public String getCodigo() {
		return codigo;
	}

}
