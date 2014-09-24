package org.jimmyray.services;

import java.util.Random;

import org.jimmyray.util.Constants;
import org.springframework.stereotype.Service;

@Service(Constants.MAGIC_8_BALL_SERVICE_BEAN)
public class MagicEightBallServiceImpl implements MagicEightBallService {

	private Random randomizer = new Random();

	public String getPhrase() {
		int randomInt = randomizer.nextInt(20);
		return Constants.MAGIC_8_BALL_PHRASES[randomInt];
	}

}
