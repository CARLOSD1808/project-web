package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.EspecialidadRepository;
import com.clinica.entity.Especialidad;


@Service
public class EspecialidadService {

	@Autowired
	private EspecialidadRepository repo;
	
	public List<Especialidad> ListarEspecialidad(){
		return repo.findAll();
	}
	
}
