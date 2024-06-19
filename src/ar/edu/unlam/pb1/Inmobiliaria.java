package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.HashSet;

public class Inmobiliaria implements OperacionesEntrePropiedades{
	private String nombre;
	private String direccion;
	private String eMail;
	private Integer telefono;
	private ArrayList<Propiedad> propiedades;
	private HashSet<Cliente> clientes;

	public Inmobiliaria(String nombre, String direccion, String eMail, Integer telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.eMail = eMail;
		this.telefono = telefono;
		this.propiedades = new ArrayList<>();
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
		if(nueva.getTipo()==TIPO_DE_OPERACION.VENTA && nueva.getPrecio()<10000.0) {
			throw new UmbralMinimoNoAlcanzadoException("La propiedad que intenta añadir no supera el umbral minimo de venta");
		}
		return propiedades.add(nueva);
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
		return cliente.agregarPosesionDePropiedadAlCliente(propiedadParaVender);

	}
	@Override
	public void venderPropiedad(Cliente vendedor, Propiedad propiedadParaVender, Cliente comprador) {
		if (clientes.contains(comprador) && clientes.contains(vendedor)) {
			if (vendedor.getPropiedades().contains(propiedadParaVender)) {
				if (propiedadParaVender.getEstaDisponible() && propiedadParaVender.getTipo().equals(TIPO_DE_OPERACION.VENTA)) {
					vendedor.eliminarPosesionDeLaPropiedad(propiedadParaVender);
					comprador.agregarPosesionDePropiedadAlCliente(propiedadParaVender);
					propiedadParaVender.setEstaDisponible(false);
				}

			}
		}

	}
	@Override
	public void alquilarPropiedad(Cliente propietario, Propiedad propiedadParaAlquilar, Cliente inquilino) {
		if (clientes.contains(inquilino) && clientes.contains(propietario)  ) {
			if (propietario.getPropiedades().contains(propiedadParaAlquilar)) {
				if (propiedadParaAlquilar.getEstaDisponible() && propiedadParaAlquilar.getTipo().equals(TIPO_DE_OPERACION.ALQUILER)) {
					inquilino.agregarPropiedadAlInquilino(propiedadParaAlquilar);
					propiedadParaAlquilar.setEstaDisponible(false);
				}

			}
		}

	}
	@Override
	public void permutarDosPropiedades(Cliente propietarioA, Cliente propietarioB, Propiedad propiedadA,
			Propiedad propiedadB) {
		if (clientes.contains(propietarioB) && clientes.contains(propietarioA)) {
			if (propietarioB.getPropiedades().contains(propiedadB)
					&& (propietarioA.getPropiedades().contains(propiedadA))) {
				if (propiedadB.getTipo().equals(TIPO_DE_OPERACION.PERMUTA)
						&& propiedadA.getTipo().equals(TIPO_DE_OPERACION.PERMUTA)) {
					if (propiedadB.getEstaDisponible() && propiedadA.getEstaDisponible()) {
						
						propietarioA.eliminarPosesionDeLaPropiedad(propiedadA);
						propietarioB.eliminarPosesionDeLaPropiedad(propiedadB);
						
						propietarioA.agregarPosesionDePropiedadAlCliente(propiedadB);
						propietarioB.agregarPosesionDePropiedadAlCliente(propiedadA);
						
						propiedadA.setEstaDisponible(false);
						propiedadB.setEstaDisponible(false);
					}
				}
			}
		}

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
