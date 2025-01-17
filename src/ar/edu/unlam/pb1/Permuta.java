package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Permuta implements Operacion {
	private Cliente propietarioA;
	private Cliente propietarioB;
	private Propiedad propiedadA;
	private Propiedad propiedadB;
	private LocalDate fecha;

	public Permuta(Cliente propietarioA,Cliente propietarioB,Propiedad propiedadA, Propiedad propiedadB) {
		this.propietarioA=propietarioA;
		this.propietarioB=propietarioB;
		this.propiedadA=propiedadA;
		this.propiedadB=propiedadB;
		this.fecha=LocalDate.now();
	}
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		if(propietarioA instanceof Inquilino || propietarioB instanceof Inquilino ) {
			throw new TipoDeClienteErroneoException("El cliente no tiene permitido hacer esta operacion");
		}
		
		if (!propietarioB.getPropiedades().contains(propiedadB) || !propietarioA.getPropiedades().contains(propiedadA)) {
			throw new PropiedadNoPoseidaPorElClienteException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
			if (!propiedadB.getTipo().equals(TIPO_DE_OPERACION.PERMUTA) || !propiedadA.getTipo().equals(TIPO_DE_OPERACION.PERMUTA) || !propiedadB.getEstaDisponible() || !propiedadA.getEstaDisponible()) {
				// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el deseo del cliente
				throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
			}
					propietarioA.eliminarPropiedadAlCliente(propiedadA);
					propietarioB.eliminarPropiedadAlCliente(propiedadB);
					
					propietarioA.agregarPropiedadAlCliente(propiedadB);
					propietarioB.agregarPropiedadAlCliente(propiedadA);
					
					propiedadA.setEstaDisponible(false);
					propiedadB.setEstaDisponible(false);

}
	public Cliente getPropietarioA() {
		return propietarioA;
	}
	public Cliente getPropietarioB() {
		return propietarioB;
	}
	public Propiedad getPropiedadA() {
		return propiedadA;
	}
	public Propiedad getPropiedadB() {
		return propiedadB;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	@Override
	public String toString() {
		return "Permuta [propietarioA=" + propietarioA + ", propietarioB=" + propietarioB + ", propiedadA=" + propiedadA
				+ ", propiedadB=" + propiedadB + ", fecha=" + fecha + "]";
	}
	
	}


