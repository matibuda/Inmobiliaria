package ar.edu.unlam.pb1;

public class Departamento extends Propiedad {
	private String codigo;
	private String pisoYNumero;

	public Departamento(String calle, Integer numero, String pisoYNumero, String ciudad, Double precio,
			Boolean estaDisponible, TIPO_DE_OPERACION tipo) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo);
		this.codigo = "DE" + contador++;
		this.pisoYNumero = pisoYNumero;

	}

	public String getPiso() {
		return pisoYNumero;
	}

	public void setPiso(String pisoYNumero) {
		this.pisoYNumero = pisoYNumero;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Departamento Calle=" + getCalle() + ", Numero="
				+ getNumero() + ", Piso & Numero=" + pisoYNumero + ", Ciudad=" + getCiudad() + "\n";
	}
	
	

}
