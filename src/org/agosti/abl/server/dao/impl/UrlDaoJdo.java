package org.agosti.abl.server.dao.impl;

import java.util.List;

import javax.jdo.JDOOptimisticVerificationException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.agosti.abl.server.dao.UrlDao;
import org.agosti.abl.shared.model.Url;


public class UrlDaoJdo extends BaseDaoJdo implements UrlDao {

	@Override
	public void add(List<String> urls) {
		if(urls == null) {
			return;
		}
		for(String url : urls) {
			if(url != null) {
				url = url.trim();
				if(!"".equals(url)) {
					add(url);
				}
			}
		}
	}
	
	@Override
	public void add(String urlString) {
		PersistenceManager pm = getPM();
		pm.currentTransaction().begin();
	    try {
	    	Url url = getUrl(pm, urlString);
	    	if(url != null) {
	    		url.addToken();
	    		pm.makePersistent(url);
	    	} else {
	    		url = UrlParser.createUrl(urlString);
	    		pm.makePersistent(url);
	    	}
	    	pm.currentTransaction().commit();
	    } catch (JDOOptimisticVerificationException e) {
	    	throw new RuntimeException("JDOOptimisticVerificationException", e);
	    } finally {      
	    	cacheManager.expireUrls();
	        if (pm.currentTransaction().isActive()) {
	            pm.currentTransaction().rollback();
	        }
	        pm.close();
	    }
	}

	@Override
	public List<Url> getUrls() {
		PersistenceManager pm = getPM();
		Query q = pm.newQuery(Url.class);
		List<Url> results = (List<Url>)q.execute();
		return results;
	}
	
	private Url getUrl(PersistenceManager pm, String url) {	
		Query query = pm.newQuery(Url.class);
		query.setFilter("url == '" + url + "'");
		List<Url> result = (List<Url>)query.execute();
    	if(result == null || result.isEmpty()) {
    		return null;
    	} else {
    		return result.get(0);
    	}
	}
		
}
