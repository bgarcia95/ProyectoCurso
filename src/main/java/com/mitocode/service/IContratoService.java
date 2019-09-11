package com.mitocode.service;

import com.mitocode.model.Contrato;
import com.mitocode.model.Persona;

public interface IContratoService extends IService<Contrato>{

	int getSiguientePK(Persona persona);
}
