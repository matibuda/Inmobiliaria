package ar.edu.unlam.pb1;

public class Venta implements Operacion {
	private Cliente vendedor;
	private Cliente comprador;
	private Propiedad enVenta;

	public Venta(Cliente vendedor, Propiedad enVenta,Cliente comprador) {
		this.vendedor=vendedor;
		this.comprador=comprador;
		this.enVenta=enVenta;
	}
	
	@Override
	public void ejecutar() throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		
		if(vendedor instanceof Inquilino || comprador instanceof Inquilino ) {
			throw new TipoDeClienteErroneoException("El Cliente NO tiene posesion sobre esta Propiedad");
		}
		
			if (!vendedor.getPropiedades().contains(enVenta)) {
				throw new PropiedadNoPoseidaPorElClienteException("El Cliente NO tiene posesion sobre esta Propiedad");
			}
				if (!enVenta.getEstaDisponible() || !enVenta.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
					throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
				}
					
					vendedor.eliminarPropiedad(enVenta);
					comprador.agregarPropiedad(enVenta);
					enVenta.setEstaDisponible(false);

	}

}
