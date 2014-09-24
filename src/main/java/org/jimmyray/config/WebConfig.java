package org.jimmyray.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Spring configuration for the project.
 * 
 * The majority of beans should be defined here. For special cases (i.e.
 * spring-mvc servlet configuration) and/or cases where its difficult/impossible
 * to get the annotation configuration working, XML is an acceptable fallback.
 * 
 * @author jshrader
 * @author jluck
 */
// [jshrader] Suppress PMD's ExcessiveImports warning for importing to many
// classes. This is a configuration class, it will be coupled to all pieces of
// the
// framework we are loading/configuring by nature.
@SuppressWarnings("PMD.ExcessiveImports")
@Configuration
@ComponentScan(basePackages = { "org.jimmyray.config",
		"org.jimmyray.mvc.controller" }, excludeFilters = @Filter(Configuration.class))
@Import({ WebPropertiesConfig.class })
@EnableWebSocketMessageBroker
public class WebConfig implements WebSocketMessageBrokerConfigurer {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WebConfig.class);

	/**
	 * protected utility class constructor
	 */
	protected WebConfig() {
	}

	/**
	 * Web Socket Section
	 */

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic");
		config.setApplicationDestinationPrefixes("/app");
		LOGGER.debug("configureMessageBroker");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/eightBallQuestion").withSockJS();
		LOGGER.debug("registerStompEndpoints");
	}

	@Override
	public void configureClientInboundChannel(
			ChannelRegistration channelRegistration) {
		LOGGER.debug("configureClientInboundChannel");
	}

	@Override
	public void configureClientOutboundChannel(
			ChannelRegistration channelRegistration) {
		LOGGER.debug("configureClientOutboundChannel");
	}

	@Override
	public boolean configureMessageConverters(
			List<MessageConverter> messaageConverters) {
		LOGGER.debug("configureMessageConverters");

		if (null == messaageConverters) {
			messaageConverters = new ArrayList<MessageConverter>();
		}

		MappingJackson2MessageConverter messaageConverter = new MappingJackson2MessageConverter();
		messaageConverter
				.setContentTypeResolver(new DefaultContentTypeResolver());

		messaageConverters.add(messaageConverter);

		// TODO Auto-generated method stub
		return false;
	}

}
