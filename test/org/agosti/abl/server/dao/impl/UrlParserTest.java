package org.agosti.abl.server.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.agosti.abl.shared.model.Url;
import org.junit.Test;

public class UrlParserTest {
	
	@Test
	public void shouldPrepareAUrl() {
		Url url = UrlParser.createUrl("http://www.google.com/path?query=x");
		assertEquals("www.google.com", url.getHost());
		assertEquals("/path", url.getPath());
		assertEquals("http", url.getProtocol());
		assertEquals("query=x", url.getQuery());
		assertEquals("http://www.google.com/path?query=x", url.getUrl());
		assertEquals("google.com", url.getDomain());
	}

	@Test
	public void shouldPrepareAUrlDifferentCase() {
		Url url = UrlParser.createUrl("http://google.com/path");
		assertEquals("google.com", url.getHost());
		assertEquals("/path", url.getPath());
		assertEquals("http", url.getProtocol());
		assertNull(url.getQuery());
		assertEquals("http://google.com/path", url.getUrl());
		assertEquals("google.com", url.getDomain());
	}

	@Test
	public void shouldPrepareAUrlWithtwosuffix() {
		Url url = UrlParser.createUrl("http://google.co.uk/path");
		assertEquals("google.co.uk", url.getHost());
		assertEquals("/path", url.getPath());
		assertEquals("http", url.getProtocol());
		assertNull(url.getQuery());
		assertEquals("http://google.co.uk/path", url.getUrl());
		assertEquals("google.co.uk", url.getDomain());
	}

	@Test
	public void shouldPrepareUrl() {
		Url url = UrlParser.createUrl("http://google.co.uk");
		assertEquals("google.co.uk", url.getHost());
		assertEquals("", url.getPath());
		assertEquals("http", url.getProtocol());
		assertNull(url.getQuery());
		assertEquals("http://google.co.uk", url.getUrl());
		assertEquals("google.co.uk", url.getDomain());
	}

	@Test
	public void shouldPrepareAUrlWithoutProtocolAndPrefix() {
		Url url = UrlParser.createUrl("google.co.uk");
		assertEquals("google.co.uk", url.getHost());
		assertEquals("google.co.uk", url.getDomain());
	}

	@Test
	public void shouldPrepareAUrlWithoutProtocol() {
		Url url = UrlParser.createUrl("www.google.co.uk");
		assertEquals("www.google.co.uk", url.getHost());
		assertEquals("google.co.uk", url.getDomain());
	}

}
