package ar.edu.unlam.pb1;

import java.util.Comparator;

public class OrdenarPropiedadesPorUbicacion implements Comparator<Propiedad> {

	@Override
	public int compare(Propiedad o1, Propiedad o2) {
		int resultado = o1.getCiudad().compareToIgnoreCase(o2.getCiudad());
		if (resultado != 0) {
			return resultado;
		}

		resultado = o1.getCalle().compareToIgnoreCase(o2.getCalle());
		if (resultado != 0) {
			return resultado;
		}
		return o1.getNumero().compareTo(o2.getNumero());
	}

}
