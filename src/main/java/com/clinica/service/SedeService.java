package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.SedeRepository;
import com.clinica.entity.Sede;

@Service
public class SedeService {

	@Autowired
	private SedeRepository repo;
	
	public List<Sede> ListarSede(){
		return repo.findAll();
	}
}
