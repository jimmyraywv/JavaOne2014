/**
 * 
 */
package org.jimmyray.config;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * Context Initializer implementation to load additional spring profiles as
 * specified in the application properties files. Supports property
 * interpolation, resolving the profileProperty against the following properties
 * files in this order:
 * 
 * <appName>.properties config/<appName>-<env profile>.properties
 * config/<appName>-default.properties
 * 
 * @author jluck
 * 
 */
public class ProfileContextInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProfileContextInitializer.class);

	/** Property containing app profiles */
	private static final String DEFAULT_PROFILE_PROPERTY_SUFFIX = ".profiles";

	/** Default version */
	private static final String DEFAULT_VERSION = "";

	/** List of all supported environment profiles */
	private static final String[] ENVIRONMENT_PROFILES = {
			CommonSpringProfiles.PROFILE_CLOUDBEES_DEV};

	/** Application Name */
	private final String appName;

	/** Application Version */
	private final String appVersion;

	/** Profile property */
	private final String profileProperty;

	/** The default env profile. */
	private String defaultEnvProfile;

	/**
	 * Constructs a ContextInitializer that will load profile properties from
	 * the property name <appName>.profiles
	 * 
	 * @param appName
	 *            application name used to prefix property files to load
	 */
	public ProfileContextInitializer(final String appName) {
		this(appName, DEFAULT_VERSION, appName
				+ DEFAULT_PROFILE_PROPERTY_SUFFIX);
	}

	/**
	 * Constructs a ContextInitializer that will load profile properties from
	 * the property name <appName>.profiles
	 * 
	 * @param appName
	 *            the app names
	 * @param appVersion
	 *            the app version
	 */
	public ProfileContextInitializer(final String appName,
			final String appVersion) {
		this(appName, appVersion, appName + DEFAULT_PROFILE_PROPERTY_SUFFIX);
	}

	/**
	 * Constructs a ContextInitializer that will load profile properties from
	 * the property name <profileProperty>.
	 * 
	 * @param appName
	 *            application name used to prefix property files to load
	 * @param appVersion
	 *            the app version
	 * @param profileProperty
	 *            name of property containing list of
	 */
	public ProfileContextInitializer(final String appName,
			final String appVersion, final String profileProperty) {
		this.appName = appName;
		this.appVersion = appVersion;
		this.profileProperty = profileProperty;
	}

	/**
	 * Sets the default env profile.
	 * 
	 * @param defaultEnvProfile
	 *            the new default env profile
	 */
	public final void setDefaultEnvProfile(final String defaultEnvProfile) {
		this.defaultEnvProfile = defaultEnvProfile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationContextInitializer#initialize
	 * (org.springframework.context.ConfigurableApplicationContext)
	 */
	// @Override
	public final void initialize(
			final ConfigurableApplicationContext applicationContext) {
		final ConfigurableEnvironment contextEnv = applicationContext
				.getEnvironment();

		try {
			// conditionally activate a default env
			conditionallyActivateDefaultEnvProfile(contextEnv);

			// Load properties
			contextEnv
					.getPropertySources()
					.addFirst(
							new ResourcePropertySource(
									BasePropertiesConfig.CLASSPATH_CONFIG_PREFIX
											+ appName
											+ "-default"
											+ BasePropertiesConfig.PROPERTIES_FILE_EXT));
			setEnvPropertySources(applicationContext, appName);
			contextEnv
					.getPropertySources()
					.addFirst(
							new ResourcePropertySource(
									BasePropertiesConfig.CLASSPATH_PREFIX
											+ appName
											+ appVersion
											+ BasePropertiesConfig.PROPERTIES_FILE_EXT));

			// Lookup the profile keys
			final String[] value = contextEnv.getProperty(profileProperty,
					String[].class);
			// Active the profiles
			if (value != null) {
				for (String profile : value) {
					contextEnv.addActiveProfile(profile);
				}
			}

		} catch (IOException ex) {
			throw new ApplicationContextException(
					"Error initializing profiles from properties file.", ex);
		}

		// Log out the active profiles
		if (LOGGER.isInfoEnabled()) {
			final StringBuffer profiles = new StringBuffer();
			for (String prof : contextEnv.getActiveProfiles()) {
				if (profiles.length() > 0) {
					profiles.append(", ");
				}
				profiles.append(prof);
			}
			LOGGER.info("Active Spring Profiles are: [" + profiles + "]");
		}

	}

	/**
	 * Conditionally activate default env profile.
	 * 
	 * @param contextEnv
	 *            the context env
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void conditionallyActivateDefaultEnvProfile(
			final ConfigurableEnvironment contextEnv) throws IOException {

		// if no default env is specified, then don't activate one by default
		if (StringUtils.isEmpty(defaultEnvProfile)) {
			return;
		}

		// check if any env profile is activated
		boolean envProfileActivated = false;
		for (String profile : ENVIRONMENT_PROFILES) {
			if (contextEnv.acceptsProfiles(profile)) {
				envProfileActivated = true;
			}
		}

		// if no env profile was activated, activate the defaultEnvProfile
		if (!envProfileActivated) {
			LOGGER.info("No Env Profile Activated, Defaulting to: "
					+ defaultEnvProfile);
			contextEnv.addActiveProfile(defaultEnvProfile);
		}
	}

	/**
	 * Load up the property source for the environment based property file.
	 * Current environment is determined by which environment Spring profile is
	 * active.
	 * 
	 * @param applicationContext
	 *            the application context
	 * @param appName
	 *            application name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void setEnvPropertySources(
			final ConfigurableApplicationContext applicationContext,
			final String appName) throws IOException {

		final ConfigurableEnvironment contextEnv = applicationContext
				.getEnvironment();

		for (String profile : ENVIRONMENT_PROFILES) {
			// If environment profile is active, add the corresponding property
			// source
			if (contextEnv.acceptsProfiles(profile)) {
				contextEnv
						.getPropertySources()
						.addFirst(
								new ResourcePropertySource(
										BasePropertiesConfig.CLASSPATH_CONFIG_PREFIX
												+ appName
												+ BasePropertiesConfig.DASH
												+ profile
												+ BasePropertiesConfig.PROPERTIES_FILE_EXT));
			}
		}
	}

}
