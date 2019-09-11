package com.mitocode.dao;

import java.util.List;

import javax.ejb.Local;

import com.mitocode.model.Funcion;
import com.mitocode.model.Puesto;

@Local
public interface IFuncionDAO {//extends IDAO<Funcion>{
	
	public List<Funcion> listar(Puesto p) throws Exception;
}
