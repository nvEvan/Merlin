package com.revature.merlineserver.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.ResourceConfig;

public class MerlinAppConfig extends ResourceConfig {
	@Context
	private static ServletContext context;
	
	public MerlinAppConfig() {
		super();
		initContext();
		packages("com.revature.merlinerver.rest");
	}
	
	private void initContext() {
		FilterRegistration filter = context.getFilterRegistration("corsFilter");
		filter.setInitParameter("cors.allowed.origins", "http://localhost:4200");
	}
}
