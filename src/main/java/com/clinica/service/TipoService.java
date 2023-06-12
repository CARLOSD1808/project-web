package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.TipoRepository;
import com.clinica.entity.TipoMedicamento;

@Service
public class TipoService {
	@Autowired
	private TipoRepository repo;
	
	public List<TipoMedicamento> listarTipos(){
		return repo.findAll();
	}
	
	public List<TipoMedicamento> findAllTiposPorLaboratorio(Integer codLab){
		return repo.listaTiposPorLaboratorio(codLab);
	}

}
