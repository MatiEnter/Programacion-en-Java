package paquete1;

import java.util.Set;

public class Oncologico extends Paciente {

	public Oncologico(Integer legajo, String nombre) {
		super(legajo, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean puedeComer(Set<String> ingredientes, Elaboracion elaboracion) {
	
			if (elaboracion.equals(Elaboracion.SIN_COCCION)) {
				return false;
			} else
		
		return true;
	}
}

	

