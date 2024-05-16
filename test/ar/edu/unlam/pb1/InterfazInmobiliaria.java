package ar.edu.unlam.pb1;

import java.util.Scanner;

public class InterfazInmobiliaria {

	public static void main(String[] args) {
		Integer opcionSeleccionada = 0;
		Inmobiliaria actual = new Inmobiliaria();
		Scanner teclado = new Scanner(System.in);
		Integer tipoDePropiedad;

		do {
			menu();
			opcionSeleccionada = teclado.nextInt();

			switch (OPCION_DE_MENU.values()[opcionSeleccionada - 1]) {
			case AGREGAR_PROPIEDAD:
				System.out.println("Que propiedad desea agregar?");
				tipoDePropiedad = seleccionadorDePropiedades(teclado);
				switch (TIPO_DE_PROPIEDADES.values()[tipoDePropiedad - 1]) {
				case CAMPO:
					agregarCampo(actual, teclado);
					break;
				case CASA:
					agregarCasa(actual, teclado);
					break;
				case DEPARTAMENTO:
					agregarDepto(actual, teclado);
					break;
				case PH:
					agregarPh(actual, teclado);
					break;
				case TERRENO:
					agregarTerreno(actual, teclado);
					break;

				}
			case MODIFICAR_PROPIEDAD:
				System.out.println(actual.mostrarPropiedades());
				System.out.println("ingrese el tipo de propiedad que desea modificar");
				Integer opcionAModificar = seleccionadorDePropiedades(teclado);
				String codigo = "";
				switch (TIPO_DE_PROPIEDADES.values()[opcionAModificar - 1]) {
				case CAMPO:
					System.out.println("ingrese el codigo del campo que desea modificar");
					codigo = teclado.next();
					Campo campoBuscado = actual.buscarCampo(codigo);
					modificarCampo(teclado, campoBuscado);
					break;
				case CASA:
					System.out.println("ingrese el codigo de la casa que desea modificar");
					codigo = teclado.next();
					Casa casaBuscada = actual.buscarCasa(codigo);
					modificarCasa(teclado, casaBuscada);
					break;
				case DEPARTAMENTO:
					System.out.println("ingrese el codigo del departamento que desea modificar");
					codigo = teclado.next();
					Departamento deptoBuscado = actual.buscarDepartamento(codigo);
					modificarDepto(teclado, deptoBuscado);
					break;
				case PH:
					System.out.println("ingrese el codigo del ph que desea modificar");
					codigo = teclado.next();
					Ph terrenoBuscado = actual.buscarPh(codigo);
					modificarPh(teclado, terrenoBuscado);
					break;
				case TERRENO:
					System.out.println("ingrese el codigo del terreno que desea modificar");
					codigo = teclado.next();
					modificarTerreno(actual, teclado, codigo);
					break;
				}

			case AGREGAR_CLIENTE:
				agregarCliente(actual, teclado);
				break;
			case OBTENER_LISTADO_POR_PRECIO:
				actual.ordenarCamposPorPrecio();
				actual.ordenarCasasPorPrecio();
				actual.ordenarDepartamentosPorPrecio();
				actual.ordenarPhsPorPrecio();
				actual.ordenarTerrenosPorPrecio();
				System.out.println(actual.mostrarPropiedades()); 
			case OBTENER_LISTADO_POR_UBICACION:
				actual.ordenarCamposPorCiudad();
				actual.ordenarCasasPorCiudad();
				actual.ordenarDepartamentosPorCiudad();
				actual.ordenarPhsPorCiudad();
				actual.ordenarTerrenosPorCiudad();
				System.out.println(actual.mostrarPropiedades());
				break;
			case BUSCAR_PROPIEDADES_POR_PRECIO:
				System.out.println("Ingrese el rango de precios para las propiedades (primero el menor y luego el mayor)");
				Double rango1 = teclado.nextDouble();
				Double rango2 = teclado.nextDouble();
				System.out.println(actual.mostrarPropiedadesPorPrecio(rango1, rango2));
			case BUSCAR_PROPIEDADES_POR_UBICACION:
				System.out.println("Ingrese la ciudad en que quiera buscar propiedades");
				String ciudad = teclado.next();
				System.out.println(actual.mostrarPropiedadesPorCiudad(ciudad));
			case REALIZAR_VENTA:
				System.out.println("Ingrese el dni del cliente que quiere comprar la propiedad");
				Integer dni = teclado.nextInt();
				System.out.println(actual.mostrarPropiedades());
				System.out.println("Ingrese el tipo de propiedad que se va a vender");
				Integer propiedad = seleccionadorDePropiedades(teclado);
				System.out.println("Ingrese el codigo de la propiedad que se va a vender");
				String codigoDePropiedad = teclado.next();
				actual.venderPropiedad(dni,codigoDePropiedad,TIPO_DE_PROPIEDADES.values()[propiedad -1]);
				
			case REALIZAR_ALQUILER:
				System.out.println("Ingrese el dni del cliente que quiere alquilar la propiedad");
				dni = teclado.nextInt();
				System.out.println(actual.mostrarPropiedades());
				System.out.println("Ingrese el tipo de propiedad que se va a alquilar");
				propiedad = seleccionadorDePropiedades(teclado);
				System.out.println("Ingrese el codigo de la propiedad que se va a alquilar");
				codigoDePropiedad = teclado.next();
				actual.alquilarPropiedad(dni,codigoDePropiedad,TIPO_DE_PROPIEDADES.values()[propiedad -1]);
			}

		} while (opcionSeleccionada != 0);

		Casa nueva = new Casa("Norteamerica", 549, "Villa Sarmiento", 100.0, true, TIPO_DE_OPERACION.VENTA);
		nueva.setCalle("America del sur");

	}

