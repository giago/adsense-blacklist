package org.agosti.abl.server.dao;

import java.util.List;

import org.agosti.abl.shared.model.Url;

public interface UrlDao {
	
	void add(String url);

	void add(List<String> urls);
	
	List<Url> getUrls();
	
}
