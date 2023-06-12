package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.ClienteRepository;
import com.clinica.entity.Cliente;
import com.clinica.entity.TipoMedicamento;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> listaClientes(String ape){
		return repo.findByPaternoStartingWith(ape);
	}
}
