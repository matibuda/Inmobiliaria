package ar.edu.unlam.pb1;

public class Alquiler implements Operacion {

	private Cliente propietario;
	private Cliente inquilino;
	private Propiedad enAlquiler;

	public Alquiler(Cliente propietario, Propiedad enAlquiler,Cliente inquilino) {
		this.propietario=propietario;
		this.inquilino=inquilino;
		this.enAlquiler=enAlquiler;
	}
	
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		if(inquilino instanceof Propietario) {
			throw new TipoDeClienteErroneoException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
		if (!propietario.getPropiedades().contains(enAlquiler)) {
			throw new PropiedadNoPoseidaPorElClienteException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
			if (!enAlquiler.getEstaDisponible() || !enAlquiler.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
			}
				inquilino.agregarPropiedad(enAlquiler);
				enAlquiler.setEstaDisponible(false);

	}

}
