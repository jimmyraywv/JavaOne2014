package org.jimmyray.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * The Class TestWebConfig is an "add on" to the normal WebConfig.
 *
 * This additional configuration loads spring configuration that is loaded by the servlet container
 * but not necessarily WebConfig, for example configuration found in the eag-web-mvc-servlet.xml.
 *
 * @author jshrader
 */
@Configuration
@Import({ WebConfig.class })
@ImportResource({"classpath:/context/mvc-servlet.xml", "/context/applicationContext-web-test.xml"})
public class TestWebConfig {

}
