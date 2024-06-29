package ar.edu.unlam.pb1;

public class Propietario extends Cliente {

	public Propietario(Integer dni, String nombre, String apellido, Integer telefono, String mail) {
		super(dni, nombre, apellido, telefono, mail);
	}
	
//	hay muchas distinciones a lo largo de la logica del programa donde solo permiten a un Propietario
//	vender o permutar una casa / ser el que posea la propiedad para poder alquilarla a un Inquilino
// 	un inquilino no puede vender la casa del propietario (por lo menos no atravez de mi inmobiliaria) 
}
