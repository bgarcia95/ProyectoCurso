package com.mitocode.dao;

import javax.ejb.Local;

import com.mitocode.model.Contrato;
import com.mitocode.model.Persona;

@Local
public interface IContratoDAO extends IDAO<Contrato>{

	int getSiguientePK(Persona persona);
}
