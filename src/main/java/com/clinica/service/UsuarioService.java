package com.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinica.dao.UsuarioRepository;
import com.clinica.entity.Enlace;
import com.clinica.entity.Usuario;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario loginUsuario(String vLogin){
		return repo.iniciarSesion(vLogin);
	}
	public List<Enlace> enlacesDelUsuario(int rol){
		return repo.traerEnlacesDElUsuario(rol);
	}
}





