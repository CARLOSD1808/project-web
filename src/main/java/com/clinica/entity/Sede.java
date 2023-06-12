package com.clinica.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_sede")
public class Sede {
	@Id
	@Column(name="cod_sede")
	private Integer codigo;
	
	@Column(name="nom_sede")
	private String nombre;
	
	@OneToMany(mappedBy = "sede")
	private List<Medico> listaMedicos;

	//****************************
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}
	
	
	
	
	
	
}
