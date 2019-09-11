package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Named
@RequestScoped
public class PersonaServiceImpl implements IPersonaService, Serializable{

	//@Inject
	@EJB
	private IPersonaDAO dao;

	@Override
	public void registrar(Persona t) throws Exception {
		dao.registrar(t);
		
	}

	@Override
	public void modificar(Persona t) throws Exception {
		dao.modificar(t);	
	}

	@Override
	public List<Persona> listar() throws Exception {		
		return dao.listar();
	}

	@Override
	public Persona listarPorId(Persona t) throws Exception {
		return dao.listarPorId(t);
	}
	

}
