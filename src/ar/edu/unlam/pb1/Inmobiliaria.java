package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.HashSet;

public class Inmobiliaria {
	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private ArrayList<Propiedad> propiedadesEnVenta;
	private ArrayList<Campo> campos;
	private ArrayList<Casa> casas;
	private ArrayList<Departamento> departamentos;
	private ArrayList<Ph> phs;
	private ArrayList<Terreno> terrenos;
	private HashSet<Cliente> clientes;

	public Inmobiliaria(String nombre, String direccion, String eMail, int telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.campos = new ArrayList<>();
		this.casas = new ArrayList<>();
		this.departamentos = new ArrayList<>();
		this.phs = new ArrayList<>();
		this.terrenos = new ArrayList<>();
		this.propiedadesEnVenta = new ArrayList<>();
		this.clientes = new HashSet<>();
	}

	public Inmobiliaria() {

	}

	public Boolean addCliente(Cliente nuevo) {
		return clientes.add(nuevo);
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
		Casa existente = null;
		existente = buscarCasa(nueva.getCodigo());
		if (existente == null) {
			return casas.add(nueva);
		}
		return false;
	}

	public Boolean addDepto(Departamento nuevo) {
		Departamento existente = null;
		existente = buscarDepartamento(nuevo.getCodigo());
		if (existente == null) {
			return departamentos.add(nuevo);
		}
		return false;
	}

	public Boolean addCampo(Campo nuevo) {
		return campos.add(nuevo);
	}

	public Boolean addPh(Ph nuevo) {
		return phs.add(nuevo);
	}

	public Boolean addTerreno(Terreno nuevo) {
		return terrenos.add(nuevo);
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

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}

