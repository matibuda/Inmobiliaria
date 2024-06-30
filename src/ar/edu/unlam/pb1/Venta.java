package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Venta implements Operacion {
	private Cliente propietarioAnterior;
	private Cliente propietarioNuevo;
	private Propiedad propiedadAVender;
	private LocalDate fecha;

	public Venta(Propiedad propiedadAVender,Cliente comprador) {
		this.propietarioAnterior=propiedadAVender.getPropietario();
		this.propietarioNuevo=comprador;
		this.propiedadAVender=propiedadAVender;
		this.fecha=LocalDate.now();
	}
	
	@Override
	public void ejecutar() throws PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		
		if(propietarioNuevo instanceof Inquilino) {
			throw new TipoDeClienteErroneoException("El cliente no tiene permitido hacer esta operacion");
		}
				if (!propiedadAVender.getEstaDisponible() || !propiedadAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
					// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el deseo del cliente
					throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
				}
					
					propiedadAVender.setPropietario(propietarioNuevo);
					propiedadAVender.setEstaDisponible(false);

	}

	public Cliente getPropietarioAnterior() {
		return propietarioAnterior;
	}

	public Cliente getPropietarioNuevo() {
		return propietarioNuevo;
	}

	public Propiedad getPropiedad() {
		return propiedadAVender;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Venta [vendedor=" + propietarioAnterior + ", comprador=" + propietarioNuevo + ", propiedad=" + propiedadAVender + ", fecha=" + fecha
				+ "]";
	}
	
	

}
