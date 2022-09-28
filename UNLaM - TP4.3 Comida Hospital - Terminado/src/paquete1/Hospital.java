package paquete1;

import java.util.HashSet;
import java.util.Set;

public class Hospital {

	private String nombre;
	private Set<Paciente> listadodepacientes;
	
	public Hospital(String nombre) {
		super();
		this.nombre = nombre;
		this.listadodepacientes = new HashSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Paciente> getListadodepacientes() {
		return listadodepacientes;
	}

	public void setListadodepacientes(Set<Paciente> listadodepacientes) {
		this.listadodepacientes = listadodepacientes;
	}

	public void agregarPacienteAlHospital(Paciente paciente) {
		this.listadodepacientes.add(paciente);
		
	}
	
	public Paciente buscarPaciente(Integer legajo) {
		for (Paciente paciente : listadodepacientes) {
			if (paciente.getLegajo().equals(legajo))
				return paciente;
		}
		return null;
	}	
	
}
