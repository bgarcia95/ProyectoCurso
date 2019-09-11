package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Funcion;
import com.mitocode.model.Puesto;

public interface IFuncionService  {

	public List<Funcion> listar(Puesto p) throws Exception;
}
