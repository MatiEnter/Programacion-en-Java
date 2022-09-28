package paquete1;

import java.util.Set;

public class Diabetico extends Paciente {

	private TipoDeDiabetico tipo;
	
	public Diabetico(Integer legajo, String nombre, TipoDeDiabetico tipo) {
		super(legajo, nombre);
		this.tipo = tipo;
	}

	
	public TipoDeDiabetico getTipo() {
		return tipo;
	}


	public void setTipo(TipoDeDiabetico tipo) {
		this.tipo = tipo;
	}
	
	@Override
	protected Boolean puedeComer(Set<String> ingredientes, Elaboracion elaboracion) {
		for (String string : ingredientes) {
			if (string.equals("azucar")) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected Boolean sumnistrarInsulina(Diabetico paciente) {
		if(paciente.getTipo() == TipoDeDiabetico.TIPO_2) {
			return true;
		}
		return false;
	}

}
