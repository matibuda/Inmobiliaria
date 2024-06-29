package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Alquiler implements Operacion {

	private Cliente propietario;
	private Cliente inquilino;
	private Propiedad enAlquiler;
	private LocalDate fecha;

	public Alquiler(Cliente propietario, Propiedad enAlquiler,Cliente inquilino) {
		this.propietario=propietario;
		this.inquilino=inquilino;
		this.enAlquiler=enAlquiler;
		this.fecha=LocalDate.now();
	}
	
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		if(inquilino instanceof Propietario || propietario instanceof Inquilino) {
			throw new TipoDeClienteErroneoException("El cliente no tiene permitido hacer esta operacion");
		}
		if (!propietario.getPropiedades().contains(enAlquiler)) {
			throw new PropiedadNoPoseidaPorElClienteException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
			if (!enAlquiler.getEstaDisponible() || !enAlquiler.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el atributo previamente cargado
				throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
			}
				inquilino.agregarPropiedadAlCliente(enAlquiler);
				enAlquiler.setEstaDisponible(false);

	}

	public Cliente getPropietario() {
		return propietario;
	}

	public Cliente getInquilino() {
		return inquilino;
	}

	public Propiedad getPropiedad() {
		return enAlquiler;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Alquiler [propietario=" + propietario + ", inquilino=" + inquilino + ", propiedad=" + enAlquiler
				+ ", fecha=" + fecha + "]";
	}
	
	

}
