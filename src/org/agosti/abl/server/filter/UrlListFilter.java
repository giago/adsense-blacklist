package org.agosti.abl.server.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.agosti.abl.server.dao.UrlDao;
import org.agosti.abl.server.dao.impl.UrlDaoJdo;
import org.agosti.abl.shared.model.Url;


public class UrlListFilter implements Filter {
	
	private UrlDao dao;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		dao = new UrlDaoJdo();
	}
	
	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {	
		request.setAttribute("blackList", getUrls());
        chain.doFilter(request, response);
	}

	private List<Url> getUrls() {
		return dao.getUrls();
	}
	
}
