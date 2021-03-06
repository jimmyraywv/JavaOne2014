package org.jimmyray.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Abstract baseclass for Spring configuration of the properties files
 * 
 * @author Jon Shrader
 */
public class BasePropertiesConfig implements CommonSpringProfiles {

	/** logger for this class. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BasePropertiesConfig.class);

	/** The Constant CLASSPATH_PREFIX. */
	public static final String CLASSPATH_PREFIX = "classpath:/";

	/** The Constant CLASSPATH_CONFIG_PREFIX. */
	public static final String CLASSPATH_CONFIG_PREFIX = CLASSPATH_PREFIX
			+ "config/";

	/** The Constant DASH. */
	public static final String DASH = "-";

	/** The Constant PROPERTIES_FILE_EXT. */
	public static final String PROPERTIES_FILE_EXT = ".properties";

	/**
	 * protected utility class constructor.
	 */
	protected BasePropertiesConfig() {
	}

	/**
	 * AbstractPropertiesEnvironment, parent of all our properties environments.
	 */
	public static class BasePropertiesEnvironment {

		/**
		 * Post construct called after spring initialization completes.
		 */
		@PostConstruct
		public final void postConstruct() {
			LOGGER.info("Loading environment: " + this.getClass().getName());
		}
	}

	/**
	 * properties bean
	 * 
	 * @return the property sources placeholder configurer
	 */
	@Bean
	// jshrader - ignoring DesignForExtension check, we cannot make this spring
	// bean method private or final
	// CHECKSTYLE:OFF
	static PropertySourcesPlaceholderConfigurer properties() {
		// CHECKSTYLE:ON
		return new PropertySourcesPlaceholderConfigurer();
	}

}
