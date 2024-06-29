package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Venta implements Operacion {
	private Cliente vendedor;
	private Cliente comprador;
	private Propiedad enVenta;
	private LocalDate fecha;

	public Venta(Cliente vendedor, Propiedad enVenta,Cliente comprador) {
		this.vendedor=vendedor;
		this.comprador=comprador;
		this.enVenta=enVenta;
		this.fecha=LocalDate.now();
	}
	
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		
		if(vendedor instanceof Inquilino || comprador instanceof Inquilino ) {
			throw new TipoDeClienteErroneoException("El cliente no tiene permitido hacer esta operacion");
		}
		
			if (!vendedor.getPropiedades().contains(enVenta)) {
				throw new PropiedadNoPoseidaPorElClienteException("El Cliente NO tiene posesion sobre esta Propiedad");
			}
				if (!enVenta.getEstaDisponible() || !enVenta.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
					// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el deseo del cliente
					throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
				}
					
					vendedor.eliminarPropiedadAlCliente(enVenta);
					comprador.agregarPropiedadAlCliente(enVenta);
					enVenta.setEstaDisponible(false);

	}

	public Cliente getVendedor() {
		return vendedor;
	}

	public Cliente getComprador() {
		return comprador;
	}

	public Propiedad getPropiedad() {
		return enVenta;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Venta [vendedor=" + vendedor + ", comprador=" + comprador + ", propiedad=" + enVenta + ", fecha=" + fecha
				+ "]";
	}
	
	

}
