package com.lucamartinelli.app.simplesite.servicediscovery.ejb;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;

import com.lucamartinelli.app.simplesite.servicediscovery.vo.ServiceVO;

@Stateless
@LocalBean
public class ServiceDiscoveryEJB {
	
	@Inject
	@ConfigProperty(name = "service.discovery.mode", defaultValue = "IN_MEMORY")
	private String svcDiscoveryMode;
	
	private final Logger log;
	
	public ServiceDiscoveryEJB() {
		log = Logger.getLogger(this.getClass().getCanonicalName());
	}
	
	
	public Set<ServiceVO> getServices(final JsonWebToken jwt) {
		log.fine("Using services discovery in mode: " + svcDiscoveryMode);
		Set<String> roles = jwt.getGroups();
		switch (svcDiscoveryMode) {
		case "IN_MEMORY":
			log.fine("Loading in memory services");
			return getInMemory(roles);
		case "DB":
			log.fine("Loading database stored services");
			throw new RuntimeException("Not implemented yet");
		default:
			throw new RuntimeException("Invalid property [service.discovery.mode] please check value");
		}
	}


	private Set<ServiceVO> getInMemory(final Set<String> roles) {
		Set<ServiceVO> svcs = new HashSet<>();
		for (String r : roles) {
			if (r.equals("dev")) {
				final ServiceVO s = new ServiceVO("Developer Console", 
						"Server and services management console", "no url available");
				svcs.add(s);
			} else if (r.equals("test")) {
				final ServiceVO s = new ServiceVO("Test report portal", 
						"Portal for all test cases", "no url available");
				svcs.add(s);
			}
		}
		log.fine("Loaded [" + svcs.size() + "] service/s");
		return svcs;
	}
	
	
}
