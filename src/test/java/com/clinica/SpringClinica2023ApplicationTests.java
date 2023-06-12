package com.clinica;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.clinica.entity.Medicamento;
import com.clinica.entity.TipoMedicamento;
import com.clinica.service.MedicamentoService;

@SpringBootTest
class SpringClinica2023ApplicationTests {
	@Autowired
	private MedicamentoService servicio;
	
	@Test
	void contextLoads() {
		//Crear objeto de la entidada Medicamento
		Medicamento m = new Medicamento();
		m.setDescripcion("prueba");
		m.setNombre("Paracetamol");
		m.setPrecio(6.3);
		m.setStock(60);
		m.setFecha(LocalDate.parse("2023-03-04"));
		//Crear objeto de la entidad tipoMedicamento
		TipoMedicamento tm = new TipoMedicamento();
		tm.setCodigo(3);
		//Enviar objeto "tm" dentro del objeto "med" invocar al mpetodo setTipo
		m.setTipo(tm);
		servicio.registrar(m);
	}

}
