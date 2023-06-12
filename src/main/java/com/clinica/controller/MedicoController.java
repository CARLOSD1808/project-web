package com.clinica.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinica.entity.Distrito;
import com.clinica.entity.Especialidad;
import com.clinica.entity.Medicamento;
import com.clinica.entity.Medico;
import com.clinica.entity.Sede;
import com.clinica.entity.TipoMedicamento;
import com.clinica.service.DistritoService;
import com.clinica.service.EspecialidadService;
import com.clinica.service.MedicoService;
import com.clinica.service.SedeService;

@Controller
@RequestMapping("/medico")
public class MedicoController {

	@Autowired
	private EspecialidadService serEspecialidad;
	
	@Autowired
	private SedeService serSede;
	
	@Autowired
	private DistritoService serDistrito;
	
	@Autowired 
	private MedicoService serMedico;
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("medico", serMedico.listarTodos());
		model.addAttribute("especialidad", serEspecialidad.ListarEspecialidad());
		model.addAttribute("sede", serSede.ListarSede());
		model.addAttribute("distrito", serDistrito.ListarDistrito());
		
		
		return "medico";
	}
	
	//ruta (URL) para grabar medicamento
		@RequestMapping("/grabar")
		public String grabar(@RequestParam("nombre") String nom,
				@RequestParam("apellido") String ape,
				@RequestParam("nacimiento") String nac,
				@RequestParam("sexo") String sex,
				@RequestParam("civil") String civ,
				@RequestParam("dni") String dni,
				@RequestParam("sueldo") double sue,
				@RequestParam("especialidad") Integer codEspe,
				@RequestParam("sede") Integer codSede,
				@RequestParam("distrito") Integer codDistrito,
				@RequestParam("dir") String dir,
				RedirectAttributes redirect) {
			
			try {
				
				//Crear objeto de la entidada Medico
				Medico m = new Medico();
				m.setNombre(nom);
				m.setApellido(ape);
				m.setFec_naci(LocalDate.parse(nac));
				m.setSexo(sex);
				m.setCivil(civ);
				m.setDni(dni);
				m.setSueldo(sue);
				m.setDireccion(dir);
				//Crear objeto de la entidad Especialidad, Sede, Distrito
				Especialidad es = new Especialidad();
				es.setCodigo(codEspe);
				
				Sede se= new Sede();
				se.setCodigo(codSede);
				
				Distrito dis= new Distrito();
				dis.setCodigo(codDistrito);
				
				//Enviar objeto "tm" dentro del objeto "med" invocar al mpetodo setTipo
				m.setEspecialidad(es);
				m.setSede(se);
				m.setDistrito(dis);
				serMedico.registrar(m);
				
				//Enviar atributo
				redirect.addFlashAttribute("Mensaje","Medicamento registrado");
				
				
			} catch (Exception e) {
				redirect.addFlashAttribute("Mensaje","Error en el registro");
				e.printStackTrace();
			}
			
			return "redirect:/medico/lista";
		}
	
}
