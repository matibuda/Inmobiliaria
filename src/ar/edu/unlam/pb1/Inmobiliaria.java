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

	public Boolean agregarPropiedad(Propiedad nueva) throws UmbralMinimoNoAlcanzadoException, TipoDeClienteErroneoException {
//		el enum TIPO_DE_OPERACION me permite diferenciar una propiedad en alquiler a la hora de agregarla 
//		ya que deberian tener umbrales de precio muy diferentes
		if((nueva.getTipo()==TIPO_DE_OPERACION.VENTA || nueva.getTipo()==TIPO_DE_OPERACION.PERMUTA ) && nueva.getPrecio()<10000.0) {
			throw new UmbralMinimoNoAlcanzadoException("La propiedad que intenta añadir no supera el umbral minimo de venta");
		}
		if(nueva.getTipo()==TIPO_DE_OPERACION.ALQUILER && nueva.getPrecio()<1000) {
			throw new UmbralMinimoNoAlcanzadoException("La propiedad que intenta añadir no supera el umbral minimo de alquiler");
		}
		if(nueva.getPropietario() instanceof Inquilino) {
			throw new TipoDeClienteErroneoException("El inquilino no puede ser propietario");
		}
		return propiedades.add(nueva);
	}
	
	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}
	
	private Boolean agregarOperacion(Operacion nueva) {
		return operaciones.add(nueva);
		
	}
	
	public ArrayList<Operacion> getOperaciones() {
		return operaciones;
	}

	public Boolean agregarCliente(Cliente nuevo) {
		return clientes.add(nuevo);
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
	public void operar(Operacion nueva) throws PropiedadNoPoseidaPorElClienteException, PropiedadNoDisponibleParaLaTransaccionException, TipoDeClienteErroneoException {
		nueva.ejecutar(); // si aca se produce una excepcion
		agregarOperacion(nueva); //  nunca sera agregada a la coleccion de operaciones 
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
	
	public ArrayList<Operacion> getVentas(){
		ArrayList<Operacion> ventas = new ArrayList<Operacion>();
			for (Operacion operacion : operaciones) {
				if (operacion instanceof Venta) {
					ventas.add(operacion);
				}
			}
		return ventas;
		
	}
	
	public ArrayList<Operacion> getAlquileres(){
		ArrayList<Operacion> alquileres = new ArrayList<Operacion>();
			for (Operacion operacion : operaciones) {
				if (operacion instanceof Alquiler) {
					alquileres.add(operacion);
				}
			}
		return alquileres;
		
	}
	
	public ArrayList<Operacion> getPermutas(){
		ArrayList<Operacion> permutas = new ArrayList<Operacion>();
			for (Operacion operacion : operaciones) {
				if (operacion instanceof Permuta) {
					permutas.add(operacion);
				}
			}
		return permutas;
		
	}
	
	public ArrayList<Operacion> getVentas(ArrayList<Operacion> operacionesRecibidas){
		ArrayList<Operacion> ventas = new ArrayList<Operacion>();
			for (Operacion operacion : operacionesRecibidas) {
				if (operacion instanceof Venta) {
					ventas.add(operacion);
				}
			}
		return ventas;
		
	}
	
	public ArrayList<Operacion> getAlquileres(ArrayList<Operacion> operacionesRecibidas){
		ArrayList<Operacion> alquileres = new ArrayList<Operacion>();
			for (Operacion operacion : operacionesRecibidas) {
				if (operacion instanceof Alquiler) {
					alquileres.add(operacion);
				}
			}
		return alquileres;
		
	}
	
	public ArrayList<Operacion> getPermutas(ArrayList<Operacion> operacionesRecibidas){
		ArrayList<Operacion> permutas = new ArrayList<Operacion>();
			for (Operacion operacion : operacionesRecibidas) {
				if (operacion instanceof Permuta) {
					permutas.add(operacion);
				}
			}
		return permutas;
		
	}
//	podria haber agregado getPropiedad() en "Operacion" y en permuta hacer la distincion de que devuelva 
//	un ArrayListz<Propiedad> con ambas propiedades en vez de solo una pero preferi aplicar el casteo
	public ArrayList<Operacion> buscarLasOperacionesEnLasQueParticipoDichaPropiedad(Propiedad propiedad) {
		ArrayList<Operacion> operacionesEnLasQueParticipoLaPropiedadBuscada = new ArrayList<Operacion>();
		for(Operacion actual:operaciones) {
			if (actual instanceof Venta) {
				if(((Venta)actual).getPropiedad().equals(propiedad)) {
					operacionesEnLasQueParticipoLaPropiedadBuscada.add(actual);
				}
			}
			if (actual instanceof Alquiler) {
				if(((Alquiler)actual).getPropiedad().equals(propiedad)) {
					operacionesEnLasQueParticipoLaPropiedadBuscada.add(actual);
				}
			}
			if (actual instanceof Permuta) {
				if(((Permuta)actual).getPropiedadA().equals(propiedad)||((Permuta)actual).getPropiedadB().equals(propiedad)) {
					operacionesEnLasQueParticipoLaPropiedadBuscada.add(actual);
				}
			}
		}
		return operacionesEnLasQueParticipoLaPropiedadBuscada;
	}
	
	

	public Cliente buscarElPropietarioAnteriorDeUnaPropiedadVendida(Propiedad propiedad) {
		ArrayList<Operacion> operacionesDeLaPropiedad = buscarLasOperacionesEnLasQueParticipoDichaPropiedad(propiedad);
		operacionesDeLaPropiedad = getVentas(operacionesDeLaPropiedad);
//		Como ArrayList apila significa que la ultima es la mas reciente (por ende la ultima venta que tuvo esa propiedad)
		Operacion ultima = operacionesDeLaPropiedad.getLast();
		
		
		return ((Venta)ultima).getPropietarioAnterior();
	}

	public Cliente buscarElPrimerClienteEnSerPropietarioDeEstaPropiedad(Propiedad propiedad) {
		ArrayList<Operacion> operacionesDeLaPropiedad = buscarLasOperacionesEnLasQueParticipoDichaPropiedad(propiedad);
		operacionesDeLaPropiedad = getVentas(operacionesDeLaPropiedad);
//		Como ArrayList apila significa que la primera es la operacion mas vieja que tuvo la propiedad 
		Operacion primera = operacionesDeLaPropiedad.getFirst();
		
		
		return ((Venta)primera).getPropietarioAnterior();
	}
	
	public Cliente buscarPropietarioActualDeUnaPropiedad(Propiedad propiedad) {
			return propiedad.getPropietario();
	}

}
