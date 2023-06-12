package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.DistritoRepository;
import com.clinica.entity.Distrito;

@Service
public class DistritoService {

	@Autowired
	private DistritoRepository repo;
	
	public List<Distrito> ListarDistrito(){
		return repo.findAll();
	}
}
