package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Alquiler implements Operacion {

	private Cliente propietario;
	private Cliente inquilino;
	private Propiedad enAlquiler;
	private LocalDate fechaInicioDeAlquiler;
	private LocalDate fechaFinalDeAlquiler;

	public Alquiler(Cliente propietario, Propiedad enAlquiler,Cliente inquilino) {
		this.propietario=propietario;
		this.inquilino=inquilino;
		this.enAlquiler=enAlquiler;
		this.fechaInicioDeAlquiler=LocalDate.now();
		fechaFinalDeAlquiler = fechaInicioDeAlquiler.plusMonths(1);
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
				// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el deseo del cliente
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

	public LocalDate getFechaInicioDeAlquiler() {
		return fechaInicioDeAlquiler;
	}
	

	public LocalDate getFechaFinalDeAlquiler() {
		return fechaFinalDeAlquiler;
	}
	
	public void pagarUnMesDeAlquiler() {
		fechaFinalDeAlquiler.plusMonths(1);
	}
	
	public void pagarVariosMesesDeAlquiler(int meses) {
		fechaFinalDeAlquiler.plusMonths(meses);
	}

	@Override
	public String toString() {
		return "Alquiler [propietario=" + propietario + ", inquilino=" + inquilino + ", propiedad=" + enAlquiler
				+ ", fecha=" + fechaInicioDeAlquiler + "]";
	}
	
//	en versiones siguientes se puede llevar la cuenta de cuando un inquilino debe pagar o ser desalojado en caso 
//	de no hacerlo
	

}