	private static void agregarCliente(Inmobiliaria actual, Scanner teclado) {
		System.out.println("A continuacion ingrese los datos del cliente");
		System.out.println("Dni");
		Integer dni = teclado.nextInt();
		System.out.println("Nombre");
		String nombre = teclado.next();
		System.out.println("Apellido");
		String apellido = teclado.next();
		System.out.println("Telefono");
		Integer telefono = teclado.nextInt();
		System.out.println("Mail");
		String mail = teclado.next();

		Cliente nuevo = new Cliente(dni, nombre, apellido, telefono, mail);

		if (actual.addCliente(nuevo)) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("Hubo un error o tal vez ya existe ese cliente");
		}
	}

	private static void modificarCampo(Scanner teclado, Campo campoBuscado) {
		Integer opcionAModificar;
		do {
			System.out.println("Ingrese la opcion que desea modificar");
			System.out.println("1. calle");
			System.out.println("2. numero");
			System.out.println("3. ciudad");
			System.out.println("4. precio");
			System.out.println("5. metros cuadrados");
			System.out.println("6. disponibilidad");
			System.out.println("7. operacion");
			System.out.println("9. salir");
			opcionAModificar = teclado.nextInt();
			switch (opcionAModificar) {
			case 1:
				System.out.println("ingrese la nueva calle");
				campoBuscado.setCalle(teclado.next());
				break;
			case 2:
				System.out.println("ingrese el nuevo numero");
				campoBuscado.setNumero(teclado.nextInt());
				break;
			case 3:
				System.out.println("ingrese la nueva ciudad");
				campoBuscado.setCiudad(teclado.next());
				break;
			case 4:
				System.out.println("ingrese el nuevo precio");
				campoBuscado.setPrecio(teclado.nextDouble());
				break;
			case 5:
				System.out.println("ingrese los nuevos metros cuadrados");
				campoBuscado.setMetrosCuadrados(teclado.nextDouble());
				break;
			case 6:
				System.out.println("ingrese la nueva disponibilidad");
				campoBuscado.setEstaDisponible(teclado.nextBoolean());
				break;
			case 7:
				System.out.println("ingrese el nuevo tipo de operacion");
				campoBuscado.setTipo(TIPO_DE_OPERACION.values()[teclado.nextInt()]);
				break;
			}

		} while (opcionAModificar != 9);
	}

	private static void modificarPh(Scanner teclado, Ph terrenoBuscado) {
		Integer opcionAModificar;
		do {
			System.out.println("Ingrese la opcion que desea modificar");
			System.out.println("1. calle");
			System.out.println("2. numero");
			System.out.println("3. ciudad");
			System.out.println("4. precio");
			System.out.println("5. disponibilidad");
			System.out.println("6. operacion");
			System.out.println("9. salir");
			opcionAModificar = teclado.nextInt();
			switch (opcionAModificar) {
			case 1:
				System.out.println("ingrese la nueva calle");
				terrenoBuscado.setCalle(teclado.next());
				break;
			case 2:
				System.out.println("ingrese el nuevo numero");
				terrenoBuscado.setNumero(teclado.nextInt());
				break;
			case 3:
				System.out.println("ingrese la nueva ciudad");
				terrenoBuscado.setCiudad(teclado.next());
				break;
			case 4:
				System.out.println("ingrese el nuevo precio");
				terrenoBuscado.setPrecio(teclado.nextDouble());
				break;
			case 5:
				System.out.println("ingrese la nueva disponibilidad");
				terrenoBuscado.setEstaDisponible(teclado.nextBoolean());
				break;
			case 6:
				System.out.println("ingrese el nuevo tipo de operacion");
				terrenoBuscado.setTipo(TIPO_DE_OPERACION.values()[teclado.nextInt()]);
				break;
			}

		} while (opcionAModificar != 9);
	}

	private static void modificarTerreno(Inmobiliaria actual, Scanner teclado, String codigo) {
		Integer opcionAModificar;
		Terreno terrenoBuscado = actual.buscarTerreno(codigo);
		do {
			System.out.println("Ingrese la opcion que desea modificar");
			System.out.println("1. calle");
			System.out.println("2. numero");
			System.out.println("3. ciudad");
			System.out.println("4. precio");
			System.out.println("5. metros cuadrados");
			System.out.println("6. disponibilidad");
			System.out.println("7. operacion");
			System.out.println("9. salir");
			opcionAModificar = teclado.nextInt();
			switch (opcionAModificar) {
			case 1:
				System.out.println("ingrese la nueva calle");
				terrenoBuscado.setCalle(teclado.next());
				break;
			case 2:
				System.out.println("ingrese el nuevo numero");
				terrenoBuscado.setNumero(teclado.nextInt());
				break;
			case 3:
				System.out.println("ingrese la nueva ciudad");
				terrenoBuscado.setCiudad(teclado.next());
				break;
			case 4:
				System.out.println("ingrese el nuevo precio");
				terrenoBuscado.setPrecio(teclado.nextDouble());
				break;
			case 5:
				System.out.println("ingrese los nuevos metros cuadrados");
				terrenoBuscado.setMetrosCuadrados(teclado.nextDouble());
				break;
			case 6:
				System.out.println("ingrese la nueva disponibilidad");
				terrenoBuscado.setEstaDisponible(teclado.nextBoolean());
				break;
			case 7:
				System.out.println("ingrese el nuevo tipo de operacion");
				terrenoBuscado.setTipo(TIPO_DE_OPERACION.values()[teclado.nextInt()]);
				break;
			}

		} while (opcionAModificar != 9);
	}

	private static void agregarCampo(Inmobiliaria actual, Scanner teclado) {
		String calle;
		Integer numero;
		String ciudad;
		Double precio;
		Double m2;
		Boolean estaDisponible;
		TIPO_DE_OPERACION tipo;
		System.out.println("ingrese la calle");
		calle = teclado.next();
		System.out.println("ingrese el numero");
		numero = teclado.nextInt();
		System.out.println("ingrese la ciudad");
		ciudad = teclado.next();
		System.out.println("ingrese el precio");
		precio = teclado.nextDouble();
		System.out.println("ingrese la cantidad de metros cuadrados");
		m2=teclado.nextDouble();
		System.out.println("ingrese la disponibilidad");
		estaDisponible = teclado.nextBoolean();
		System.out.println("ingrese el tipo de operacion");
		System.out.println("1. Venta");
		System.out.println("2. Alquiler");
		System.out.println("3. Permuta");
		tipo = TIPO_DE_OPERACION.values()[teclado.nextInt() - 1];
		Campo nuevoCampo = new Campo(calle, numero, ciudad, precio, m2, estaDisponible, tipo);
		if (actual.addCampo(nuevoCampo)) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("no se pudo agregar");
		}
	}

	private static void agregarPh(Inmobiliaria actual, Scanner teclado) {
		String calle;
		Integer numero;
		String ciudad;
		Double precio;
		Boolean estaDisponible;
		TIPO_DE_OPERACION tipo;
		System.out.println("ingrese la calle");
		calle = teclado.next();
		System.out.println("ingrese el numero");
		numero = teclado.nextInt();
		System.out.println("ingrese la ciudad");
		ciudad = teclado.next();
		System.out.println("ingrese el precio");
		precio = teclado.nextDouble();
		System.out.println("ingrese la disponibilidad");
		estaDisponible = teclado.nextBoolean();
		System.out.println("ingrese el tipo de operacion");
		System.out.println("1. Venta");
		System.out.println("2. Alquiler");
		System.out.println("3. Permuta");
		tipo = TIPO_DE_OPERACION.values()[teclado.nextInt() - 1];
		Ph nuevoPh = new Ph(calle, numero, ciudad, precio, estaDisponible, tipo);
		if (actual.addPh(nuevoPh)) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("no se pudo agregar");
		}
	}

	private static void agregarTerreno(Inmobiliaria actual, Scanner teclado) {
		String calle;
		Integer numero;
		String ciudad;
		Double precio;
		Double m2;
		Boolean estaDisponible;
		TIPO_DE_OPERACION tipo;
		System.out.println("ingrese la calle");
		calle = teclado.next();
		System.out.println("ingrese el numero");
		numero = teclado.nextInt();
		System.out.println("ingrese la ciudad");
		ciudad = teclado.next();
		System.out.println("ingrese el precio");
		precio = teclado.nextDouble();
		System.out.println("ingrese la cantidad de metros cuadrados");
		m2=teclado.nextDouble();
		System.out.println("ingrese la disponibilidad");
		estaDisponible = teclado.nextBoolean();
		System.out.println("ingrese el tipo de operacion");
		System.out.println("1. Venta");
		System.out.println("2. Alquiler");
		System.out.println("3. Permuta");
		tipo = TIPO_DE_OPERACION.values()[teclado.nextInt() - 1];
		Terreno nuevoTerreno = new Terreno(calle, numero, ciudad, precio, m2, estaDisponible, tipo);
		if (actual.addTerreno(nuevoTerreno)) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("no se pudo agregar");
		}
	}

	private static Integer seleccionadorDePropiedades(Scanner teclado) {
		System.out.println("1. Campo");
		System.out.println("2. Casa");
		System.out.println("3. Departamento");
		System.out.println("4. Ph");
		System.out.println("5. Terreno");
		Integer opcion = teclado.nextInt();
		return opcion;
	}

	private static void modificarDepto(Scanner teclado, Departamento deptoBuscado) {
		Integer opcionAModificar;
		do {
			System.out.println("Ingrese la opcion que desea modificar");
			System.out.println("1. calle");
			System.out.println("2. numero");
			System.out.println("3. ciudad");
			System.out.println("4. precio");
			System.out.println("5. disponibilidad");
			System.out.println("6. operacion");
			System.out.println("7. piso");
			System.out.println("9. salir");
			opcionAModificar = teclado.nextInt();
			switch (opcionAModificar) {
			case 1:
				System.out.println("ingrese la nueva calle");
				deptoBuscado.setCalle(teclado.next());
				break;
			case 2:
				System.out.println("ingrese el nuevo numero");
				deptoBuscado.setNumero(teclado.nextInt());
				break;
			case 3:
				System.out.println("ingrese la nueva ciudad");
				deptoBuscado.setCiudad(teclado.next());
				break;
			case 4:
				System.out.println("ingrese el nuevo precio");
				deptoBuscado.setPrecio(teclado.nextDouble());
				break;
			case 5:
				System.out.println("ingrese la nueva disponibilidad");
				deptoBuscado.setEstaDisponible(teclado.nextBoolean());
				break;
			case 6:
				System.out.println("ingrese el nuevo tipo de operacion");
				deptoBuscado.setTipo(TIPO_DE_OPERACION.values()[teclado.nextInt()]);
				break;
			case 7:
				System.out.println("ingrese el nuevo piso y numero");
				deptoBuscado.setPiso(teclado.next());
				break;
			}

		} while (opcionAModificar != 9);
	}

	private static void modificarCasa(Scanner teclado, Casa casaBuscada) {
		Integer opcionAModificar;
		do {
			System.out.println("Ingrese la opcion que desea modificar");
			System.out.println("1. calle");
			System.out.println("2. numero");
			System.out.println("3. ciudad");
			System.out.println("4. precio");
			System.out.println("5. disponibilidad");
			System.out.println("6. operacion");
			System.out.println("9. salir");
			opcionAModificar = teclado.nextInt();
			switch (opcionAModificar) {
			case 1:
				System.out.println("ingrese la nueva calle");
				casaBuscada.setCalle(teclado.next());
				break;
			case 2:
				System.out.println("ingrese el nuevo numero");
				casaBuscada.setNumero(teclado.nextInt());
				break;
			case 3:
				System.out.println("ingrese la nueva ciudad");
				casaBuscada.setCiudad(teclado.next());
				break;
			case 4:
				System.out.println("ingrese el nuevo precio");
				casaBuscada.setPrecio(teclado.nextDouble());
				break;
			case 5:
				System.out.println("ingrese la nueva disponibilidad");
				casaBuscada.setEstaDisponible(teclado.nextBoolean());
				break;
			case 6:
				System.out.println("ingrese el nuevo tipo de operacion");
				casaBuscada.setTipo(TIPO_DE_OPERACION.values()[teclado.nextInt()]);
				break;
			}

		} while (opcionAModificar != 9);
	}

	private static void agregarDepto(Inmobiliaria actual, Scanner teclado) {
		String calle;
		Integer numero;
		String pisoYNumero;
		String ciudad;
		Double precio;
		Boolean estaDisponible;
		TIPO_DE_OPERACION tipo;
		System.out.println("ingrese la calle");
		calle = teclado.next();
		System.out.println("ingrese el numero");
		numero = teclado.nextInt();
		System.out.println("ingrese el piso y numero");
		pisoYNumero = teclado.next();
		System.out.println("ingrese la ciudad");
		ciudad = teclado.next();
		System.out.println("ingrese el precio");
		precio = teclado.nextDouble();
		System.out.println("ingrese la disponibilidad");
		estaDisponible = teclado.nextBoolean();
		System.out.println("ingrese el tipo de operacion");
		System.out.println("1. Venta");
		System.out.println("2. Alquiler");
		System.out.println("3. Permuta");
		tipo = TIPO_DE_OPERACION.values()[teclado.nextInt() - 1];
		Departamento nuevoDepto = new Departamento(calle, numero, pisoYNumero, ciudad, precio, estaDisponible, tipo);
		if (actual.addDepto(nuevoDepto)) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("no se pudo agregar");
		}
	}

	private static void agregarCasa(Inmobiliaria actual, Scanner teclado) {
		String calle;
		Integer numero;
		String ciudad;
		Double precio;
		Boolean estaDisponible;
		TIPO_DE_OPERACION tipo;
		System.out.println("ingrese la calle");
		calle = teclado.next();
		System.out.println("ingrese el numero");
		numero = teclado.nextInt();
		System.out.println("ingrese la ciudad");
		ciudad = teclado.next();
		System.out.println("ingrese el precio");
		precio = teclado.nextDouble();
		System.out.println("ingrese la disponibilidad");
		estaDisponible = teclado.nextBoolean();
		System.out.println("ingrese el tipo de operacion");
		System.out.println("1. Venta");
		System.out.println("2. Alquiler");
		System.out.println("3. Permuta");
		tipo = TIPO_DE_OPERACION.values()[teclado.nextInt() - 1];
		Casa nuevaCasa = new Casa(calle, numero, ciudad, precio, estaDisponible, tipo);
		if (actual.addCasa(nuevaCasa)) {
			System.out.println("Se agrego correctamente");
		} else {
			System.out.println("no se pudo agregar");
		}

	}

	private static void menu() {
		System.out.println("Menu De Opciones");
		System.out.println("1. Agregar nuevas propiedades");
		System.out.println("2. Modificar propiedades existentes");
		System.out.println("3. Agregar clientes");
		System.out.println("4. Obtener listado ordenado por precio");
		System.out.println("5. Obtener listado ordenado por ubicacion");
		System.out.println("6. Buscar propiedades por rango de precio");
		System.out.println("7. Buscar propiedades por ubicacion");
		System.out.println("8. Realizar la venta de una propiedad ");
		System.out.println("9. Realizar el alquiler de una propiedad");
	}
}
