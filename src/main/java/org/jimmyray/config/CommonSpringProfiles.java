package org.jimmyray.config;

/**
 * Constants to store the profiles we commonly used in applications.
 * 
 * @author jshrader
 */
// JSHRADER - supressing the "interface is type" check from checkstyle as we are
// going to
// want to store these constants somewhere, and an interface is just as ugly
// as doing this in a constants class. Both will fail Sonar, the pattern isn't
// something we want all over the codebase but in some situations it is ok.
// CHECKSTYLE:OFF
public interface CommonSpringProfiles {
	// CHECKSTYLE:ON

	/** Spring default profile */
	String PROFILE_DEFAULT = "default";

	/** Spring CloudBees Dev profile */
	String PROFILE_CLOUDBEES_DEV = "cloudbees_dev";

}
