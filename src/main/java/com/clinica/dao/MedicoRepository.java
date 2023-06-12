package com.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinica.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
