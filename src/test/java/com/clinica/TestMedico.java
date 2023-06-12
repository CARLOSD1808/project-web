package com.clinica;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clinica.entity.Especialidad;
import com.clinica.entity.Medicamento;
import com.clinica.entity.Medico;
import com.clinica.entity.TipoMedicamento;
import com.clinica.service.MedicamentoService;
import com.clinica.service.MedicoService;

@SpringBootTest
class TestMedico {
	@Autowired
	private MedicoService servicio;
	
	@Test
	void contextLoads() {
		//Crear objeto de la entidada Medico
		Medico m = new Medico();
		m.setNombre("prueba");
		m.setApellido("Apeprueba");
		m.setSexo("Masculino");
		m.setFec_naci(LocalDate.parse("2023-03-04"));
		//Crear objeto de la entidad tipoMedicamento
		Especialidad es = new Especialidad();
		es.setCodigo(1);
		//Enviar objeto "tm" dentro del objeto "med" invocar al mpetodo setTipo
		m.setEspecialidad(es);
		servicio.registrar(m);
	}

}
