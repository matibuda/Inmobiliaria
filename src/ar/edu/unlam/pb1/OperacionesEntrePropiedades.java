package ar.edu.unlam.pb1;

public interface OperacionesEntrePropiedades {
	void venderPropiedad(Cliente vendedor, Propiedad propiedadParaVender, Cliente comprador);
	
	void alquilarPropiedad(Cliente propietario, Propiedad propiedadParaAlquilar, Cliente inquilino);
	
	void permutarDosPropiedades(Cliente propietarioY, Cliente propietarioX, Propiedad propiedadY,
			Propiedad propiedadX);

}
