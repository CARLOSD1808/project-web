package com.clinica;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.clinica.entity.Especialidad;
import com.clinica.entity.Medicamento;
import com.clinica.entity.Medico;
import com.clinica.entity.TipoMedicamento;
import com.clinica.service.MedicamentoService;
import com.clinica.service.MedicoService;

@SpringBootTest
class TestUsuario {
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	void contextLoads() {
		System.out.println(encoder.encode("123"));
	}

}
