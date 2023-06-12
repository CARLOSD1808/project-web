package com.clinica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinica.dao.BoletaRepository;
import com.clinica.dao.MedicamentoHasBoletaRepository;
import com.clinica.entity.Boleta;
import com.clinica.entity.MedicamentoHasBoleta;
import com.clinica.entity.MedicamentoHasBoletaPK;

@Service
public class BoletaService {
	
	@Autowired
	private BoletaRepository servicioBol;
	@Autowired 
	private MedicamentoHasBoletaRepository servicioDe;
	
	@Transactional
	public void registrar(Boleta bean) {
		try {
			//grabar boleta"Cabecera--->tb_boleta"
			servicioBol.save(bean);
			//grabar MedicamentoHasBoleta "Detalle --->tb_medicamento_has_boleta"
			//bucle para realizar recorrido sobre el atributo listamedicamentohasboleta del objeto "bean" 
			for(MedicamentoHasBoleta mhb:bean.getListaMedicamentoHasBoleta()) {
				//llave 
				MedicamentoHasBoletaPK pk= new MedicamentoHasBoletaPK();
				//setear
				pk.setCodigoMedicamento(mhb.getMedicamento().getCodigo());
				pk.setNumeroBoleta(bean.getNumeroBoleta());
				//enviar pk al objeto mhb
				mhb.setPk(pk);
				//grabr mhb
				servicioDe.save(mhb);
				
				
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
