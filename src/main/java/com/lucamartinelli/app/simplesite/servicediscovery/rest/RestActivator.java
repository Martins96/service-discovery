package com.lucamartinelli.app.simplesite.servicediscovery.rest;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@ApplicationPath("/api")
@LoginConfig(authMethod = "MP-JWT", realmName = "simplesite-realm")
@DeclareRoles({"dev", "test"})
public class RestActivator extends Application {
	
}
