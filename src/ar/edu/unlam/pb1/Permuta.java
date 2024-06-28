package ar.edu.unlam.pb1;

public class Permuta implements Operacion {
	private Cliente propietarioA;
	private Cliente propietarioB;
	private Propiedad propiedadA;
	private Propiedad propiedadB;

	public Permuta(Cliente propietarioA,Cliente propietarioB,Propiedad propiedadA, Propiedad propiedadB) {
		this.propietarioA=propietarioA;
		this.propietarioB=propietarioB;
		this.propiedadA=propiedadA;
		this.propiedadB=propiedadB;
	}
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		if(propietarioA instanceof Inquilino || propietarioB instanceof Inquilino ) {
			throw new TipoDeClienteErroneoException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
		
		if (!propietarioB.getPropiedades().contains(propiedadB) || !propietarioA.getPropiedades().contains(propiedadA)) {
			throw new PropiedadNoPoseidaPorElClienteException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
			if (!propiedadB.getTipo().equals(TIPO_DE_OPERACION.PERMUTA) || !propiedadA.getTipo().equals(TIPO_DE_OPERACION.PERMUTA) || !propiedadB.getEstaDisponible() || !propiedadA.getEstaDisponible()) {
				throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
			}
					propietarioA.eliminarPropiedad(propiedadA);
					propietarioB.eliminarPropiedad(propiedadB);
					
					propietarioA.agregarPropiedad(propiedadB);
					propietarioB.agregarPropiedad(propiedadA);
					
					propiedadA.setEstaDisponible(false);
					propiedadB.setEstaDisponible(false);

}

	}


