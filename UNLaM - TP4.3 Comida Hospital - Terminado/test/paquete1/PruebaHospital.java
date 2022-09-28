package paquete1;

import static org.junit.Assert.*;

import org.junit.*;


public class PruebaHospital {

	Paciente oncologico = new Oncologico(1001, "Rojas Matias");
	Paciente diabetico = new Diabetico(1002, "Lionel Messi",TipoDeDiabetico.TIPO_2);
	Paciente celiaco = new Celiaco(1003, "Daddy Yankee");
	Paciente hipertenso = new Hipertenso(1004, "Mauro Lombardo");
	Paciente general = new General(1005, "Luquitas Rodriguez");
	
	Hospital sanatorioDelOeste = new Hospital("Sanatorio Del Oeste");

	@Test
	public void queSePuedaAgregarPacientesAlHospital() {
	
		sanatorioDelOeste.agregarPacienteAlHospital(oncologico);
		sanatorioDelOeste.agregarPacienteAlHospital(diabetico);
		sanatorioDelOeste.agregarPacienteAlHospital(celiaco);
		sanatorioDelOeste.agregarPacienteAlHospital(hipertenso);
		sanatorioDelOeste.agregarPacienteAlHospital(general);
		
		assertTrue(sanatorioDelOeste.getListadodepacientes().contains(oncologico));
		assertTrue(sanatorioDelOeste.getListadodepacientes().contains(diabetico));
		assertTrue(sanatorioDelOeste.getListadodepacientes().contains(celiaco));
		assertTrue(sanatorioDelOeste.getListadodepacientes().contains(hipertenso));
		assertTrue(sanatorioDelOeste.getListadodepacientes().contains(general));
	}
	
	@Test
	public void queSePuedanCrearPlatosParaElMenuDelHospital() {
		
		Plato pechugaconpapas = new Plato("Pechuga con guarnicion",Elaboracion.AL_HORNO);
		pechugaconpapas.agregarIngredienteAlPlato("pechuga de pollo");
		pechugaconpapas.agregarIngredienteAlPlato("papas peladas");
		
		Plato sushi = new Plato("Sushi hospitalario",Elaboracion.SIN_COCCION);
		sushi.agregarIngredienteAlPlato("pescado");
		sushi.agregarIngredienteAlPlato("sal");
		sushi.agregarIngredienteAlPlato("centeno");
		
		Plato pan = new Plato("Pan",Elaboracion.AL_HORNO);
		pan.agregarIngredienteAlPlato("trigo");
		pan.agregarIngredienteAlPlato("agua");
		
		Plato papasfritas = new Plato("Papas fritas",Elaboracion.FRITO);
		papasfritas.agregarIngredienteAlPlato("sal");
		papasfritas.agregarIngredienteAlPlato("papa");
		papasfritas.agregarIngredienteAlPlato("aceite");
		
		Plato bizcochuelo = new Plato("Bizcochuelo con mucha azucar",Elaboracion.AL_HORNO);
		bizcochuelo.agregarIngredienteAlPlato("azucar");
		bizcochuelo.agregarIngredienteAlPlato("trigo");
		bizcochuelo.agregarIngredienteAlPlato("huevo");
		bizcochuelo.agregarIngredienteAlPlato("rayadura de limon");
		
		assertNotNull(pechugaconpapas);
		assertNotNull(sushi);
		assertNotNull(pan);
		assertNotNull(papasfritas);
		assertNotNull(bizcochuelo);
	}

