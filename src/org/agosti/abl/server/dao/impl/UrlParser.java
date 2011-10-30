package org.agosti.abl.server.dao.impl;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.agosti.abl.shared.model.Url;

public class UrlParser {
	
	private static final Logger logger = Logger.getLogger(UrlParser.class.getName());
	
	public static final Url createUrl(String urlString) {
		Url url = new Url();
		url.setUrl(urlString);
		URL properUrl;
		try {
			properUrl = new URL(urlString);
			url.setDomain(getDomain(properUrl.getHost()));
			url.setHost(properUrl.getHost());
			url.setQuery(properUrl.getQuery());
			url.setPath(properUrl.getPath());
			url.setProtocol(properUrl.getProtocol());
		} catch (Exception e) {
			logger.warning("problems with the url parsing for " + url + " cause: " + e.getMessage() );
			url.setDomain(getDomain(urlString));
			url.setHost(urlString);
		}
		return url;
	}
	
	public static String getDomain(String host) {
		List<String> strings = Arrays.asList(host.split("\\."));
		if(strings.size() > 2) {
			if("uk".equals(strings.get(strings.size()-1))) {
				return strings.get(strings.size()-3) + "." + strings.get(strings.size()-2) + "." + strings.get(strings.size()-1);			
			} else {
				return strings.get(strings.size()-2) + "." + strings.get(strings.size()-1);
			}
		}
		return host;
	}

}
