package org.agosti.abl.shared.model;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Url {
	
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long id;
	
	@Persistent private String url;
	@Persistent private String domain;
	@Persistent private String host;
	@Persistent private String path;
	@Persistent private String query;	
	@Persistent private String protocol;
	@Persistent private Long token;
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	
	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }
	
	public String getHost() { return host; }
	public void setHost(String host) { this.host = host; }
	
	public String getQuery() { return query; }
	public void setQuery(String query) { this.query = query; }
	
	public String getProtocol() { return protocol; }
	public void setProtocol(String protocol) { this.protocol = protocol; }
	
	public Long getToken() { return token; }
	public void setToken(Long token) { this.token = token; }
	public void addToken() {
		if(this.token == null) {
			this.token = Long.valueOf(1);
		} else {
			this.token++;
		}
	}

	public void setPath(String path) { this.path = path; }
	public String getPath() { return path; }
	
	public void setDomain(String domain) { this.domain = domain; }
	public String getDomain() { return domain; }	
	
	
}
