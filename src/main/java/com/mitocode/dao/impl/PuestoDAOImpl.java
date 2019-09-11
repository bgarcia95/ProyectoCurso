package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IPuestoDAO;
import com.mitocode.model.Puesto;

@Stateless
public class PuestoDAOImpl implements IPuestoDAO, Serializable{

	@PersistenceContext(unitName = "PersonalPU")
	private EntityManager em;
	
	@Override
	public void registrar(Puesto t) throws Exception {
		em.persist(t);
	}

	@Override
	public void modificar(Puesto t) throws Exception {
		em.merge(t);
	}

	@Override
	public List<Puesto> listar() throws Exception {
		List<Puesto> lista = null;
		Query query = em.createQuery("FROM Puesto p");
		lista = (List<Puesto>) query.getResultList();
		return lista;
	}

	@Override
	public Puesto listarPorId(Puesto t) throws Exception {
		Puesto tel = new Puesto();
		List<Puesto> lista = new ArrayList<>();
		Query query = em.createQuery("FROM Puesto p where p.idPuesto = ?1");
		query.setParameter(1, t.getIdPuesto());

		lista = (List<Puesto>) query.getResultList();

		if (lista != null && !lista.isEmpty()) {
			tel = lista.get(0);
		}
		return tel;
	}

}
