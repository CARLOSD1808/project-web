package com.clinica.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
@Table(name = "tb_cliente")

public class Cliente implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cli")
	private int codigo;
	@Column(name = "nom_cli")
	private String nombre;
	@Column(name = "pat_cli")
	private String paterno;
	@Column(name = "mat_cli")
	private String materno;
	@Column(name = "sex_cli")
	private String sexo;
	@Column(name = "dni_cli")
	private int dni;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fec_nac_cli")
	private Date fechaNacimiento;
	@Column(name = "cel_cli")
	private int celular;
	@Column(name = "dir_cli")
	private String direccion;
	@Column(name = "cod_dis")
	private int distrito;

	
	//Relación UNO a MUCHOS "Boleta"
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<Boleta> listaBoletas;
	
	
	

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPaterno() {
		return paterno;
	}


	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}


	public String getMaterno() {
		return materno;
	}


	public void setMaterno(String materno) {
		this.materno = materno;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getDistrito() {
		return distrito;
	}


	public void setDistrito(int distrito) {
		this.distrito = distrito;
	}


	public List<Boleta> getListaBoletas() {
		return listaBoletas;
	}


	public void setListaBoletas(List<Boleta> listaBoletas) {
		this.listaBoletas = listaBoletas;
	}
	
	
	
}

