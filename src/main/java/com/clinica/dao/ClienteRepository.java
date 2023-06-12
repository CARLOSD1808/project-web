package com.clinica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	//Select * from tb_cliente where pat_cli=1
		//@Query("select c from Cliente c where c.paterno like ?1%")
		//public List<Cliente> listaClientesPorApe(String ape);
	
	public List<Cliente> findByPaternoStartingWith(String ape);
}
