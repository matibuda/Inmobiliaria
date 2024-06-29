package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;

public class PruebaunitariaAutomatiza {

	@Test
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Propiedad casa1 = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarPropiedad(casa1);

		assertEquals(1, inmoActual.getCasas().size());
	}

	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Propiedad casa1 = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		Propiedad casa2 = new Casa("Chacabuco", 2555, "Ramos Mejia", 50000.0, true, TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarPropiedad(casa1);
		inmoActual.agregarPropiedad(casa2);

		assertEquals(2, inmoActual.getCasas().size());
	}

	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Propiedad depto1 = new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarPropiedad(depto1);

		assertEquals(1, inmoActual.getDepartamentos().size());
	}

	@Test
	public void queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Propiedad depto1 = new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);
		Propiedad depto2 = new Departamento("Alsina", 2555, "Ramos Mejia", "1A", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarPropiedad(depto1);
		inmoActual.agregarPropiedad(depto2);

		assertEquals(2, inmoActual.getDepartamentos().size());
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Propiedad casa1 = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		Propiedad casa2 = new Casa("Chacabuco", 2555, "Ramos Mejia", 50000.0, true, TIPO_DE_OPERACION.VENTA);
		Propiedad casa3 = new Casa("Alsina", 2555, "Ramos Mejia", 30000.0, true, TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarPropiedad(casa1);
		inmoActual.agregarPropiedad(casa2);
		inmoActual.agregarPropiedad(casa3);
		Double promedio = inmoActual.obtenerPromedioDeLasCasas();

		assertEquals(60000.0, promedio, 0.1);
	}

	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() throws UmbralMinimoNoAlcanzadoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Propiedad depto1 = new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);
		Propiedad depto2 = new Departamento("Alsina", 2555, "Ramos Mejia", "1A", 40000.0, true,
				TIPO_DE_OPERACION.VENTA);
		Propiedad depto3 = new Departamento("Rosales", 2555, "Ramos Mejia", "1A", 23004.0, true,
				TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarPropiedad(depto1);
		inmoActual.agregarPropiedad(depto2);
		inmoActual.agregarPropiedad(depto3);
		Double promedio = inmoActual.obtenerPromedioDeLosDepartamentos();

		assertEquals(54334.66666666667, promedio, 0.01);
	}

	@Test
	public void queSePuedaAgregarUnClienteALaInmobiliaria() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente matias = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");

		inmoActual.agregarCliente(matias);
		assertFalse(inmoActual.agregarCliente(matias));
	}

	@Test
	public void queNoSePuedanAgregarDosClientesConUnMismoDni() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente matias = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente juan = new Inquilino(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		
		assertTrue(inmoActual.agregarCliente(matias));
		assertFalse(inmoActual.agregarCliente(juan));
	}

	@Test
	public void queSePuedaRealizarLaVentaDeUnaPropiedad() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente vendedor = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente comprador = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaVender = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);

		inmoActual.agregarCliente(vendedor);
		inmoActual.agregarCliente(comprador);
		inmoActual.agregarPropiedad(propiedadParaVender);

		inmoActual.agregarPropiedadAlCliente(vendedor, propiedadParaVender); // el propietario A de la propiedad
		
		//inmoActual.vender(vendedor, propiedadParaVender, comprador);
		inmoActual.operar(new Venta(vendedor, propiedadParaVender, comprador));
		
		assertFalse(vendedor.getPropiedades().contains(propiedadParaVender)); // el propietario A ya no posee esa propiedad
		assertTrue(comprador.getPropiedades().contains(propiedadParaVender)); // el propietario B si

	}

	@Test
	public void queSePuedaRealizarElAlquilerDeUnaPropiedad() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietario = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente inquilino = new Inquilino(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaAlquilar = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.ALQUILER);

		inmoActual.agregarCliente(propietario);
		inmoActual.agregarCliente(inquilino);
		inmoActual.agregarPropiedad(propiedadParaAlquilar);

		inmoActual.agregarPropiedadAlCliente(propietario, propiedadParaAlquilar);
		
