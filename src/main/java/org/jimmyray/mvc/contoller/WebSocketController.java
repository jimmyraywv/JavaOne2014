package org.jimmyray.mvc.contoller;

import java.text.MessageFormat;

import org.jimmyray.data.model.AnswerMessage;
import org.jimmyray.data.model.QuestionMessage;
import org.jimmyray.services.MagicEightBallService;
import org.jimmyray.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WebSocketController.class);
	
	static {
		LOGGER.debug("Loaded Web Socket Controller");
	}

	@Autowired
	private MagicEightBallService eightBallService;

	@MessageMapping("/eightBallQuestion")
	@SendTo("/topic/eightBallAnswer")
	public AnswerMessage greeting(QuestionMessage message) throws Exception {
		LOGGER.debug("Reached /eightBallQuestion message mapping.");

		Thread.sleep(3000); // simulated delay

		return new AnswerMessage(MessageFormat.format(
				Constants.QUESTION_ANSWER_TEXT, message.getQuestion(),
				this.eightBallService.getPhrase() + "."));
	}
}
