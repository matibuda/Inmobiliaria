package ar.edu.unlam.pb1;

import static org.junit.Assert.*;

import org.junit.Test;
//@Test(priority = 1) PARA PONERLE PRIORIDAD A UN TEST... PERO NO ES MUY SEGURO DE USAR
public class PruebaunitariaAutomatiza {

	@Test 
	public void queSePuedaDarDeAltaUnaCasaEnLaInmobiliaria() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Casa casa1 =new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addCasa(casa1);
		Casa buscada = inmoActual.buscarCasa("CS9");
		
		assertNotNull(inmoActual.getCasas());
		assertEquals(casa1, buscada);
	}
	
	@Test
	public void queSePuedanDarDeAltaDosCasasEnLaInmobiliaria() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Casa casa1 =new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa2 =new Casa("Chacabuco", 2555, "Ramos Mejia", 50000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addCasa(casa1);
		inmoActual.addCasa(casa2);
		Casa buscada1 = inmoActual.buscarCasa("CS1");
		Casa buscada2 = inmoActual.buscarCasa("CS2");
		
		assertNotNull(inmoActual.getCasas());
		assertEquals(casa1, buscada1);
		assertEquals(casa2, buscada2);
	}
	
	@Test
	public void queNoSePuedanDarDeAltaDosCasasConUnaMismaDireccion() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Casa casa1 =new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addCasa(casa1);
		
		assertFalse(inmoActual.addCasa(casa1));
		
		
	}
	
	@Test
	public void queSePuedaDarDeAltaUnDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Departamento depto1 =new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addDepto(depto1);
		Departamento buscado = inmoActual.buscarDepartamento("DE8");
		
		assertNotNull(inmoActual.getDepartamentos());
		assertEquals(depto1, buscado);
	}
	
	@Test
	public void queSePuedanDarDeAltaDosDepartamentoEnLaInmobiliaria() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Departamento depto1 =new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto2 =new Departamento("Alsina", 2555, "Ramos Mejia", "1A", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addDepto(depto1);
		inmoActual.addDepto(depto2);
		Departamento buscado1 = inmoActual.buscarDepartamento("DE9");
		Departamento buscado2 = inmoActual.buscarDepartamento("DE10");
		
		assertNotNull(inmoActual.getDepartamentos());
		assertEquals(depto1, buscado1);
		assertEquals(depto2, buscado2);
	}
	
	@Test
	public void queNoSePuedanDarDeAltaDosDepartamentoConUnaMismaDireccion() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Departamento depto1 =new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addDepto(depto1);
		assertFalse(inmoActual.addDepto(depto1));
	}
	
	@Test
	public void queSePuedaObtenerElValorPromedioDeLasCasas() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Casa casa1 =new Casa("Av de Mayo", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa2 =new Casa("Chacabuco", 2555, "Ramos Mejia", 50000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa3 =new Casa("Alsina", 2555, "Ramos Mejia", 30000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addCasa(casa1);
		inmoActual.addCasa(casa2);
		inmoActual.addCasa(casa3);
		Double promedio = inmoActual.obtenerPromedioDeLasCasas();
		
		assertEquals(60000.0, promedio,0.1);
	}
	
	@Test
	public void queSePuedaObtenerElValorPromedioDeLosDepartamentos() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Departamento depto1 =new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto2 =new Departamento("Alsina", 2555, "Ramos Mejia", "1A", 40000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto3 =new Departamento("Rosales", 2555, "Ramos Mejia", "1A", 23004.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addDepto(depto1);
		inmoActual.addDepto(depto2);
		inmoActual.addDepto(depto3);
		Double promedio = inmoActual.obtenerPromedioDeLosDepartamentos();
		
		assertEquals(54334.66666666667, promedio,0.01);
		assertNotEquals(54334.66666666667, promedio,0.00000000000000001);
	}
	
	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNoNuloSiAplicanResultados() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Departamento depto1 =new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 10000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto2 =new Departamento("Alsina", 2555, "Ramos Mejia", "1A", 50000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto3 =new Departamento("Rosales", 2555, "Ramos Mejia", "1A", 30000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa1 =new Casa("Av de Mayo", 2555, "Ramos Mejia", 70000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa2 =new Casa("Chacabuco", 2555, "Ramos Mejia", 90000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa3 =new Casa("Alsina", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addDepto(depto1);
		inmoActual.addDepto(depto2);
		inmoActual.addDepto(depto3);
		inmoActual.addCasa(casa1);
		inmoActual.addCasa(casa2);
		inmoActual.addCasa(casa3);
		Double rangoDePrecio1 = 10000.0;
		Double rangoDePrecio2 = 70000.0;
		
		assertNotNull(inmoActual.buscarCasasPorRangoDePrecio(rangoDePrecio1, rangoDePrecio2));
		
		
	}
	
	@Test
	public void queLaBusquedaPorRangoDePrecioDeCasasMeArrojeUnArrayNuloSiNoAplicanResultados() {
		Inmobiliaria inmoActual = new Inmobiliaria("Buda's", "Av Rivadavia", "inmobuda@gmail.com", 1124536582);
		Departamento depto1 =new Departamento("Av de Mayo", 2555, "Ramos Mejia", "1A", 10000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto2 =new Departamento("Alsina", 2555, "Ramos Mejia", "1A", 50000.0, true, TIPO_DE_OPERACION.VENTA);
		Departamento depto3 =new Departamento("Rosales", 2555, "Ramos Mejia", "1A", 30000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa1 =new Casa("Av de Mayo", 2555, "Ramos Mejia", 70000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa2 =new Casa("Chacabuco", 2555, "Ramos Mejia", 90000.0, true, TIPO_DE_OPERACION.VENTA);
		Casa casa3 =new Casa("Alsina", 2555, "Ramos Mejia", 100000.0, true, TIPO_DE_OPERACION.VENTA);
		
		inmoActual.addDepto(depto1);
		inmoActual.addDepto(depto2);
		inmoActual.addDepto(depto3);
		inmoActual.addCasa(casa1);
		inmoActual.addCasa(casa2);
		inmoActual.addCasa(casa3);
		Double rangoDePrecio1 = 0.0;
		Double rangoDePrecio2 = 0.0;
		
		assertNull(inmoActual.buscarCasasPorRangoDePrecio(rangoDePrecio1, rangoDePrecio2));
		
		
	}

}
//assert

//DUDAS: CADA VEZ QUE AGREGO UN TEST NUEVO CON CASAS / DEPARTAMENTOS NUEVOS LE TENGO QUE CAMBIAR EL CODIGO A LOS PRIMEROS TEST QUE HICE... ESTA MAL LA MANERA DE SERCIORARME 