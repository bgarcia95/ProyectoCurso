package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IContratoDAO;
import com.mitocode.model.Contrato;
import com.mitocode.model.Persona;

@Stateless
public class ContratoDAOImpl implements IContratoDAO, Serializable {

	@PersistenceContext(unitName = "PersonalPU")
	private EntityManager em;

	@Override
	public void registrar(Contrato t) throws Exception {
		em.persist(t);
		Query query = em.createQuery("UPDATE Contrato c SET c.estado = '0' WHERE c.persona.idPersona = ?1 AND c.idContrato <> ?2" );
		query.setParameter(1, t.getPersona().getIdPersona());
		query.setParameter(2, t.getIdContrato());
		query.executeUpdate();
	}

	@Override
	public void modificar(Contrato t) throws Exception {
		em.merge(t);

	}

	@Override
	public List<Contrato> listar() throws Exception {
		List<Contrato> lista = null;
		Query query = em.createQuery("FROM Contrato c"); // where c.estado = '1'
		lista = (List<Contrato>) query.getResultList();
		return lista;
	}

	@Override
	public Contrato listarPorId(Contrato t) throws Exception {
		Contrato tel = new Contrato();
		List<Contrato> lista = new ArrayList<>();
		Query query = em.createQuery("FROM Contrato c where c.idContrato = ?1");
		query.setParameter(1, t.getIdContrato());

		lista = (List<Contrato>) query.getResultList();

		if (lista != null && !lista.isEmpty()) {
			tel = lista.get(0);
		}
		return tel;
	}

	@Override
	public synchronized int getSiguientePK(Persona persona) {
		int siguiente = 0;
		List<Contrato> lista = new ArrayList<>();
		Query query = em.createQuery("FROM Contrato c where c.persona.idPersona = ?1");
		query.setParameter(1, persona.getIdPersona());
		
		lista = (List<Contrato>)query.getResultList();
		
		if(lista != null && !lista.isEmpty()){
			siguiente = lista.get(0).getIdContrato() + 1;
		}else{
			siguiente = 1;
		}
		
		return siguiente;
	}

}
