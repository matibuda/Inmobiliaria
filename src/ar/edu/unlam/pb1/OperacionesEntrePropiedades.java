package ar.edu.unlam.pb1;

public interface OperacionesEntrePropiedades {
	void venderPropiedad(Cliente vendedor, Propiedad propiedadParaVender, Cliente comprador) throws ClienteNoExistenteException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException;
	
	void alquilarPropiedad(Cliente propietario, Propiedad propiedadParaAlquilar, Cliente inquilino) throws ClienteNoExistenteException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException;
	
	void permutarDosPropiedades(Cliente propietarioA, Cliente propietarioB, Propiedad propiedadA,Propiedad propiedadB) throws ClienteNoExistenteException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException;

}
