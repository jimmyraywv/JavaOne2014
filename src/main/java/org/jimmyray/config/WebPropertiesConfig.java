package org.jimmyray.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring configuration of the properties files
 * 
 * @author Jon Shrader
 */
@Configuration
@PropertySource(WebPropertiesConfig.APP_PROPERTIES)
public class WebPropertiesConfig extends BasePropertiesConfig {

	/** The Constant APP_NAME. */
	public static final String APP_NAME = "helloworld";
	
	/** The Application Version */
	public static final String APP_VERSION = "-1.1";

	/** The Constant DEFAULT_PROPERTIES. */
	public static final String DEFAULT_PROPERTIES = CLASSPATH_CONFIG_PREFIX + APP_NAME + "-default.properties";

	/** The Constant PROPERTY_FILE_PREFIX. */
	public static final String PROPERTY_FILE_PREFIX = CLASSPATH_CONFIG_PREFIX + APP_NAME + DASH;

	/** The Constant APP_PROPERTIES. */
	public static final String APP_PROPERTIES = WebPropertiesConfig.CLASSPATH_PREFIX
			+ WebPropertiesConfig.APP_NAME + WebPropertiesConfig.APP_VERSION + PROPERTIES_FILE_EXT;

	/**
	 * protected utility class constructor
	 */
	protected WebPropertiesConfig() {
	}

	/**
	 * The CloudBees environment configuration.
	 */
	@Configuration
	@Profile({PROFILE_CLOUDBEES_DEV, PROFILE_DEFAULT })
	@PropertySource({ DEFAULT_PROPERTIES, PROPERTY_FILE_PREFIX + PROFILE_CLOUDBEES_DEV + PROPERTIES_FILE_EXT })
	static class LocalEnvironment extends BasePropertiesEnvironment {
	}

}
