package ar.edu.unlam.pb1;

public class ClienteNoExistenteException extends Exception {

	public ClienteNoExistenteException(String mensaje) {
		super(mensaje);
	}
}