	@Test
	public void queUnPacienteSinRestriccionesPuedaComerLoQueQuiera() {
		sanatorioDelOeste.agregarPacienteAlHospital(general);
		
		Plato pechugaconpapas = new Plato("Pechuga con guarnicion",Elaboracion.AL_HORNO);
		pechugaconpapas.agregarIngredienteAlPlato("pechuga de pollo");
		pechugaconpapas.agregarIngredienteAlPlato("papas peladas");
		
		Plato sushi = new Plato("Sushi hospitalario",Elaboracion.SIN_COCCION);
		sushi.agregarIngredienteAlPlato("pescado");
		sushi.agregarIngredienteAlPlato("sal");
		sushi.agregarIngredienteAlPlato("centeno");
		
		Plato pan = new Plato("Pan",Elaboracion.AL_HORNO);
		pan.agregarIngredienteAlPlato("trigo");
		pan.agregarIngredienteAlPlato("agua");
		
		Plato papasfritas = new Plato("Papas fritas",Elaboracion.FRITO);
		papasfritas.agregarIngredienteAlPlato("sal");
		papasfritas.agregarIngredienteAlPlato("papa");
		papasfritas.agregarIngredienteAlPlato("aceite");
		
		Plato bizcochuelo = new Plato("Bizcochuelo con mucha azucar",Elaboracion.AL_HORNO);
		bizcochuelo.agregarIngredienteAlPlato("azucar");
		bizcochuelo.agregarIngredienteAlPlato("trigo");
		bizcochuelo.agregarIngredienteAlPlato("huevo");
		bizcochuelo.agregarIngredienteAlPlato("rayadura de limon");
		
		assertTrue(sanatorioDelOeste.buscarPaciente(1005).comer(bizcochuelo));
		assertTrue(sanatorioDelOeste.buscarPaciente(1005).comer(papasfritas));
		assertTrue(sanatorioDelOeste.buscarPaciente(1005).comer(pan));
		assertTrue(sanatorioDelOeste.buscarPaciente(1005).comer(sushi));
		assertTrue(sanatorioDelOeste.buscarPaciente(1005).comer(pechugaconpapas));
	}
	
	@Test
	public void queUnPacienteConAlgunaRestriccionDeIngredienteNoPuedaComerUnPlatoQueContengaEseIngrediente() {
		sanatorioDelOeste.agregarPacienteAlHospital(diabetico);
		sanatorioDelOeste.agregarPacienteAlHospital(celiaco);
		
		Plato bizcochuelo = new Plato("Bizcochuelo con mucha azucar",Elaboracion.AL_HORNO);
		bizcochuelo.agregarIngredienteAlPlato("azucar");
		bizcochuelo.agregarIngredienteAlPlato("trigo");
		bizcochuelo.agregarIngredienteAlPlato("huevo");
		bizcochuelo.agregarIngredienteAlPlato("rayadura de limon");
		
		assertFalse(sanatorioDelOeste.buscarPaciente(1002).comer(bizcochuelo));
		assertFalse(sanatorioDelOeste.buscarPaciente(1003).comer(bizcochuelo));
	}
	
	@Test
	public void queUnPacienteConAlgunaRestriccionDeElaboraciomNoPuedaComerUnPlatoQueHayaSidoElaboradoDeEsaForma() {
		sanatorioDelOeste.agregarPacienteAlHospital(oncologico);
		
		Plato sushi = new Plato("Sushi hospitalario",Elaboracion.SIN_COCCION);
		sushi.agregarIngredienteAlPlato("pescado");
		sushi.agregarIngredienteAlPlato("sal");
		sushi.agregarIngredienteAlPlato("centeno");
		
		assertFalse(sanatorioDelOeste.buscarPaciente(1001).comer(sushi));
	}
	
	@Test
	public void queSiUnPacienteDiabeticoEsTipo2SePuedaSuministrarLaDosisDeInsulina() {
		Diabetico diabetico_tipo2 = new Diabetico(2002, "Lionel Messi",TipoDeDiabetico.TIPO_2);
		sanatorioDelOeste.agregarPacienteAlHospital(diabetico_tipo2);
		
		assertTrue(sanatorioDelOeste.buscarPaciente(2002).sumnistrarInsulina(diabetico_tipo2));

	}
	
	@Test
	public void queSiUnPacienteDiabeticoEsTipo1NoSePuedaSuministrarLaDosisDeInsulina() {
		Diabetico diabetico_tipo1 = new Diabetico(2003, "Luis Suarez",TipoDeDiabetico.TIPO_1);
		sanatorioDelOeste.agregarPacienteAlHospital(diabetico_tipo1);
		
		assertFalse(sanatorioDelOeste.buscarPaciente(2003).sumnistrarInsulina(diabetico_tipo1));

	}
	
}
