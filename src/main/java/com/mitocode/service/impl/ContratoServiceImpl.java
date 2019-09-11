package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IContratoDAO;
import com.mitocode.model.Contrato;
import com.mitocode.model.Persona;
import com.mitocode.service.IContratoService;

@Named
public class ContratoServiceImpl implements IContratoService, Serializable {

	@EJB
	private IContratoDAO dao;

	@Override
	public void registrar(Contrato t) throws Exception {		
		dao.registrar(t);
	}

	@Override
	public void modificar(Contrato t) throws Exception {
		dao.modificar(t);
	}

	@Override
	public List<Contrato> listar() throws Exception {		
		return dao.listar();
	}

	@Override
	public Contrato listarPorId(Contrato t) throws Exception {
		return dao.listarPorId(t);
	}

	@Override
	public int getSiguientePK(Persona persona) {		
		return dao.getSiguientePK(persona);
	}
}
