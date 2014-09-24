package org.jimmyray.util;

public class Constants {
	/** Encoding and Media Types **/
	public static final String WWW_FORM_ENCODING = "application/x-www-form-urlencoded";
	public static final String MEDIA_TYPE_TEXT_PLAIN = "text/plain";

	/** Exceptions **/
	public static final String EXCEPTION = "java.lang.Exception";
	public static final String RUNTIME_EXCEPTION = "java.lang.RuntimeException";

	/** Mappings and Views **/
	public static final String VIEW_ROOT = "/WEB-INF/jsp/";
	public static final String MAPPING_500 = "/error/500";
	public static final String MAPPING_404 = "/error/404";
	public static final String MAPPING_UNCAUGHT = "/error/uncaught";
	public static final String VIEW_500 = "error/500";
	public static final String VIEW_404 = "error/404";
	public static final String VIEW_UNCAUGHT = "error/uncaught";
	public static final String VIEW_EXCEPTION = "error/exception";

	public static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/jsp/";
	public static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	/** Error Messages **/
	public static final String ERROR_500 = "500";
	public static final String ERROR_404 = "404";
	public static final String KEY_ERROR_500_TITLE = "error500Title";
	public static final String VALUE_ERROR_500_TITLE = "Error 500";
	public static final String KEY_ERROR_500_MSG = "error500Msg";
	public static final String VALUE_ERROR_500_MSG = "An internal server/application error has occured.";

	public static final String KEY_ERROR_404_TITLE = "error404Title";
	public static final String VALUE_ERROR_404_TITLE = "Error 404";
	public static final String KEY_ERROR_404_MSG = "error404Msg";
	public static final String VALUE_ERROR_404_MSG = "The requested resource was not found on this site.";

	public static final String KEY_EXCEPTION_TITLE = "errorTitle";
	public static final String VALUE_EXCEPTION_TITLE = "Application Exception";
	public static final String KEY_EXCEPTION_MSG = "errorMsg";
	public static final String VALUE_EXCEPTION_MSG = "An application exception has occurred and has been logged.";

	/** Responder Service **/
	public static final String RESPONDER_RESPONSE = "Response to:  ";
	public static final String RESPONDER_SERVICE_BEAN = "responderService";

	/** Magic 8 Ball Service **/
	public static final String MAGIC_8_BALL_SERVICE_BEAN = "magicEightBallService";
	public static final String MAGIC_8_BALL_DOWN_MSG = "The Magic 8 Ball Service is down.  Try again later.";
	public static final String[] MAGIC_8_BALL_PHRASES = { "It is certain.",
			"It is decidedly so.", "Without a doubt", "Yes, definitely",
			"You may rely on it.", "As I see it, yes.", "Most likely",
			"Outlook good", "Yes", "Signs point to yes.",
			"Reply hazy, try again.", "Ask again later.",
			"Better not tell you now", "Cannot predict now",
			"Concentrate, and ask again.", "Don't count on it.",
			"My reply is no.", "My sources say no.", "Outlook not so good",
			"Very doubtful" };

	/** System Info Constants */
	public static final String SYSTEM_INFO_SERVICE_BEAN_NAME = "systemInfoService";
	public static final String JVM_ARGS = "jvmArgs";
	public static final String SYSTEM_PROPS = "systemProperties";
	public static final String OTHER_PROPS = "otherProperties";

	/** Question/Answer Text **/
	public static final String QUESTION_ANSWER_TEXT = "The question was:  \"{0}\", and the answer is \"{1}\".";
}
