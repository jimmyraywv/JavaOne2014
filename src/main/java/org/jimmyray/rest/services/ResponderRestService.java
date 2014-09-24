package org.jimmyray.rest.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jimmyray.services.ResponderService;
import org.jimmyray.util.Constants;
import org.jimmyray.util.spring.SpringBeanFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/responder")
public class ResponderRestService {

	// @Autowired
	private ResponderService responderService = (ResponderService) SpringBeanFactory
			.getBean(Constants.RESPONDER_SERVICE_BEAN);

	@GET
	@Path("/{parm}")
	@Consumes(Constants.MEDIA_TYPE_TEXT_PLAIN)
	@Produces(Constants.MEDIA_TYPE_TEXT_PLAIN)
	public Response respond(@PathParam("parm") String request) {

		String response = responderService.respond(request);

		return Response.status(200).entity(response).build();
	}

}
