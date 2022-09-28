package paquete1;

import java.util.Set;

public class General extends Paciente {

	public General(Integer legajo, String nombre) {
		super(legajo, nombre);
		
	}

	@Override
	protected Boolean puedeComer(Set<String> ingredientes, Elaboracion elaboracion) {
		// TODO Auto-generated method stub
		return true;
	}

}
