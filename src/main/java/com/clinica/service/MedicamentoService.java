package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.MedicamentoRepository;
import com.clinica.entity.Medicamento;

@Service
public class MedicamentoService {
	@Autowired
	private MedicamentoRepository repo;
	
	public void registrar(Medicamento m) {
		repo.save(m);
	}
	
	public void actualizar(Medicamento m) {
		repo.save(m);
	}
	
	public Medicamento buscarPorId(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
	
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	
	public List<Medicamento> listarTodos(){
		return repo.findAll();
	}
	
	public List<Medicamento> listarMedicamentosPorNombre(String nom){
		return repo.findByNombreStartingWith(nom);
	}
	
	
}
