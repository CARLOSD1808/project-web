package com.clinica.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.clinica.entity.Medicamento;
import com.clinica.entity.TipoMedicamento;
import com.clinica.service.LaboratorioServices;
import com.clinica.service.MedicamentoService;
import com.clinica.service.TipoService;

@Controller
@RequestMapping("/medicamento")// ruta (URL) para acceder a MedicamentoController
public class MedicamentoController {
	
	//Inyectar los servicios "TipoService y MedicamentoSevice"
	@Autowired
	private TipoService serTipo;
	
	@Autowired
	private MedicamentoService serMedicamento;
	
	@Autowired 
	private LaboratorioServices serLaboratorio;
	
	//Ruta (URL) para listar todos los medicamentos
	@RequestMapping("/lista")
	public String lista(Model model) {			//Model importado de la Interfaz model
		model.addAttribute("medicamento", serMedicamento.listarTodos());
		model.addAttribute("laboratorios", serLaboratorio.listarTipos());
		
		return "medicamento";
	
	}
	
	//ruta (URL) para grabar medicamento
	@RequestMapping("/grabar")
	public String grabar(
			@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,
			@RequestParam("descripcion") String des,
			@RequestParam("stock") Integer sto,
			@RequestParam("precio") double pre,
			@RequestParam("vencimiento") String venc,
			@RequestParam("tipo") Integer codTipo,
			RedirectAttributes redirect) {
		
		try {
			
			//Crear objeto de la entidada Medicamento
			Medicamento m = new Medicamento();
			m.setDescripcion(des);
			m.setNombre(nom);
			m.setPrecio(pre);
			m.setStock(sto);
			m.setFecha(LocalDate.parse(venc));
			//Crear objeto de la entidad tipoMedicamento
			TipoMedicamento tm = new TipoMedicamento();
			tm.setCodigo(codTipo);
			//Enviar objeto "tm" dentro del objeto "med" invocar al mpetodo setTipo
			m.setTipo(tm);
			
			if(cod==0) {
				serMedicamento.registrar(m);
				
				//Enviar atributo
				redirect.addFlashAttribute("Mensaje","Medicamento registrado");
			}else {
				m.setCodigo(cod);
				serMedicamento.actualizar(m);
				redirect.addFlashAttribute("Mensaje", "Medicamento actualizado");
			}
			
			
			
			
		} catch (Exception e) {
			redirect.addFlashAttribute("Mensaje","Error en el registro");
			e.printStackTrace();
		}
		
		return "redirect:/medicamento/lista";
	}
	
	//ruta (URL) para buscar un Medicamento según su codigo
	//Dicha ruta retorna un JSON
	@RequestMapping("/buscar")
	@ResponseBody //Anotación para devolver un JSON en objeto
	public Medicamento buscarPorCodigo(@RequestParam("codigo") Integer cod) {
		return serMedicamento.buscarPorId(cod);
	}
	
	//ruta (URL) para eliminar un Medicamento segun su codigo
	@RequestMapping("/eliminar")
	public String eliminarPorCodigo(@RequestParam("codigoEliminar") Integer cod,
										RedirectAttributes redirect) {
		serMedicamento.eliminarPorID(cod);
		redirect.addFlashAttribute("Mensaje","Medicamento eliminado");
		return "redirect:/medicamento/lista";
	}
	
	//ruta (URL) para LISTAR UN arreglo de la entidad TipoMedicamento según 
	//su codigo de laboratorio, dicha ruta retorna un JSON
	@RequestMapping("/listarTipos")
	@ResponseBody //Anotación para devolver un JSON en objeto
	public List<TipoMedicamento> listarPorLaboratorio(@RequestParam("codigo") Integer cod) {
		return serTipo.findAllTiposPorLaboratorio(cod);
	}
}













