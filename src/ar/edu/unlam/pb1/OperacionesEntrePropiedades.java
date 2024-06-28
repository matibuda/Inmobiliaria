package ar.edu.unlam.pb1;

public interface OperacionesEntrePropiedades {
	void venderPropiedad(Cliente vendedor, Propiedad propiedadParaVender, Cliente comprador) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException;
	
	void alquilarPropiedad(Cliente propietario, Propiedad propiedadParaAlquilar, Cliente inquilino) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException;
	
	void permutarDosPropiedades(Cliente propietarioA, Cliente propietarioB, Propiedad propiedadA,Propiedad propiedadB) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException;

}
