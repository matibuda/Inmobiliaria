package ar.edu.unlam.pb1;

public class Inquilino extends Cliente {

	public Inquilino(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		super(dni, nombre, apellido, telefono, mail);

	}

	
		 
//	las propiedades encontradas en la coleccion de propiedades de este tipo de Cliente
//	significan que no es el propietario, si no, el inquilino.
//	seria raro que un inquilino comun y corriente alquile mas de una propiedad asi que para el uso
//	comun estaria de mas poner una coleccion para alquileres pero puede ser una empresa 
//	con varios terrenos alquilados

}
