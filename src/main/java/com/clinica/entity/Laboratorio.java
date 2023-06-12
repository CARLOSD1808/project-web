package com.clinica.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_laboratorio")
public class Laboratorio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lab")
	private Integer codigo;
	@Column(name = "nom_lab")
	private String nombre;
	@Column(name= "dir_lab")
	private String Direccion;
	
	//Uno a Muchos
	@OneToMany
	@JsonIgnore //evitar la caida en entidades con llave foranea
	private List<TipoMedicamento> listaTipo;

	
	//Metodos de acceso
	
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

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public List<TipoMedicamento> getListaTipo() {
		return listaTipo;
	}

	public void setListaTipo(List<TipoMedicamento> listaTipo) {
		this.listaTipo = listaTipo;
	}
	
	
	
	
	
	
}
