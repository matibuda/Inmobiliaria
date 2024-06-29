package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.HashSet;

public class Inmobiliaria{
	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private ArrayList<Propiedad> propiedades;
	private ArrayList<Operacion> operaciones;
	private HashSet<Cliente> clientes;

	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.propiedades = new ArrayList<>();
		this.operaciones = new ArrayList<>();
		this.clientes = new HashSet<>();
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Boolean agregarCliente(Cliente nuevo) {
		return clientes.add(nuevo);
	}

	public Boolean agregarPropiedad(Propiedad nueva) throws UmbralMinimoNoAlcanzadoException {
//		el enum TIPO_DE_OPERACION me permite diferenciar una propiedad en alquiler a la hora de agregarla a la inmobiliaria ya que deberian tener umbrales de precio muy diferentes
		if((nueva.getTipo()==TIPO_DE_OPERACION.VENTA || nueva.getTipo()==TIPO_DE_OPERACION.PERMUTA ) && nueva.getPrecio()<10000.0) {
			throw new UmbralMinimoNoAlcanzadoException("La propiedad que intenta añadir no supera el umbral minimo de venta");
		}
		if(nueva.getTipo()==TIPO_DE_OPERACION.ALQUILER && nueva.getPrecio()<1000) {
			throw new UmbralMinimoNoAlcanzadoException("La propiedad que intenta añadir no supera el umbral minimo de alquiler");
		}
		return propiedades.add(nueva);
	}
	
	private Boolean agregarOperacion(Operacion nueva) {
		return operaciones.add(nueva);
		
	}
	
	public HashSet<Cliente> getClientes(){
		return clientes;
	}
	
	public ArrayList<Propiedad> getCasas() {
		ArrayList<Propiedad> casas = new ArrayList<>();
		for (Propiedad actual : propiedades) {
			if (actual instanceof Casa) {
				casas.add(actual);
			}
		}
		return casas;
	}
	
	public ArrayList<Propiedad> getCasas(ArrayList<Propiedad> devolverSoloCasas) {
		ArrayList<Propiedad> casas = new ArrayList<>();
		for (Propiedad actual : devolverSoloCasas) {
			if (actual instanceof Casa) {
				casas.add(actual);
			}
		}
		return casas;
	}

	public ArrayList<Propiedad> getDepartamentos() {
		ArrayList<Propiedad> departamentos = new ArrayList<>();
		for (Propiedad actual : propiedades) {
			if (actual instanceof Departamento) {
				departamentos.add(actual);
			}
		}
		return departamentos;
	}

	public ArrayList<Propiedad> getDepartamentos(ArrayList<Propiedad> devolverSoloDepartamentos) {
		ArrayList<Propiedad> departamentos = new ArrayList<>();
		for (Propiedad actual : devolverSoloDepartamentos) {
			if (actual instanceof Departamento) {
				departamentos.add(actual);
			}
		}
		return departamentos;
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public Double obtenerPromedioDeLasCasas() {
		ArrayList<Propiedad> casasAPromediar = getCasas();
		Integer cantidadDeCasas = casasAPromediar.size();
		Double sumatoriaDelPrecio = 0.0;
		Double promedio = 0.0;

		for (Propiedad actual : casasAPromediar) {
			sumatoriaDelPrecio += actual.getPrecio();
		}
		if (cantidadDeCasas != 0) {
			promedio = sumatoriaDelPrecio / cantidadDeCasas;
		}
		return promedio;
	}

	public Double obtenerPromedioDeLosDepartamentos() {
		ArrayList<Propiedad> departamentosAPromediar = getDepartamentos();
		Integer cantidadDeDepartamentos = departamentosAPromediar.size();
		Double sumatoriaDelPrecio = 0.0;
		Double promedio = 0.0;

		for (Propiedad actual : departamentosAPromediar) {
			sumatoriaDelPrecio += actual.getPrecio();
		}
		if (cantidadDeDepartamentos != 0) {
			promedio = sumatoriaDelPrecio / cantidadDeDepartamentos;
		}
		return promedio;
	}

	public Boolean agregarPropiedadAlCliente(Cliente cliente, Propiedad propiedadParaVender) {
		return cliente.agregarPropiedad(propiedadParaVender);

	}
	public void operar(Operacion nueva) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		nueva.ejecutar(); // si aca se produce una excepcion
		agregarOperacion(nueva); //  nunca sera agregada a la coleccion de operaciones si es que tiene excepciones
	}
	
	// estos metodos de aca hacen lo mismo que "operar(Operacion nueva)" pero separados por cada operacion
	public void vender(Cliente vendedor, Propiedad propiedadParaVender, Cliente comprador) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Operacion nueva = new Venta(vendedor,propiedadParaVender,comprador);
		nueva.ejecutar(); // si aca se produce una excepcion
		agregarOperacion(nueva); //  nunca sera agregada a la coleccion de operaciones si es que tiene excepciones
	}
	
	public void alquilar(Cliente propietario, Propiedad propiedadParaAlquilar, Cliente inquilino) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Operacion nueva = new Alquiler(propietario,propiedadParaAlquilar,inquilino);
		nueva.ejecutar(); // si aca se produce una excepcion
		agregarOperacion(nueva); //  nunca sera agregada a la coleccion de operaciones si es que tiene excepciones
	}
	
	public void permutar(Cliente propietarioA,Cliente propietarioB,Propiedad propiedadA, Propiedad propiedadB) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		Operacion nueva = new Permuta(propietarioA,propietarioB,propiedadA,propiedadB);
		nueva.ejecutar(); // si aca se produce una excepcion
		agregarOperacion(nueva); //  nunca sera agregada a la coleccion de operaciones si es que tiene excepciones
	}

	public ArrayList<Propiedad> buscarPropiedadesPorRangoDePrecio(Double rangoDePrecioMenor, Double rangoDePrecioMayor) throws SinResultadosException {
		ArrayList<Propiedad> propiedadesPorRango = new ArrayList<Propiedad>();
		for (Propiedad actual : propiedades) {
			if (actual.getPrecio() >= rangoDePrecioMenor && actual.getPrecio() <= rangoDePrecioMayor) {
				propiedadesPorRango.add(actual);
			}
		}
		
		if(propiedadesPorRango.size()==0) {
			throw new SinResultadosException("La busqueda no tuvo ningun resultado");
		}
		return propiedadesPorRango;
	}

	public ArrayList<Propiedad> ordenarPropiedadesPorPrecio() {
		propiedades.sort(null);
		return propiedades;
	}

	public ArrayList<Propiedad> ordenarPropiedadesPorPrecio(ArrayList<Propiedad> propiedadesAOrdenar) {
		propiedadesAOrdenar.sort(null);
		return propiedadesAOrdenar;
	}

	public ArrayList<Propiedad> buscarPropiedadesPorUbicacion(String ciudad) throws SinResultadosException {
		ArrayList<Propiedad> propiedadesPorRango = new ArrayList<Propiedad>();
		for (Propiedad actual : propiedades) {
			if (actual.getCiudad().equalsIgnoreCase(ciudad)) {
				propiedadesPorRango.add(actual);
			}
		}
		if(propiedadesPorRango.size()==0) {
			throw new SinResultadosException("La busqueda no tuvo ningun resultado");
		}
		return propiedadesPorRango;
	}

	public void ordenarPropiedadesPorUbicacion(ArrayList<Propiedad> propiedadesAOrdenarPorUbicacion) {
		ArrayList<Propiedad> propiedadesAOrdenar = propiedadesAOrdenarPorUbicacion;
		propiedadesAOrdenar.sort(new OrdenarPropiedadesPorUbicacion());

	}

}
