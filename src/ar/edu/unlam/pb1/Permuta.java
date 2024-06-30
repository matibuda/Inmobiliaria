package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Permuta implements Operacion {
	private Cliente propietarioA;
	private Cliente propietarioB;
	private Propiedad propiedadA;
	private Propiedad propiedadB;
	private LocalDate fecha;

	public Permuta(Propiedad propiedadA, Propiedad propiedadB) {
		this.propietarioA=propiedadA.getPropietario();
		this.propietarioB=propiedadB.getPropietario();
		this.propiedadA=propiedadA;
		this.propiedadB=propiedadB;
		this.fecha=LocalDate.now();
	}
	@Override
	public void ejecutar() throws  PropiedadNoDisponibleParaLaTransaccionException{
		
			if (!propiedadB.getTipo().equals(TIPO_DE_OPERACION.PERMUTA) || !propiedadA.getTipo().equals(TIPO_DE_OPERACION.PERMUTA) || !propiedadB.getEstaDisponible() || !propiedadA.getEstaDisponible()) {
				// eliminando TIPO_DE_OPERACION lo unico que cambiaria es que las propiedades se prodan vender permutar o alquilar sin importar el deseo del cliente
				throw new PropiedadNoDisponibleParaLaTransaccionException("Esta propiedad no se encuentra dispoble para la transaccion que desea realizar");
			}
					propiedadA.setPropietario(propietarioB);
					propiedadB.setPropietario(propietarioA);
					
					propiedadA.setEstaDisponible(false);
					propiedadB.setEstaDisponible(false);

}
	public Cliente getPropietarioA() {
		return propietarioA;
	}
	public Cliente getPropietarioB() {
		return propietarioB;
	}
	public Propiedad getPropiedadA() {
		return propiedadA;
	}
	public Propiedad getPropiedadB() {
		return propiedadB;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	@Override
	public String toString() {
		return "Permuta [propietarioA=" + propietarioA + ", propietarioB=" + propietarioB + ", propiedadA=" + propiedadA
				+ ", propiedadB=" + propiedadB + ", fecha=" + fecha + "]";
	}
	
	

	}


