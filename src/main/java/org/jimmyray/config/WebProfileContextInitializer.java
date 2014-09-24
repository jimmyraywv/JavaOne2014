/**
 * 
 */
package org.jimmyray.config;


/**
 * Context Initializer implementation to load additional spring profiles
 * as specified in the application properties files. Supports property
 * interpolation 
 * 
 * @author jluck
 *
 */
public class WebProfileContextInitializer extends ProfileContextInitializer {
	
	/**
	 * Instantiates a new web profile context initializer.
	 */
	public WebProfileContextInitializer() {
		super(WebPropertiesConfig.APP_NAME, WebPropertiesConfig.APP_VERSION);
		super.setDefaultEnvProfile(CommonSpringProfiles.PROFILE_CLOUDBEES_DEV);
	}
}
