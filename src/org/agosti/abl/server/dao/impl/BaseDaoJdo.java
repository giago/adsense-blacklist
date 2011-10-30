package org.agosti.abl.server.dao.impl;

import javax.jdo.PersistenceManager;

import org.agosti.abl.server.dao.PMF;

public class BaseDaoJdo {
	
	protected CustomCacheManager cacheManager = new CustomCacheManager();

	protected PersistenceManager getPM() {
		return PMF.get().getPersistenceManager();
	}
	
}