//		inmoActual.alquilar(propietario, propiedadParaAlquilar,inquilino);
		inmoActual.operar(new Alquiler(propietario, propiedadParaAlquilar,inquilino));

		assertTrue(propietario.getPropiedades().contains(propiedadParaAlquilar));
		assertTrue(inquilino.getPropiedades().contains(propiedadParaAlquilar));

	}

	@Test
	public void queSePuedaRealizarLaPermutaDeDosPropiedades() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietarioA = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente propietarioB = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadA = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.PERMUTA);
		Propiedad propiedadB = new Casa("Av Rivadavia", 15000, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.PERMUTA);

		inmoActual.agregarCliente(propietarioA);
		inmoActual.agregarCliente(propietarioB);
		inmoActual.agregarPropiedad(propiedadA);
		inmoActual.agregarPropiedad(propiedadB);

		inmoActual.agregarPropiedadAlCliente(propietarioA, propiedadA);
		inmoActual.agregarPropiedadAlCliente(propietarioB, propiedadB);
		
		//inmoActual.permutar(propietarioA, propietarioB, propiedadA, propiedadB);
		inmoActual.operar(new Permuta(propietarioA, propietarioB, propiedadA, propiedadB));

		assertTrue(propietarioA.getPropiedades().contains(propiedadB));
		assertTrue(propietarioB.getPropiedades().contains(propiedadA));

	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		ArrayList<Propiedad> casasEnRangoDePrecio = new ArrayList<Propiedad>();
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Casa("Av de Mayo", 2555, "Ramos Mejia", 10000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Av Rivadavia", 15000, "Ramos Mejia", 90000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Pueyrredon", 15000, "Ramos Mejia", 50000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Necochea", 15000, "Ramos Mejia", 210000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Necochea", 15000, "Ramos Mejia", 656000.0, true, TIPO_DE_OPERACION.VENTA));
		// agrego algo que no sea una Casa
		inmoActual.agregarPropiedad(new Ph("Sargento Cabral", 15000, "Ramos Mejia", 656000.0, true, TIPO_DE_OPERACION.VENTA));

		casasEnRangoDePrecio = inmoActual.buscarPropiedadesPorRangoDePrecio(10000.0, 90000.0);
		casasEnRangoDePrecio = inmoActual.getCasas(casasEnRangoDePrecio);
		inmoActual.ordenarPropiedadesPorPrecio(casasEnRangoDePrecio);

		assertTrue(casasEnRangoDePrecio.getFirst().getPrecio().equals(10000.0));
		assertTrue(casasEnRangoDePrecio.getLast().getPrecio().equals(90000.0));
		assertEquals(3,casasEnRangoDePrecio.size());
	}

	@Test
	public void queSePuedaRealizarLaBusquedaDeCasasPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		ArrayList<Propiedad> casasFiltradaPorUbicacion = new ArrayList<Propiedad>();
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Casa("Av de Mayo", 2555, "Ramos Mejia", 200000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Av Rivadavia", 2000, "Ramos Mejia", 800000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Pueyrredon", 500, "Ramos Mejia", 500000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Necochea", 1000, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Casa("Necochea", 7000, "Haedo", 1000000.0, true, TIPO_DE_OPERACION.VENTA));

		casasFiltradaPorUbicacion = inmoActual.buscarPropiedadesPorUbicacion("Ramos Mejia");
		inmoActual.ordenarPropiedadesPorUbicacion(casasFiltradaPorUbicacion);
		casasFiltradaPorUbicacion= inmoActual.getCasas(casasFiltradaPorUbicacion);
		
		assertTrue(casasFiltradaPorUbicacion.getFirst().getCalle().equals("Av de Mayo"));
		assertTrue(casasFiltradaPorUbicacion.getLast().getCalle().equals("Pueyrredon"));
		assertEquals(4,casasFiltradaPorUbicacion.size());

		
	}
	
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorRangoDePreciosYElResultadoEsteOrdenadoPorPrecio() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		ArrayList<Propiedad> departamemtosEnRangoDePrecio = new ArrayList<Propiedad>();
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Departamento("Av de Mayo", 2555,"1A", "Ramos Mejia",  10000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Av Rivadavia", 15000, "6F", "Ramos Mejia", 90000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Pueyrredon", 15000, "32","Ramos Mejia",  50000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Necochea", 15000,"4A", "Ramos Mejia",  210000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Necochea", 15000,"01", "Ramos Mejia",  656000.0, true, TIPO_DE_OPERACION.VENTA));
		
		inmoActual.agregarPropiedad(new Ph("Sargento Cabral", 15000, "Ramos Mejia", 11111100.0, true, TIPO_DE_OPERACION.VENTA));

		departamemtosEnRangoDePrecio = inmoActual.buscarPropiedadesPorRangoDePrecio(10000.0, 190000.0);
		inmoActual.ordenarPropiedadesPorPrecio(departamemtosEnRangoDePrecio);
		departamemtosEnRangoDePrecio = inmoActual.getDepartamentos(departamemtosEnRangoDePrecio);

		assertTrue(departamemtosEnRangoDePrecio.getFirst().getPrecio().equals(10000.0));
		assertTrue(departamemtosEnRangoDePrecio.getLast().getPrecio().equals(90000.0));
		assertEquals(3,departamemtosEnRangoDePrecio.size());
		
	}
	@Test
	public void queSePuedaRealizarLaBusquedaDeDepartamentosPorUbicacionYElResultadoEsteOrdenadoPorUbicacion() throws SinResultadosException, UmbralMinimoNoAlcanzadoException {
		ArrayList<Propiedad> departamentosFiltradosPorUbicacion = new ArrayList<Propiedad>();
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Departamento("Av de Mayo", 2555, "1A", "Ramos Mejia", 200000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Av Rivadavia", 15000,"6F", "Ramos Mejia",  800000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Pueyrredon", 15000,"32", "Ramos Mejia",  500000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Necochea", 15000, "4A", "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA));
		inmoActual.agregarPropiedad(new Departamento("Necochea", 15000, "01","Ramos Mejia",  100000.0, true, TIPO_DE_OPERACION.VENTA));
		
		
		inmoActual.agregarPropiedad(new Departamento("Necochea", 7000, "01", "Haedo", 100000.0, true, TIPO_DE_OPERACION.VENTA));

		departamentosFiltradosPorUbicacion = inmoActual.buscarPropiedadesPorUbicacion("Ramos Mejia");
		inmoActual.ordenarPropiedadesPorUbicacion(departamentosFiltradosPorUbicacion);
		departamentosFiltradosPorUbicacion = inmoActual.getDepartamentos(departamentosFiltradosPorUbicacion);
		
		assertTrue(departamentosFiltradosPorUbicacion.getFirst().getCalle().equals("Av de Mayo"));
		assertTrue(departamentosFiltradosPorUbicacion.getLast().getCalle().equals("Pueyrredon"));

		
	}
	
	@Test (expected = SinResultadosException.class) 
	public void queAlBuscarPorUnCriterioQueNoArrojeResultadosSeProduzcaLaExcepcionSinResultadosException() throws SinResultadosException, UmbralMinimoNoAlcanzadoException{
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Casa("Brandsen", 12354, "San Justo", 321321321.0,true,TIPO_DE_OPERACION.VENTA));
		
		inmoActual.buscarPropiedadesPorUbicacion("Ramos Mejia");
		inmoActual.buscarPropiedadesPorRangoDePrecio(10000.0, 90000.0);
		
	}
		
	@Test  (expected =UmbralMinimoNoAlcanzadoException.class )
	public void queAlIntentarGuardarUnaPropiedadParaLaVentaCuyoImporteEstaPorDebajoDelUmbral10000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException() throws UmbralMinimoNoAlcanzadoException{
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Departamento("Av de Mayo", 2555, "1A", "Ramos Mejia", 9000.0, true, TIPO_DE_OPERACION.VENTA));
		
		
	}
	@Test  (expected =UmbralMinimoNoAlcanzadoException.class )
	public void queAlIntentarGuardarUnaPropiedadParaElAlquilerCuyoImporteEstaPorDebajoDelUmbral1000SeArrojeLaExcepcionUmbralMinimoNoAlcanzadoException() throws UmbralMinimoNoAlcanzadoException{
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		inmoActual.agregarPropiedad(new Departamento("Av de Mayo", 2555, "1A", "Ramos Mejia", 900.0, true, TIPO_DE_OPERACION.ALQUILER));
		
		
	}
	
 // TEST DE MAS AGREGADOS POR MI PROBANDO LAS EXCEPCIONES
	
	@Test (expected = TipoDeClienteErroneoException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadSiElTipoDeClienteEsErroneo() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente vendedor = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente comprador = new Inquilino(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaVender = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);
		
		inmoActual.agregarCliente(comprador);
		inmoActual.agregarCliente(vendedor);
		inmoActual.agregarPropiedad(propiedadParaVender);
		

		inmoActual.agregarPropiedadAlCliente(vendedor, propiedadParaVender); 
		
//		inmoActual.vender(vendedor, propiedadParaVender, comprador);
		inmoActual.operar(new Venta(vendedor, propiedadParaVender, comprador));

	}
	
	@Test (expected = PropiedadNoPoseidaPorElClienteException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadSiElClienteNoPoseeLaPropiedad() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente vendedor = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente comprador = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaVender = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);
		
		inmoActual.agregarCliente(comprador);
		inmoActual.agregarCliente(vendedor);
		inmoActual.agregarPropiedad(propiedadParaVender);
		
		//NUNCA AGREGO LA PROPIEDAD AL CLIENTE VENDEDOR
		//inmoActual.agregarPropiedadAlCliente(vendedor, propiedadParaVender); 
		
