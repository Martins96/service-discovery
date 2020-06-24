package com.lucamartinelli.app.simplesite.servicediscovery.rest;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.JsonWebToken;

import com.lucamartinelli.app.simplesite.servicediscovery.ejb.ServiceDiscoveryEJB;
import com.lucamartinelli.app.simplesite.servicediscovery.vo.ServiceVO;

@Path("/services")
public class ServiceDiscoveryService {
	
	@Inject
	@Context
	private JsonWebToken jwt;
	
	@EJB
	ServiceDiscoveryEJB svcEJB;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
	@RolesAllowed({"dev", "test"})
	@Path("/discovery")
	public ServiceVO[] getServices() {
		return svcEJB.getServices(jwt).toArray(new ServiceVO[0]);
	}
	
	
	
	
}
