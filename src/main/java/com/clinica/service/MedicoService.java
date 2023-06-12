package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.MedicoRepository;
import com.clinica.entity.Medico;


@Service
public class MedicoService {

	@Autowired
	private MedicoRepository repo;
	
	public void registrar(Medico m) {
		repo.save(m);
	}
	
	public void actualizar(Medico m) {
		repo.save(m);
	}
	
	public Medico buscarPorId(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Medico> listarTodos(){
		return repo.findAll();
	}
}
