package org.agosti.abl.server;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RequestWrapper {

	private static final String URL_PARAMETER = "url";
	private Map<String, Object> parameters;
	
	public RequestWrapper(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	public String getUrl() {
		return getParameterAsString(URL_PARAMETER);
	}

	public List<String> getUrls() {
		return getParameterAsStrings(URL_PARAMETER);
	}
	
	private String getParameterAsString(String parameter) {
		String[] values = (String[])parameters.get(parameter);
		if(values == null) {
			return null;
		}
		String value = values[0];
		return value;
	}

	private List<String> getParameterAsStrings(String parameter) {
		String[] values = (String[])parameters.get(parameter);
		if(values == null) {
			return null;
		}
		String value = values[0];
		return Arrays.asList(value.split("\r\n|\r|\n"));
	}

}