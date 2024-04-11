package ar.edu.unlam.pb1;

public class Inmobiliaria {
	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private Campo campos[];
	private Casa casas[];
	private Departamento departamentos[];
	private Ph phs[];
	private Terreno terrenos[];
	private Cliente clientes[];
	private final Integer CANTIDAD_MAXIMA_DE_PROPIEDADES = 100;

	public Inmobiliaria(String nombre, String direccion, String eMail, int telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.campos = new Campo[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.casas = new Casa[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.departamentos = new Departamento[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.phs = new Ph[CANTIDAD_MAXIMA_DE_PROPIEDADES];
		this.terrenos = new Terreno[CANTIDAD_MAXIMA_DE_PROPIEDADES];
	}

	public Inmobiliaria() {

	}

	public Boolean addCliente(Cliente nuevo) {
		Cliente aAgregar = null;
		aAgregar = buscarCliente(nuevo.getDni());
		if (aAgregar == null) {
			for (Cliente porAgregar : clientes) {
				if (porAgregar == null) {
					porAgregar = nuevo;
					return true;
				}
			}
		}
		return false;
	}

	public Cliente buscarCliente(Integer dni) {
		for (Cliente buscado : clientes) {
			if (buscado.getDni().equals(dni)) {
				return buscado;
			}
		}
		return null;
	}

	public Boolean addCasa(Casa nueva) {
		for (int i = 0; i < CANTIDAD_MAXIMA_DE_PROPIEDADES; i++) {
			if (!asegurarseDeQueNoExistaLaCasa(nueva)) {
				if (casas[i] == null) {
					casas[i] = nueva;
					return true;
				}
			}
		}
		return false;
	}

	private boolean asegurarseDeQueNoExistaLaCasa(Casa nueva) {
		for (Casa actual : casas) {
			if (actual != null && actual.equals(nueva)) {
				return true;
			}

		}
		return false;
	}

	public Boolean addDepto(Departamento nuevo) {
		for (int i = 0; i < CANTIDAD_MAXIMA_DE_PROPIEDADES; i++) {
			if (!asegurarseDeQueNoExistaElDepartamento(nuevo)) {
				if (departamentos[i] == null) {
					departamentos[i] = nuevo;
					return true;
				}
			}
		}
		return false;
	}

	private boolean asegurarseDeQueNoExistaElDepartamento(Departamento nuevo) {
		for (Departamento actual : departamentos) {
			if (actual != null && actual.equals(nuevo)) {
				return true;
			}

		}
		return false;
	}

	public Boolean addCampo(Campo nuevo) {
		for (Campo actual : campos) {
			if (actual == null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean addPh(Ph nuevo) {
		for (Ph actual : phs) {
			if (actual == null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Boolean addTerreno(Terreno nuevo) {
		for (Terreno actual : terrenos) {
			if (actual == null) {
				actual = nuevo;
				return true;
			}
		}
		return false;
	}

	public Casa buscarCasa(String codigoDeCasa) {
		Casa buscada = null;
		for (Casa actual : casas) {
			if ((actual != null) && (actual.getCodigo().equals(codigoDeCasa))) {
				buscada = actual;
				return buscada;
			}
		}
		return null;
	}

	public Departamento buscarDepartamento(String codigoDeDepartamento) {
		Departamento buscado = null;
		for (Departamento actual : departamentos) {
			if ((actual != null) && (actual.getCodigo().equals(codigoDeDepartamento))) {
				buscado = actual;
				return buscado;
			}

		}

		return null;
	}

	public Campo buscarCampo(String codigoDeCampo) {
		Campo buscado = null;
		for (Campo actual : campos) {
			if (actual != null && (actual.getCodigo().equals(codigoDeCampo))) {
				buscado = actual;
				return buscado;
			}

		}

		return null;
	}

	public Ph buscarPh(String codigoDePh) {
		Ph buscado = null;
		for (Ph actual : phs) {
			if (actual != null && (actual.getCodigo().equals(codigoDePh))) {
				buscado = actual;
				return buscado;
			}

		}

		return null;
	}

	public Terreno buscarTerreno(String codigoDeTerreno) {
		Terreno buscado = null;
		for (Terreno actual : terrenos) {
			if (actual != null && (actual.getCodigo().equals(codigoDeTerreno))) {
				buscado = actual;
				return buscado;
			}

		}

		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Departamento[] getDepartamentos() {
		return departamentos;
	}

	public Casa[] getCasas() {
		return casas;
	}

	public String mostrarPropiedades() {
		String resultado = "";
		for (Casa actual : casas) {
			if (actual != null) {
				resultado += actual + "\n";
			}
		}
		for (Departamento actual : departamentos) {
			if (actual != null) {
				resultado += actual + "\n";
			}
		}
		for (Campo actual : campos) {
			if (actual != null) {
				resultado += actual + "\n";
			}
		}
		for (Ph actual : phs) {
			if (actual != null) {
				resultado += actual + "\n";
			}
		}
		for (Terreno actual : terrenos) {
			if (actual != null) {
				resultado += actual + "\n";
			}
		}

		return resultado;
	}

	public void ordenarCasasPorPrecio() {
		Casa temp = null;
		for (Casa actual : casas) {
			for (int j = 0; j < casas.length - 1; j++) {
				if (casas[j].getPrecio() < casas[j + 1].getPrecio()) {
					temp = casas[j + 1];
					casas[j + 1] = casas[j];
					casas[j] = temp;
				}
			}

		}
	}

	public void ordenarCamposPorPrecio() {
		Campo temp = null;
		for (Campo actual : campos) {
			for (int j = 0; j < campos.length - 1; j++) {
				if (campos[j].getPrecio() < campos[j + 1].getPrecio()) {
					temp = campos[j + 1];
					campos[j + 1] = campos[j];
					campos[j] = temp;
				}
			}

		}
	}

	public void ordenarDepartamentosPorPrecio() {
		Departamento temp = null;
		for (Departamento actual : departamentos) {
			for (int j = 0; j < departamentos.length - 1; j++) {
				if (departamentos[j].getPrecio() < departamentos[j + 1].getPrecio()) {
					temp = departamentos[j + 1];
					departamentos[j + 1] = departamentos[j];
					departamentos[j] = temp;
				}
			}

		}
	}

	public void ordenarPhsPorPrecio() {
		Ph temp = null;
		for (Ph actual : phs) {
			for (int j = 0; j < phs.length - 1; j++) {
				if (phs[j].getPrecio() < phs[j + 1].getPrecio()) {
					temp = phs[j + 1];
					phs[j + 1] = phs[j];
					phs[j] = temp;
				}
			}

		}
	}

	public void ordenarTerrenosPorPrecio() {
		Terreno temp = null;
		for (Terreno actual : terrenos) {
			for (int j = 0; j < terrenos.length - 1; j++) {
				if (terrenos[j].getPrecio() < terrenos[j + 1].getPrecio()) {
					temp = terrenos[j + 1];
					terrenos[j + 1] = terrenos[j];
					terrenos[j] = temp;
				}
			}

		}
	}

	public void ordenarCasasPorCiudad() {
		Casa temp = null;
		for (Casa actual : casas) {
			for (int j = 0; j < casas.length - 1; j++) {
				if (casas[j].getCiudad().compareToIgnoreCase(casas[j + 1].getCiudad()) > 0) {
					temp = casas[j + 1];
					casas[j + 1] = casas[j];
					casas[j] = temp;
				}
			}

		}
	}

	public void ordenarCamposPorCiudad() {
		Campo temp = null;
		for (Campo actual : campos) {
			for (int j = 0; j < campos.length - 1; j++) {
				if (campos[j].getCiudad().compareToIgnoreCase(campos[j + 1].getCiudad()) > 0) {
					temp = campos[j + 1];
					campos[j + 1] = campos[j];
					campos[j] = temp;
				}
			}

		}
	}

	public void ordenarDepartamentosPorCiudad() {
		Departamento temp = null;
		for (Departamento actual : departamentos) {
			for (int j = 0; j < departamentos.length - 1; j++) {
				if (departamentos[j].getCiudad().compareToIgnoreCase(departamentos[j + 1].getCiudad()) > 0) {
					temp = departamentos[j + 1];
					departamentos[j + 1] = departamentos[j];
					departamentos[j] = temp;
				}
			}

		}
	}

	public void ordenarPhsPorCiudad() {
		Ph temp = null;
		for (Ph actual : phs) {
			for (int j = 0; j < phs.length - 1; j++) {
				if (phs[j].getCiudad().compareToIgnoreCase(phs[j + 1].getCiudad()) > 0) {
					temp = phs[j + 1];
					phs[j + 1] = phs[j];
					phs[j] = temp;
				}
			}

		}
	}

	public void ordenarTerrenosPorCiudad() {
		Terreno temp = null;
		for (Terreno actual : terrenos) {
			for (int j = 0; j < terrenos.length - 1; j++) {
				if (terrenos[j].getCiudad().compareToIgnoreCase(terrenos[j + 1].getCiudad()) > 0) {
					temp = terrenos[j + 1];
					terrenos[j + 1] = terrenos[j];
					terrenos[j] = temp;
				}
			}

		}
	}

	public Casa[] buscarCasasPorRangoDePrecio(Double rango1, Double rango2) {
		int count = 0;
		int index = 0;
		Casa[] CasasEnRangoDePrecio =null;
		for (Casa actual : casas) {
			if (actual != null && actual.getPrecio() >= rango1 && actual.getPrecio() <= rango2) {
				count++;
			}
		}

		if (count != 0) {
			CasasEnRangoDePrecio = new Casa[count];
			for (Casa actual : casas) {
				if (actual != null && actual.getPrecio() >= rango1 && actual.getPrecio() <= rango2) {
					CasasEnRangoDePrecio[index] = actual;
					index++;
				}
			}
		}
		return CasasEnRangoDePrecio;
	}

	public String buscarPropiedadesPorPrecio(Double rango1, Double rango2) {
		String resultado = null;
		for (Casa actual : casas) {
			if (actual != null && actual.getPrecio() > rango1 && actual.getPrecio() < rango2) {
				resultado += actual + "\n";
			}
		}

		for (Campo actual : campos) {
			if (actual != null && actual.getPrecio() > rango1 && actual.getPrecio() < rango2) {
				resultado += actual + "\n";
			}
		}

		for (Departamento actual : departamentos) {
			if (actual != null && actual.getPrecio() > rango1 && actual.getPrecio() < rango2) {
				resultado += actual + "\n";
			}
		}

		for (Ph actual : phs) {
			if (actual != null && actual.getPrecio() > rango1 && actual.getPrecio() < rango2) {
				resultado += actual + "\n";
			}
		}

		for (Terreno actual : terrenos) {
			if (actual != null && actual.getPrecio() > rango1 && actual.getPrecio() < rango2) {
				resultado += actual + "\n";
			}
		}
		return resultado;

	}

	public String buscarPropiedadesPorCiudad(String ciudad) {
		String resultado = "";
		for (Casa actual : casas) {
			if (actual != null && actual.getCiudad().equalsIgnoreCase(ciudad)) {
				resultado += actual + "\n";
			}
		}

		for (Campo actual : campos) {
			if (actual != null && actual.getCiudad().equalsIgnoreCase(ciudad)) {
				resultado += actual + "\n";
			}
		}

		for (Departamento actual : departamentos) {
			if (actual != null && actual.getCiudad().equalsIgnoreCase(ciudad)) {
				resultado += actual + "\n";
			}
		}

		for (Ph actual : phs) {
			if (actual != null && actual.getCiudad().equalsIgnoreCase(ciudad)) {
				resultado += actual + "\n";
			}
		}

		for (Terreno actual : terrenos) {
			if (actual != null && actual.getCiudad().equalsIgnoreCase(ciudad)) {
				resultado += actual + "\n";
			}
		}
		return resultado;

	}

	public void venderPropiedad(Integer dni, String codigoDePropiedad, TIPO_DE_PROPIEDADES tipoDePropiedad) {
		Cliente cliente = buscarCliente(dni);
		switch (tipoDePropiedad) {
		case CAMPO:
			Campo campoAVender = buscarCampo(codigoDePropiedad);
			if (campoAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				campoAVender.setEstaDisponible(false);
				cliente.agregarNuevoCampo(campoAVender);
			}

			break;
		case CASA:
			Casa casaAVender = buscarCasa(codigoDePropiedad);
			if (casaAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				casaAVender.setEstaDisponible(false);
				cliente.agregarNuevaCasa(casaAVender);
			}
			break;
		case DEPARTAMENTO:
			Departamento deptoAVender = buscarDepartamento(codigoDePropiedad);
			if (deptoAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				deptoAVender.setEstaDisponible(false);
				cliente.agregarNuevoDepartamento(deptoAVender);
			}
			break;
		case PH:
			Ph phAVender = buscarPh(codigoDePropiedad);
			if (phAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				phAVender.setEstaDisponible(false);
				cliente.agregarNuevoPh(phAVender);
			}
			break;
		case TERRENO:
			Terreno terrenoAVender = buscarTerreno(codigoDePropiedad);
			if (terrenoAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				terrenoAVender.setEstaDisponible(false);
				cliente.agregarNuevoTereno(terrenoAVender);
			}
			break;
		default:
			break;

		}

	}

	public void alquilarPropiedad(Integer dni, String codigoDePropiedad, TIPO_DE_PROPIEDADES tipoDePropiedad) {
		Cliente cliente = buscarCliente(dni);
		switch (tipoDePropiedad) {
		case CAMPO:
			Campo campoAAlquilar = buscarCampo(codigoDePropiedad);
			if (campoAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				campoAAlquilar.setEstaDisponible(false);
				cliente.agregarNuevoCampo(campoAAlquilar);
			}

			break;
		case CASA:
			Casa casaAAlquilar = buscarCasa(codigoDePropiedad);
			if (casaAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				casaAAlquilar.setEstaDisponible(false);
				cliente.agregarNuevaCasa(casaAAlquilar);
			}
			break;
		case DEPARTAMENTO:
			Departamento deptoAAlquilar = buscarDepartamento(codigoDePropiedad);
			if (deptoAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				deptoAAlquilar.setEstaDisponible(false);
				cliente.agregarNuevoDepartamento(deptoAAlquilar);
			}
			break;
		case PH:
			Ph phAAlquilar = buscarPh(codigoDePropiedad);
			if (phAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				phAAlquilar.setEstaDisponible(false);
				cliente.agregarNuevoPh(phAAlquilar);
			}
			break;
		case TERRENO:
			Terreno terrenoAAlquilar = buscarTerreno(codigoDePropiedad);
			if (terrenoAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				terrenoAAlquilar.setEstaDisponible(false);
				cliente.agregarNuevoTereno(terrenoAAlquilar);
			}
			break;
		default:
			break;

		}

	}

	public Double obtenerPromedioDeLasCasas() {
		Integer cantidadDeCasas = 0;
		Double sumatoriaDelPrecio = 0.0;
		Double promedio = 0.0;
		for (Casa actual : casas) {
			if (actual != null) {
				cantidadDeCasas++;
				sumatoriaDelPrecio += actual.getPrecio();
			}
		}
		if (cantidadDeCasas != 0) {
			promedio = sumatoriaDelPrecio / cantidadDeCasas;
		}
		return promedio;
	}

	public Double obtenerPromedioDeLosDepartamentos() {
		Integer cantidadDeCasas = 0;
		Double sumatoriaDelPrecio = 0.0;
		Double promedio = 0.0;
		for (Departamento actual : departamentos) {
			if (actual != null) {
				cantidadDeCasas++;
				sumatoriaDelPrecio += actual.getPrecio();
			}
		}
		if (cantidadDeCasas != 0) {
			promedio = sumatoriaDelPrecio / cantidadDeCasas;
		}
		return promedio;
	}

}
