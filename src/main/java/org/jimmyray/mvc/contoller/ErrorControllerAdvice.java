package org.jimmyray.mvc.contoller;

import org.jimmyray.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorControllerAdvice {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ErrorControllerAdvice.class);

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ModelAndView handleException(Exception e) {
		LOGGER.error(e.getLocalizedMessage());

		ModelAndView modelView = new ModelAndView();
		modelView.setViewName(Constants.VIEW_EXCEPTION);
		modelView.addObject(Constants.KEY_EXCEPTION_TITLE,
				Constants.VALUE_EXCEPTION_TITLE);
		modelView.addObject(Constants.KEY_EXCEPTION_MSG,
				Constants.VALUE_EXCEPTION_MSG);

		return modelView;
	}

}
