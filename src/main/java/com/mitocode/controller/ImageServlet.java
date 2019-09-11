package com.mitocode.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@WebServlet("/imagen/*")
public class ImageServlet extends HttpServlet {

	@Inject
	private IPersonaService service;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getPathInfo().substring(1));
		Persona per = new Persona();
		per.setIdPersona(id);
		try {
			per = service.listarPorId(per);
			resp.setContentType(getServletContext().getMimeType(per.getApellidos()));
			resp.setContentLength(per.getFoto().length);
			resp.getOutputStream().write(per.getFoto());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
