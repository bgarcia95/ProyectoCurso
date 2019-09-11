package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IFuncionDAO;
import com.mitocode.model.Funcion;
import com.mitocode.model.Puesto;

@Stateless
public class FuncionDAOImpl implements IFuncionDAO, Serializable{

	@PersistenceContext(unitName = "PersonalPU")
	private EntityManager em;
	
	@Override
	public List<Funcion> listar(Puesto p) throws Exception {
		List<Funcion> lista = null;
		Query query = em.createQuery("FROM Funcion f where f.puesto.idPuesto = ?1");
		query.setParameter(1, p.getIdPuesto());
		
		lista = (List<Funcion>)query.getResultList();
		return lista;
	}

}
