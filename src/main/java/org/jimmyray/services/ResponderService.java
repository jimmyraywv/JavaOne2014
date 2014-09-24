package org.jimmyray.services;

import org.jimmyray.config.annotations.BeanName;

@BeanName(id = "responderService", name = "responderService")
public interface ResponderService {

	String respond(String request);

}
