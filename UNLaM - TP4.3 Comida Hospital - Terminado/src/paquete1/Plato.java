package paquete1;

import java.util.*;

public class Plato {

	private String nombreDelPlato;
	private Set<String> ingredientes;
	private Elaboracion elaboracionDelPlato;
	
	public Plato(String nombreDelPlato, Elaboracion elaboracionDelPlato) {
		super();
		this.nombreDelPlato = nombreDelPlato;
		this.elaboracionDelPlato = elaboracionDelPlato;
		this.ingredientes = new HashSet<String>();
	}

	public void agregarIngredienteAlPlato(String ingrediente) {
		this.ingredientes.add(ingrediente);
	}
	
	public String getNombreDelPlato() {
		return nombreDelPlato;
	}

	public void setNombreDelPlato(String nombreDelPlato) {
		this.nombreDelPlato = nombreDelPlato;
	}

	public Set<String> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(Set<String> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Elaboracion getElaboracionDelPlato() {
		return elaboracionDelPlato;
	}

	public void setElaboracionDelPlato(Elaboracion elaboracionDelPlato) {
		this.elaboracionDelPlato = elaboracionDelPlato;
	}


}
