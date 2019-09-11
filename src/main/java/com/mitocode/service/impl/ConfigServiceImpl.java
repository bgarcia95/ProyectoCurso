package com.mitocode.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;

import com.mitocode.dao.IConfigDAO;
import com.mitocode.model.Config;
import com.mitocode.service.IConfigService;

@Named
public class ConfigServiceImpl implements IConfigService, Serializable{

	@EJB
	private IConfigDAO dao;
	
	@Override
	public void registrar(Config t) throws Exception {
		dao.registrar(t);		
	}

	@Override
	public void modificar(Config t) throws Exception {
		dao.modificar(t);		
	}

	@Override
	public List<Config> listar() throws Exception {
		return dao.listar();
	}

	@Override
	public Config listarPorId(Config t) throws Exception { 
		return dao.listarPorId(t);
	}

}
