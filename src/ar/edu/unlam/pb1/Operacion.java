package ar.edu.unlam.pb1;

public interface Operacion {
	void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException;

}
