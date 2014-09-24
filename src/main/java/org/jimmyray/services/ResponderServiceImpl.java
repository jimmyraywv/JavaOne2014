package org.jimmyray.services;

import org.jimmyray.util.Constants;
import org.springframework.stereotype.Service;

@Service(Constants.RESPONDER_SERVICE_BEAN)
public class ResponderServiceImpl implements ResponderService {

	public String respond(String request) {
		return Constants.RESPONDER_RESPONSE + request;
	}
}