//		inmoActual.vender(vendedor, propiedadParaVender, comprador);
		inmoActual.operar(new Venta(vendedor, propiedadParaVender, comprador));

	}
	
	@Test (expected = PropiedadNoDisponibleParaLaTransaccionException.class)
	public void queNoSePuedaRealizarLaVentaDeUnaPropiedadSiLaPropiedadNoEstaPuestaParaLaVentaOTengaComoEstadoNoDisponible() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente vendedor = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente comprador = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaVender = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.ALQUILER);
		// PUSE ALQUILER EN TIPO DE OPERACION EN VEZ DE VENTA LO QUE ME DEBERIA DAR LA EXCEPCION PropiedadNoDisponibleParaLaTransaccionException
		
		inmoActual.agregarCliente(comprador);
		inmoActual.agregarCliente(vendedor);
		inmoActual.agregarPropiedad(propiedadParaVender);
		
		inmoActual.agregarPropiedadAlCliente(vendedor, propiedadParaVender);
		
//		inmoActual.vender(vendedor, propiedadParaVender, comprador);
		inmoActual.operar(new Venta(vendedor, propiedadParaVender, comprador));
		

	}	
	
	@Test (expected=PropiedadNoPoseidaPorElClienteException.class)
	public void queNoSePuedaRealizarElAlquilerDeUnaPropiedadSiElPropietarioNoPoseeLaPropiedad() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietario = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente inquilino = new Inquilino(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaAlquilar = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.ALQUILER);

		inmoActual.agregarCliente(propietario);
		inmoActual.agregarCliente(inquilino);
		inmoActual.agregarPropiedad(propiedadParaAlquilar);

		//inmoActual.agregarPropiedadAlCliente(propietario, propiedadParaAlquilar); NUNCA SE AGREGA LA PROPIEDAD AL CLIENTE
		
