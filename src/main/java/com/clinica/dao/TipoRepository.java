package com.clinica.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinica.entity.TipoMedicamento;

public interface TipoRepository extends JpaRepository<TipoMedicamento, Integer> {
	
	//Select * from tb_tipo_Medicamento where cod_lab=1
	@Query("select tm from TipoMedicamento tm where tm.laboratorio.codigo=?1")
	public List<TipoMedicamento> listaTiposPorLaboratorio(Integer codLab);
}
