package com.mitocode.dao;

import java.util.List;

import javax.ejb.Local;

import com.mitocode.model.Persona;

@Local
public interface IPersonaDAO extends IDAO<Persona>{

	void listarWS();
		
}

