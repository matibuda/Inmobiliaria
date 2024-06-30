package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Alquiler implements Operacion {

	private Cliente propietario;
	private Cliente inquilino;
	private Propiedad propiedadEnAlquiler;
	private LocalDate fechaDeInicioDelAlquiler;
	private LocalDate fechaDeFinalizacionDelAlquiler;

	public Alquiler(Propiedad propiedadEnAlquiler,Cliente inquilino) {
		this.propietario=propiedadEnAlquiler.getPropietario();
		this.inquilino=inquilino;
		this.propiedadEnAlquiler=propiedadEnAlquiler;
		this.fechaDeInicioDelAlquiler=LocalDate.now();
		this.fechaDeFinalizacionDelAlquiler=fechaDeInicioDelAlquiler.plusMonths(1);
	}
	
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		if(inquilino instanceof Propietario){
			throw new TipoDeClienteErroneoException("El cliente no tiene permitido hacer esta operacion");
		}
			if (!propiedadEnAlquiler.getEstaDisponible() || !propiedadEnAlquiler.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el deseo del cliente
				throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
			}
				propiedadEnAlquiler.setEstaDisponible(false);

	}
	
	// setear el tiempo de alquiler y todo aca y como se guarda en cliente lo voy a poder ver en el futuro

	public Cliente getPropietario() {
		return propietario;
	}

	public Cliente getInquilino() {
		return inquilino;
	}

	public Propiedad getPropiedad() {
		return propiedadEnAlquiler;
	}

	public LocalDate getFechaDeInicioDelAlquiler() {
		return fechaDeInicioDelAlquiler;
	}
	
	public LocalDate getFechaDeFinalizacionDelAlquiler() {
		return fechaDeFinalizacionDelAlquiler;
	}
	
	public void pagarUnMesDeAlquiler() {
		fechaDeFinalizacionDelAlquiler.plusMonths(1);
	}

	@Override
	public String toString() {
		return "Alquiler [propietario=" + propietario + ", inquilino=" + inquilino + ", propiedad=" + propiedadEnAlquiler
				+ ", fechaDeInicioDelAlquiler=" + fechaDeInicioDelAlquiler + "]";
	}
	
	

}
