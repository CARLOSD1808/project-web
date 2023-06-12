package com.clinica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{

	public List<Medicamento> findByNombreStartingWith(String nom);
}