	public ArrayList<Propiedad> getPropiedadesEnVenta() {
		return propiedadesEnVenta;
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
		for (int i = 0; i < casas.size(); i++) {
			for (int j = 0; j < casas.size() - 1; j++) {
				if (casas.get(j).getPrecio() > casas.get(j + 1).getPrecio()) {
					temp = casas.get(j);
					casas.set(j, casas.get(j + 1));
					casas.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarCamposPorPrecio() {
		Campo temp = null;
		for (int i = 0; i < campos.size(); i++) {
			for (int j = 0; j < campos.size() - 1; j++) {
				if (campos.get(j).getPrecio() > campos.get(j + 1).getPrecio()) {
					temp = campos.get(j);
					campos.set(j, campos.get(j + 1));
					campos.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarDepartamentosPorPrecio() {
		Departamento temp = null;
		for (int i = 0; i < departamentos.size(); i++) {
			for (int j = 0; j < departamentos.size() - 1; j++) {
				if (departamentos.get(j).getPrecio() > departamentos.get(j + 1).getPrecio()) {
					temp = departamentos.get(j);
					departamentos.set(j, departamentos.get(j + 1));
					departamentos.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarPhsPorPrecio() {
		Ph temp = null;
		for (int i = 0; i < phs.size(); i++) {
			for (int j = 0; j < phs.size() - 1; j++) {
				if (phs.get(j).getPrecio() > phs.get(j + 1).getPrecio()) {
					temp = phs.get(j);
					phs.set(j, phs.get(j + 1));
					phs.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarTerrenosPorPrecio() {
		Terreno temp = null;
		for (int i = 0; i < terrenos.size(); i++) {
			for (int j = 0; j < terrenos.size() - 1; j++) {
				if (terrenos.get(j).getPrecio() > terrenos.get(j + 1).getPrecio()) {
					temp = terrenos.get(j);
					terrenos.set(j, terrenos.get(j + 1));
					terrenos.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarCasasPorCiudad() {
		Casa temp = null;
		for (int i = 0; i < casas.size(); i++) {
			for (int j = 0; j < casas.size() - 1; j++) {
				if (casas.get(j).getCiudad().compareTo(casas.get(j + 1).getCiudad()) > 0) {
					temp = casas.get(j);
					casas.set(j, casas.get(j + 1));
					casas.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarCamposPorCiudad() {
		Campo temp = null;
		for (int i = 0; i < campos.size(); i++) {
			for (int j = 0; j < campos.size() - 1; j++) {
				if (campos.get(j).getCiudad().compareTo(campos.get(j + 1).getCiudad()) > 0) {
					temp = campos.get(j);
					campos.set(j, campos.get(j + 1));
					campos.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarDepartamentosPorCiudad() {
		Departamento temp = null;
		for (int i = 0; i < departamentos.size(); i++) {
			for (int j = 0; j < departamentos.size() - 1; j++) {
				if (departamentos.get(j).getCiudad().compareTo(departamentos.get(j + 1).getCiudad()) > 0) {
					temp = departamentos.get(j);
					departamentos.set(j, departamentos.get(j + 1));
					departamentos.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarPhsPorCiudad() {
		Ph temp = null;
		for (int i = 0; i < phs.size(); i++) {
			for (int j = 0; j < phs.size() - 1; j++) {
				if (phs.get(j).getCiudad().compareTo(phs.get(j + 1).getCiudad()) > 0) {
					temp = phs.get(j);
					phs.set(j, phs.get(j + 1));
					phs.set(j + 1, temp);
				}
			}
		}
	}

	public void ordenarTerrenosPorCiudad() {
		Terreno temp = null;
		for (int i = 0; i < terrenos.size(); i++) {
			for (int j = 0; j < terrenos.size() - 1; j++) {
				if (terrenos.get(j).getCiudad().compareTo(terrenos.get(j + 1).getCiudad()) > 0) {
					temp = terrenos.get(j);
					terrenos.set(j, terrenos.get(j + 1));
					terrenos.set(j + 1, temp);
				}
			}
		}
	}

	public ArrayList<Casa> buscarCasasPorRangoDePrecio(Double rango1, Double rango2) {
		ArrayList<Casa> resultado = new ArrayList<>();
		for (Casa actual : casas) {
			if (actual.getPrecio() >= rango1 && actual.getPrecio() <= rango2) {
				resultado.add(actual);

			}
		}
		
		if(resultado.size()==0) {
			return null;
		}
		return resultado;
	}

	public String mostrarPropiedadesPorPrecio(Double rango1, Double rango2) {
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

	public String mostrarPropiedadesPorCiudad(String ciudad) {
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
				cliente.addCasa(casaAVender);
			}
			break;
		case DEPARTAMENTO:
			Departamento deptoAVender = buscarDepartamento(codigoDePropiedad);
			if (deptoAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				deptoAVender.setEstaDisponible(false);
				cliente.addDepto(deptoAVender);
			}
			break;
		case PH:
			Ph phAVender = buscarPh(codigoDePropiedad);
			if (phAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				phAVender.setEstaDisponible(false);
				cliente.addPh(phAVender);
			}
			break;
		case TERRENO:
			Terreno terrenoAVender = buscarTerreno(codigoDePropiedad);
			if (terrenoAVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				terrenoAVender.setEstaDisponible(false);
				cliente.addTerreno(terrenoAVender);
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
				cliente.addCasa(casaAAlquilar);
			}
			break;
		case DEPARTAMENTO:
			Departamento deptoAAlquilar = buscarDepartamento(codigoDePropiedad);
			if (deptoAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				deptoAAlquilar.setEstaDisponible(false);
				cliente.addDepto(deptoAAlquilar);
			}
			break;
		case PH:
			Ph phAAlquilar = buscarPh(codigoDePropiedad);
			if (phAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				phAAlquilar.setEstaDisponible(false);
				cliente.addPh(phAAlquilar);
			}
			break;
		case TERRENO:
			Terreno terrenoAAlquilar = buscarTerreno(codigoDePropiedad);
			if (terrenoAAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
				terrenoAAlquilar.setEstaDisponible(false);
				cliente.addTerreno(terrenoAAlquilar);
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

	public ArrayList<Propiedad> buscarPropiedadesEnVenta() {
		for(Casa actual: casas) {
			if(actual.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				propiedadesEnVenta.add(actual);
			}
		}
		for(Departamento actual: departamentos) {
			if(actual.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				propiedadesEnVenta.add(actual);
			}
		}
		for(Campo actual: campos) {
			if(actual.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				propiedadesEnVenta.add(actual);
			}
		}
		for(Ph actual: phs) {
			if(actual.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				propiedadesEnVenta.add(actual);
			}
		}
		for(Terreno actual: terrenos) {
			if(actual.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
				propiedadesEnVenta.add(actual);
			}
		}
		
		if(propiedadesEnVenta.size()==0) {
			return null;
		}
		return propiedadesEnVenta;
	}

}
