package org.jimmyray.rest.services;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jimmyray.services.MagicEightBallService;
import org.jimmyray.util.Constants;
import org.jimmyray.util.spring.SpringBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Path("/magic8Ball")
public class MagicEightBallRestService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MagicEightBallRestService.class);

	private MagicEightBallService magicEightBallService = (MagicEightBallService) SpringBeanFactory
			.getBean(Constants.MAGIC_8_BALL_SERVICE_BEAN);

	@GET
	@Path("/ask/{parm}")
	@Consumes(Constants.MEDIA_TYPE_TEXT_PLAIN)
	@Produces(Constants.MEDIA_TYPE_TEXT_PLAIN)
	public Response respond(@PathParam("parm") String request) {

		String response;
		try {
			response = URLDecoder.decode(request, Constants.WWW_FORM_ENCODING)
					+ ":  " + this.magicEightBallService.getPhrase();
		} catch (UnsupportedEncodingException uee) {
			LOGGER.warn(uee.getLocalizedMessage());
			response = Constants.MAGIC_8_BALL_DOWN_MSG;
		} catch (Exception e) {
			LOGGER.warn(e.getLocalizedMessage());
			response = Constants.MAGIC_8_BALL_DOWN_MSG;
		}

		return Response.status(200).entity(response).build();
	}
}
