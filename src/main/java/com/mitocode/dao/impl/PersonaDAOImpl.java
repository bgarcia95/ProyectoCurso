package com.mitocode.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

//@Named
//@RequestScoped
@Stateless
public class PersonaDAOImpl implements IPersonaDAO, Serializable {

	
	@PersistenceContext(unitName = "PersonalPU")
	private EntityManager em;
	
	//@PersistenceContext(unitName = "PersonalMySQLPU")
	//private EntityManager em2;
	//EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonalPU");
	//EntityManager em = emf.createEntityManager();

	@Override
	public void registrar(Persona per) throws Exception {
		try {
			//em.getTransaction().begin();
			em.persist(per);
			//em.getTransaction().commit();
		} catch (Exception e) {
			/*if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}*/
		}finally{
			//em.close();
			//emf.close();
		}
		// System.out.println("registrando...");
	}

	@Override
	public void modificar(Persona per) throws Exception {
		em.merge(per);

	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> lista = null;
		
		try{
			Query query = em.createQuery("FROM Persona p");
			lista = (List<Persona>)query.getResultList();			
		}catch(Exception e){
			throw e;
		}finally{
			//em.close();
			//emf.close();			
		}
		return lista;
	}

	@Override
	public Persona listarPorId(Persona persona) throws Exception {
		Persona per = new Persona();
		List<Persona> lista = new ArrayList<>();
		try{
			//em.find(Persona.class, persona);			
			Query query = em.createQuery("FROM Persona p where p.idPersona = ?1");
			query.setParameter(1, persona.getIdPersona());
			
			lista = (List<Persona>) query.getResultList();
			
			if(lista != null && !lista.isEmpty()){
				per = lista.get(0);
			}
		}catch(Exception e){
			throw e;
		}			
		return per;
	}

	@Override
	public void listarWS() {
		// TODO Auto-generated method stub		
	}

}
