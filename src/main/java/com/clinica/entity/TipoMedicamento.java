package com.clinica.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_medicamento")
public class TipoMedicamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tipo")
	private Integer codigo;
	@Column(name = "nom_tipo")
	private String nombre;

	//relacion Uno a Muchos
	@OneToMany(mappedBy = "tipo")
	@JsonIgnore //Anotación para evitar generar JSON del arreglo de objetos listaMedicamento
	private List<Medicamento> listaMedicamento;

	//Relacion Muchos a Uno
	@ManyToOne
	@JoinColumn(name="cod_lab")
	private Laboratorio laboratorio;
	
	//****************************
	
	//Metodos de acceso
	
	public Integer getCodigo() {
		return codigo;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
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

	public List<Medicamento> getListaMedicamento() {
		return listaMedicamento;
	}

	public void setListaMedicamento(List<Medicamento> listaMedicamento) {
		this.listaMedicamento = listaMedicamento;
	}
	
	
	
	
	
	
	
	
}
