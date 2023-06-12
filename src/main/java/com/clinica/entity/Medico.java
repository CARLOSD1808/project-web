package com.clinica.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_Medico")
public class Medico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_med")
	private Integer codigo;
	
	@Column(name="nom_med")
	private String nombre;
	
	@Column (name="ape_med")
	private String apellido;
	
	@Column(name="fec_nac_med")
	private LocalDate fec_naci;
	
	@Column(name="sexo_med")
	private String sexo;
	
	@Column(name="est_civ_med")
	private String civil;
	
	@Column(name="dni_med")
	private String dni;
	
	@Column (name="sue_med")
	private Double sueldo;
	
	@Column(name="dir_emp")
	private String direccion;

	
	//relacion Muchos a Uno
	@ManyToOne
	@JoinColumn(name = "cod_espe")
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "cod_sede")
	private Sede sede;
	
	@ManyToOne
	@JoinColumn(name="cod_dis")
	private Distrito distrito;
	
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFec_naci() {
		return fec_naci;
	}

	public void setFec_naci(LocalDate fec_naci) {
		this.fec_naci = fec_naci;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCivil() {
		return civil;
	}

	public void setCivil(String civil) {
		this.civil = civil;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}
	

	

}
