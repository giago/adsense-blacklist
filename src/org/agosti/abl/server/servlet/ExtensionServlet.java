package org.agosti.abl.server.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.agosti.abl.server.RequestWrapper;
import org.agosti.abl.server.dao.UrlDao;
import org.agosti.abl.server.dao.impl.UrlDaoJdo;

import java.util.logging.Logger;

public class ExtensionServlet extends HttpServlet {
	
	private static final Logger logger = Logger.getLogger(ExtensionServlet.class.getName());
	private static final long serialVersionUID = 1L;

	private UrlDao dao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		dao = new UrlDaoJdo();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAndPost(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getAndPost(req, resp);
	}
	
	private void getAndPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processWrapper(req, resp);
		} catch (Exception e) {
			logger.warning("Problem wrapping the request " + e.getMessage());
			throw new ServletException(e);
		}
	}
	
	private void processWrapper(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		@SuppressWarnings("unchecked")
		RequestWrapper rw = new RequestWrapper(req.getParameterMap());
		dao.add(rw.getUrls());
		getServletContext().getRequestDispatcher("/submit.jsp").forward(req, resp);
	}


}
