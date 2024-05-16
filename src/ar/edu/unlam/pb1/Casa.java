package ar.edu.unlam.pb1;

public class Casa extends Propiedad {
	private String codigo;

	public Casa(String calle, int numero, String ciudad, double precio, boolean estaDisponible,
			TIPO_DE_OPERACION tipo) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo);
		this.codigo = "CS" + contador++;
	}

	public String getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Casa Calle=" + getCalle() + ", Numero=" + getNumero() + ", Ciudad=" + getCiudad() + "\n";
	}

	
	
	
}