//		inmoActual.alquilar(propietario, propiedadParaAlquilar, inquilino);
		inmoActual.operar(new Alquiler(propietario, propiedadParaAlquilar, inquilino));

	}
	
	@Test (expected=PropiedadNoDisponibleParaLaTransaccionException.class)
	public void queNoSePuedaRealizarElAlquilerDeUnaPropiedadSiLaPropiedadNoEstaPuestaParaElAlquilerOTengaComoEstadoNoDisponible() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietario = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente inquilino = new Inquilino(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaAlquilar = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);
		//TIPO_DE_OPERACION.VENTA CUANDO DEBERIA SER TIPO_DE_OPERACION.ALQUILER

		inmoActual.agregarCliente(propietario);
		inmoActual.agregarCliente(inquilino);
		inmoActual.agregarPropiedad(propiedadParaAlquilar);

		inmoActual.agregarPropiedadAlCliente(propietario, propiedadParaAlquilar);
		
//		inmoActual.alquilar(propietario, propiedadParaAlquilar, inquilino);
		inmoActual.operar(new Alquiler(propietario, propiedadParaAlquilar, inquilino));

	}
	
	@Test (expected=TipoDeClienteErroneoException.class)
	public void queNoSePuedaRealizarElAlquilerDeUnaPropiedadSiNoHayUnClienteInquilino() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietario = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente inquilino = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadParaAlquilar = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.ALQUILER);
		

		inmoActual.agregarCliente(propietario);
		inmoActual.agregarCliente(inquilino);
		inmoActual.agregarPropiedad(propiedadParaAlquilar);

		inmoActual.agregarPropiedadAlCliente(propietario, propiedadParaAlquilar);
		
