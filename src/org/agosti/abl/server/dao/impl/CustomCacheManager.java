package org.agosti.abl.server.dao.impl;

import java.util.Collections;
import java.util.List;

import org.agosti.abl.shared.model.Url;

import net.sf.jsr107cache.Cache;
import net.sf.jsr107cache.CacheException;
import net.sf.jsr107cache.CacheManager;

public class CustomCacheManager {
	
	private Cache cache;
	private static final String URLS_KEY = "urlsKey";
	
	public CustomCacheManager() {
		try {
	        cache = CacheManager.getInstance().getCacheFactory().createCache(Collections.emptyMap());
	        cache.clear();
	    } catch (CacheException e) {
	        throw new RuntimeException("Impossible to get the cache from the manager");
	    }
	}
	
	public void expireUrls() {
		cache.remove(URLS_KEY);
	}

	@SuppressWarnings("unchecked")
	public List<Url> getUrls() {
		return (List<Url>)cache.get(URLS_KEY);
	}

	public void setUrls(List<Url> urls) {
		cache.put(URLS_KEY, urls);
	}

}
