package ar.edu.unlam.pb1;

public class Casa extends Propiedad {

	public Casa(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TIPO_DE_OPERACION tipo,Cliente propietario) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario);;
	}

	@Override
	public String toString() {
		return "Casa Calle=" + getCalle() + ", Numero=" + getNumero() + ", Ciudad=" + getCiudad() + " ,Precio: "+ getPrecio()+"\n";
	}

	
	
	
}
