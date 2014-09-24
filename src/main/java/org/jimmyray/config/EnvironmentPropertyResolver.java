package org.jimmyray.config;

import org.jimmyray.config.annotations.BeanName;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Class aware of and representing the Spring environment for which it runs in. The primary use case of this is to
 * expose and allow projects to access properties and profiles in the running environment.
 * 
 * In spring managed beans @Value or ${...} should be used in favor of this for accessing (injecting) properties.
 * 
 * In view files such as Freemarker templates or JSPs, this allows one to access properties via SPEL, such as
 * @environment['some.property']
 * 
 * Java files not managed by spring can fetch this bean from the SpringBeanFactory and get properties as well.
 * 
 * @author jshrader
 */
@BeanName(id = EnvironmentPropertyResolver.BEAN_NAME)
@Component(EnvironmentPropertyResolver.BEAN_NAME)
public class EnvironmentPropertyResolver implements EnvironmentAware, Environment {

	/** The Constant BEAN_NAME. */
	static final String BEAN_NAME = "environment";

	/** The environment. */
	private Environment environment;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.EnvironmentAware#setEnvironment(org.springframework.core.env.Environment)
	 */
	//@Override
	public final void setEnvironment(final Environment environment) {
		this.environment = environment;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.Environment#acceptsProfiles(java.lang.String[])
	 */
	//@Override
	public final boolean acceptsProfiles(final String... profiles) {
		return this.environment.acceptsProfiles(profiles);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.Environment#getActiveProfiles()
	 */
	//@Override
	public final String[] getActiveProfiles() {
		return this.environment.getActiveProfiles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.Environment#getDefaultProfiles()
	 */
	//@Override
	public final String[] getDefaultProfiles() {
		return this.environment.getDefaultProfiles();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#containsProperty(java.lang.String)
	 */
	//@Override
	public final boolean containsProperty(final String key) {
		return this.environment.containsProperty(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getProperty(java.lang.String)
	 */
	//@Override
	public final String getProperty(final String key) {
		return this.environment.getProperty(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getProperty(java.lang.String, java.lang.String)
	 */
	//@Override
	public final String getProperty(final String key, final String defaultValue) {
		return this.environment.getProperty(key, defaultValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getProperty(java.lang.String, java.lang.Class)
	 */
	//@Override
	public final <T> T getProperty(final String key, final Class<T> targetType) {
		return this.environment.getProperty(key, targetType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getProperty(java.lang.String, java.lang.Class,
	 * java.lang.Object)
	 */
	//@Override
	public final <T> T getProperty(final String string, final Class<T> targetType, final T defaultValue) {
		return this.environment.getProperty(string, targetType, defaultValue);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getPropertyAsClass(java.lang.String, java.lang.Class)
	 */
	//@Override
	public final <T> Class<T> getPropertyAsClass(final String key, final Class<T> targetType) {
		return this.environment.getPropertyAsClass(key, targetType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getRequiredProperty(java.lang.String)
	 */
	//@Override
	public final String getRequiredProperty(final String key) {
		return this.environment.getRequiredProperty(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#getRequiredProperty(java.lang.String, java.lang.Class)
	 */
	//@Override
	public final <T> T getRequiredProperty(final String key, final Class<T> targetType) {
		return this.environment.getRequiredProperty(key, targetType);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#resolvePlaceholders(java.lang.String)
	 */
	//@Override
	public final String resolvePlaceholders(final String text) {
		return this.environment.resolvePlaceholders(text);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.env.PropertyResolver#resolveRequiredPlaceholders(java.lang.String)
	 */
	//@Override
	public final String resolveRequiredPlaceholders(final String text) {
		return this.environment.resolveRequiredPlaceholders(text);
	}

}
