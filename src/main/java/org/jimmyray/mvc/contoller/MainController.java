package org.jimmyray.mvc.contoller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jimmyray.services.SystemInfoService;
import org.jimmyray.util.Constants;
import org.jimmyray.util.Properties;
import org.jimmyray.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("memory")
public class MainController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MainController.class);
	
	static {
		LOGGER.debug("Loaded Main Controller");
	}

	@Autowired
	private SystemInfoService systemInfoService;

	@RequestMapping(method = RequestMethod.GET, value = "/echo")
	public String echoView(final HttpServletRequest request, final ModelMap map) {
		LOGGER.debug("Reached echo mapping.");

		final String parm = request.getParameter("echo");
		map.addAttribute("echo", Strings.nullValue(parm, "Nothing to Echo!!"));

		return "echo";
	}

	@RequestMapping(value = "/remember", method = RequestMethod.POST)
	public ModelAndView remember(@RequestParam String memory) {
		LOGGER.debug("Reached remember POST mapping.");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("memory", memory);
		modelAndView.setViewName("memory");

		return modelAndView;
	}

	@RequestMapping(value = "/remember", method = RequestMethod.GET)
	public ModelAndView memory(final HttpServletRequest request) {
		LOGGER.debug("Reached remember GET mapping.");

		ModelAndView modelAndView = new ModelAndView();
		String memory = Strings.nullValue(
				request.getSession().getAttribute("memory"), "");
		modelAndView.addObject("memory", memory);
		modelAndView.setViewName("memory");

		return modelAndView;
	}

	@RequestMapping(value = "/throw", method = RequestMethod.GET)
	public void throwError(final HttpServletRequest request) throws Exception {
		LOGGER.debug("Reached throw GET mapping.");

		throw new Exception("TEST_EXCEPTION");
	}

	@RequestMapping(value = "/system", method = RequestMethod.GET)
	public ModelAndView getSystemInfo(final HttpServletRequest request) {
		LOGGER.debug("Reached system GET mapping.");

		ModelAndView modelAndView = new ModelAndView();

		Map<String, Object> result = this.systemInfoService.getSystemInfo();

		modelAndView.addObject(Constants.JVM_ARGS,
				result.get(Constants.JVM_ARGS));
		modelAndView.addObject(Constants.SYSTEM_PROPS,
				result.get(Constants.SYSTEM_PROPS));
		modelAndView.addObject(Constants.OTHER_PROPS,
				result.get(Constants.OTHER_PROPS));
		
		modelAndView.setViewName("systemInfo");

		return modelAndView;
	}

	@RequestMapping(value = "/appProps", method = RequestMethod.GET)
	public ModelAndView getAppProps(final HttpServletRequest request)
			throws Exception {
		LOGGER.debug("Reached appProps GET mapping.");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("applicationBuilder",
				Properties.getString("application.builder"));
		modelAndView.addObject("applicationBuildDateTime",
				Properties.getString("application.buildDateTime"));
		modelAndView.addObject("applicationVersion",
				Properties.getString("application.version"));
		modelAndView.setViewName("appProps");

		LOGGER.debug(Properties.getString("application.builder"));
		LOGGER.debug(Properties.getString("application.buildDateTime"));
		LOGGER.debug(Properties.getString("application.version"));

		return modelAndView;
	}

}
