package com.mitocode.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.mitocode.model.Contrato;
import com.mitocode.model.Persona;
import com.mitocode.model.Puesto;
import com.mitocode.service.IContratoService;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.IPuestoService;

@Named
@ViewScoped
public class ContratoBean implements Serializable {

	@Inject
	private Contrato contrato;
	@Inject
	private Persona persona;
	@Inject
	private Puesto puesto;
	@Inject
	private IPuestoService puestoService;
	@Inject
	private IPersonaService personaService;
	@Inject
	private IContratoService contratoService;
	private List<Persona> lstPersonas;
	private List<Puesto> lstPuestos;
	private List<Contrato> lstContratos;

	@PostConstruct
	public void init() {
		this.listarPersonas();
		this.listarPuestos();
		this.listarContratos();
	}

	public void listarPersonas() {
		try {
			this.lstPersonas = personaService.listar();
		} catch (Exception e) {

		}
	}

	public void listarPuestos() {
		try {
			this.lstPuestos = puestoService.listar();
		} catch (Exception e) {

		}
	}
	
	public void listarContratos() {
		try {
			this.lstContratos = contratoService.listar();
		} catch (Exception e) {

		}
	}
	
	public void seleccionar(Contrato cont) throws Exception {
		contrato = contratoService.listarPorId(cont);
		this.persona = contrato.getPersona();
		this.puesto = contrato.getPuesto();
	}

	public void registrar() {
		try {
			contrato.setIdContrato(contratoService.getSiguientePK(persona));
			contrato.setPersona(persona);
			contrato.setPuesto(puesto);
			contratoService.registrar(contrato);
		} catch (Exception e) {

		}
	}
	
	public void limpiarControles() {
		this.contrato.setSalario(0.0);
		this.contrato.setPuesto(null);
		this.contrato.setPersona(null);
		this.contrato.setFechaInicio(null);
		this.contrato.setFechaFin(null);
		this.contrato.setEstado("1");
		this.persona = null;
		this.puesto = null;
	}

	/**
	 * getters & setters
	 */

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Puesto getPuesto() {
		return puesto;
	}

	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Puesto> getLstPuestos() {
		return lstPuestos;
	}

	public void setLstPuestos(List<Puesto> lstPuestos) {
		this.lstPuestos = lstPuestos;
	}

	public List<Contrato> getLstContratos() {
		return lstContratos;
	}

	public void setLstContratos(List<Contrato> lstContratos) {
		this.lstContratos = lstContratos;
	}

}
