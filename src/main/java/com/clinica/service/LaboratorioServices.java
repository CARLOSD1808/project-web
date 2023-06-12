package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.LaboratorioRepository;
import com.clinica.dao.TipoRepository;
import com.clinica.entity.Laboratorio;
import com.clinica.entity.TipoMedicamento;

@Service
public class LaboratorioServices {
	@Autowired
	private LaboratorioRepository repo;
	
	public List<Laboratorio> listarTipos(){
		return repo.findAll();
	}
	

}
