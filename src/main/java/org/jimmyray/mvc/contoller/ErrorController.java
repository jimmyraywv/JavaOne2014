package org.jimmyray.mvc.contoller;

import javax.servlet.http.HttpServletRequest;

import org.jimmyray.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ErrorController.class);

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	//@ResponseBody
	@RequestMapping(value = Constants.MAPPING_404, method = RequestMethod.GET)
	public String show404View(final HttpServletRequest request,
			final ModelMap map) {
		LOGGER.debug("Rendering 404 view");

		map.addAttribute(Constants.KEY_ERROR_404_TITLE,
				Constants.VALUE_ERROR_404_TITLE);
		map.addAttribute(Constants.KEY_ERROR_404_MSG,
				Constants.VALUE_ERROR_404_MSG);

		return Constants.VIEW_404;
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	//@ResponseBody
	@RequestMapping(value = Constants.MAPPING_500, method = RequestMethod.GET)
	public String show500View(final HttpServletRequest request,
			final ModelMap map) {
		LOGGER.debug("Rendering 500 view");

		map.addAttribute(Constants.KEY_ERROR_500_TITLE,
				Constants.VALUE_ERROR_500_TITLE);
		map.addAttribute(Constants.KEY_ERROR_500_MSG,
				Constants.VALUE_ERROR_500_MSG);

		return Constants.VIEW_500;
	}

	/*@RequestMapping(value = Constants.MAPPING_UNCAUGHT, method = RequestMethod.GET)
	public String showErrorView(final HttpServletRequest request,
			final ModelMap map) {
		LOGGER.debug("Rendering unacaught view");

		// TODO finish this
		return Constants.VIEW_UNCAUGHT;
	}*/
}
