package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IPuestoDAO;
import com.mitocode.model.Puesto;
import com.mitocode.service.IPuestoService;

@Named
public class PuestoServiceImpl implements IPuestoService, Serializable{

	@EJB
	private IPuestoDAO dao;

	@Override
	public void registrar(Puesto t) throws Exception {
		dao.registrar(t);		
	}

	@Override
	public void modificar(Puesto t) throws Exception {
		dao.modificar(t);		
	}

	@Override
	public List<Puesto> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Puesto listarPorId(Puesto t) throws Exception {		
		return dao.listarPorId(t);
	}	
}
