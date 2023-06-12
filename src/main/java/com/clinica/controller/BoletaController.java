package com.clinica.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.clinica.entity.Boleta;
import com.clinica.entity.Cliente;
import com.clinica.entity.Detalle;
import com.clinica.entity.Medicamento;
import com.clinica.entity.MedicamentoHasBoleta;
import com.clinica.entity.Usuario;
import com.clinica.service.BoletaService;
import com.clinica.service.ClienteService;
import com.clinica.service.MedicamentoService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/boleta")
public class BoletaController {
	@Autowired
	private ClienteService serCliente;
	@Autowired
	private MedicamentoService serMedicamento;
	@Autowired
	private BoletaService serBoleta;
	
	@RequestMapping("/lista")
	public String lista(Model model){
		model.addAttribute("listaClientes",serCliente.listaClientes(""));
		return "boleta";
	}
	
	@RequestMapping("/listaJSON")
	@ResponseBody
	public List<Cliente> listaJSON(@RequestParam("apellido") String ape){
		return serCliente.listaClientes(ape);
	}
	@RequestMapping("/listaMedicamentoJSON")
	@ResponseBody
	public List<Medicamento> listaMedicamentoJSON(@RequestParam("nombre") String nom){
		
		
		return serMedicamento.listarMedicamentosPorNombre(nom);
	}
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,
							@RequestParam("descripcion") String des,
							@RequestParam("precio") double pre,
							@RequestParam("cantidad") int can,HttpSession session){
		//declarar un arreglo de objetos de la clase Detalle
		List<Detalle> lista=null;
		try {
			//validar si existe el atributo de tipo sesión "data"
			if(session.getAttribute("data")==null)//no existe atributo "data"
				//crear arreglo "lista"
				lista=new ArrayList<Detalle>();
			else//existe atributo "data"
				//recuperar el atributo "data" y guardar su contenido en "lista"
				lista=(List<Detalle>) session.getAttribute("data");
				//crear objeto de la clase Detalle
				Detalle det=new Detalle();
				//setear atibutos del objeto "det" con los valores de los parámetros
				det.setCodigo(cod);
				det.setDescripcion(des);
				det.setPrecio(pre);
				det.setCantidad(can);
				//adicionar objeto "det" dentro del arreglo "lista"
				lista.add(det);
			//crear atributo de tipo sesión "data"
			session.setAttribute("data", lista);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("cliente") String clie,
						 @RequestParam("fecha")String fec,
						 @SessionAttribute("CODIGO_USUARIO")int cod,
						 HttpSession session) {
		
		
		try {
			//
			Boleta bol=new Boleta();
			//setear
			bol.setMonto(155.50);
			bol.setFechaEmision(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			//crear usuario
			Usuario u = new Usuario();
			u.setCodigo(cod);
			//adicionar objeto "u" dentro de "bol"
			bol.setUsuario(u);
			//parametro clie =>2.Rivera Iglesias Alicia
			String sep[]=clie.split("-");
			//crear objeto de la entidad cliente
			Cliente c=new Cliente();
			c.setCodigo(Integer.parseInt(sep[0]));
			bol.setCliente(c);
			//detalle
			//crear un arreglo de objetos de la entidad MedicamentoHasBoleta
			List<MedicamentoHasBoleta> lista=new ArrayList<MedicamentoHasBoleta>();
			//recuperar el atributo de tipo sesion "data"
			List<Detalle> datos = (List<Detalle>) session.getAttribute("data");
			//bucle para realizar recorrido sobre "datos"
			for(Detalle det:datos) {
				//crear objeto de la entidad MedicamentoHasBoleta
				MedicamentoHasBoleta mhb=new MedicamentoHasBoleta();
				//crear objeto de la entidad Medicamento
				Medicamento m = new Medicamento();
				m.setCodigo(det.getCodigo());
				//enviar objeto "m" al objeto "mhb"
				mhb.setMedicamento(m);
				mhb.setPrecio(det.getPrecio());
				//enviar el objeto "mhb" al arreglo "lista"
				lista.add(mhb);
			}
			//enviar el arreglo al atributo "listaMedicamentoHasBoleta"
			bol.setListaMedicamentoHasBoleta(lista);
			serBoleta.registrar(bol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/boleta/lista";
	}
	
}







