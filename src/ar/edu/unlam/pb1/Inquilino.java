package ar.edu.unlam.pb1;

public class Inquilino extends Cliente {

	public Inquilino(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		super(dni, nombre, apellido, telefono, mail);

	}

	
		 
//	las propiedades encontradas en el ArrayList<propiedad> propiedades de este tipo de Cliente
//	significan que no es el propietario, si no, el inquilino.
//	y mi falla esta en que estaria usando una coleccion de propiedades cuando solo deberia estar alquilando una
//	podria poner que solo pueda agregar 1 propiedad a la coleccion 
//	o al guardar el propietario cuando se carga la propiedad podria agregar otros metodos solo para inquilino

}
