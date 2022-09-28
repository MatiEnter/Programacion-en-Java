package paquete1;

import java.util.Set;

public class Celiaco extends Paciente {

	public Celiaco(Integer legajo, String nombre) {
		super(legajo, nombre);
		
	}

	@Override
	protected Boolean puedeComer(Set<String> ingredientes, Elaboracion elaboracion) {
		for (String string : ingredientes) {
			if (string.equals("trigo") || string.equals("avena") || string.equals("centeno") || string.equals("cebada")) {
				return false;
			}
		}
		return true;
	}


}