//		inmoActual.alquilar(propietario, propiedadParaAlquilar, inquilino);
		inmoActual.operar(new Alquiler(propietario, propiedadParaAlquilar, inquilino));

	}
	
	@Test (expected = TipoDeClienteErroneoException.class)
	public void queNoSePuedaRealizarLaPermutaDeUnaPropiedadSiElTipoDeClienteEsErroneo() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietarioA = new Inquilino(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente propietarioB = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadA = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.PERMUTA);
		Propiedad propiedadB = new Casa("Av Rivadavia", 15000, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.PERMUTA);

		inmoActual.agregarCliente(propietarioA);
		inmoActual.agregarCliente(propietarioB);
		inmoActual.agregarPropiedad(propiedadA);
		inmoActual.agregarPropiedad(propiedadB);

		inmoActual.agregarPropiedadAlCliente(propietarioA, propiedadA);
		inmoActual.agregarPropiedadAlCliente(propietarioB, propiedadB);
		
//		inmoActual.permutar(propietarioA, propietarioB, propiedadA, propiedadB);
		inmoActual.operar(new Permuta(propietarioA, propietarioB, propiedadA, propiedadB));

	}
	
	@Test (expected =PropiedadNoPoseidaPorElClienteException.class)
	public void queNoSePuedaRealizarLaPermutaDeDosPropiedadesSiElClienteNoPoseeLaPropiedad() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietarioA = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente propietarioB = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadA = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.PERMUTA);
		Propiedad propiedadB = new Casa("Av Rivadavia", 15000, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.PERMUTA);

		inmoActual.agregarCliente(propietarioA);
		inmoActual.agregarCliente(propietarioB);
		inmoActual.agregarPropiedad(propiedadA);
		inmoActual.agregarPropiedad(propiedadB);

		//inmoActual.agregarPropiedadAlCliente(propietarioA, propiedadA); CLIENTE A NO POSEE LA PROPIEDAD PARA PERMUTAR
		inmoActual.agregarPropiedadAlCliente(propietarioB, propiedadB);
		
//		inmoActual.permutar(propietarioA, propietarioB, propiedadA, propiedadB);
		inmoActual.operar(new Permuta(propietarioA, propietarioB, propiedadA, propiedadB));

	}
	
	@Test (expected =PropiedadNoDisponibleParaLaTransaccionException.class)
	public void queNoSePuedaRealizarLaPermutaDeDosPropiedadesSiLaPropiedadNoEstaPuestaParaLaPermutaOTengaComoEstadoNoDisponible() throws UmbralMinimoNoAlcanzadoException, PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Cliente propietarioA = new Propietario(41709637, "Matias", "Buda", 1124536582, "clienteBuda@gmail.com");
		Cliente propietarioB = new Propietario(25145687, "Juan", "Monteagudo", 1124536582, "clienteMonteagudo@gmail.com");
		Propiedad propiedadA = new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.PERMUTA);
		Propiedad propiedadB = new Casa("Av Rivadavia", 15000, "Ramos Mejia", 100000.0, true,
				TIPO_DE_OPERACION.VENTA);
		//TIPO_DE_OPERACION.VENTA CUANDO DEBERIA SER TIPO_DE_OPERACION.PERMUTA

		inmoActual.agregarCliente(propietarioA);
		inmoActual.agregarCliente(propietarioB);
		inmoActual.agregarPropiedad(propiedadA);
		inmoActual.agregarPropiedad(propiedadB);

		inmoActual.agregarPropiedadAlCliente(propietarioA, propiedadA);
		inmoActual.agregarPropiedadAlCliente(propietarioB, propiedadB);
		
//		inmoActual.permutar(propietarioA, propietarioB, propiedadA, propiedadB);
		inmoActual.operar(new Permuta(propietarioA, propietarioB, propiedadA, propiedadB));

	}

}