package paquete1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public abstract class Paciente {

	private Integer legajo;
	private String nombre;
	private List<Plato> comidas;

	public Paciente(Integer legajo, String nombre) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.comidas = new ArrayList<Plato>();
	}

	protected abstract Boolean puedeComer(Set<String> ingredientes, Elaboracion elaboracion);

	public Boolean comer(Plato plato) {
		if (puedeComer(plato.getIngredientes(), plato.getElaboracionDelPlato())) {
			this.comidas.add(plato);
			return true;
		}
		return false;
	};

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(legajo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(legajo, other.legajo);
	}

	protected Boolean sumnistrarInsulina(Diabetico paciente) {
		// TODO Auto-generated method stub
		return false;
	}

}
