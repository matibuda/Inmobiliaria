package ar.edu.unlam.pb1;

import java.util.ArrayList;

public interface Inquilino {
	
	ArrayList<Propiedad> getPropiedadesAlquiladas();
	
	Boolean agregarPropiedadAlInquilino(Propiedad nueva);
	
	Boolean eliminarPropiedadAlInquilino(Propiedad aEliminar);
	

}
