package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IFuncionDAO;
import com.mitocode.model.Funcion;
import com.mitocode.model.Puesto;
import com.mitocode.service.IFuncionService;

@Named
public class FuncionServiceImpl implements IFuncionService, Serializable {

	@EJB
	private IFuncionDAO dao;

	@Override
	public List<Funcion> listar(Puesto p) throws Exception {
		return dao.listar(p);
	}
}
