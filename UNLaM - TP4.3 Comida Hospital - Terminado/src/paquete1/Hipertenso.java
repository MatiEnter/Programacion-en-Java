package paquete1;

import java.util.Set;

public class Hipertenso extends Paciente {

	public Hipertenso(Integer legajo, String nombre) {
		super(legajo, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean puedeComer(Set<String> ingredientes, Elaboracion elaboracion) {
		for (String string : ingredientes) {
			if (string.equals("sal")) {
				return false;
			}
		}
		return true;
	}

}
