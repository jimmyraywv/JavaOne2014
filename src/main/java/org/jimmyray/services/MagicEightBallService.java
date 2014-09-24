package org.jimmyray.services;

import org.jimmyray.config.annotations.BeanName;

@BeanName(id = "magicEightBallService", name = "magicEightBallService")
public interface MagicEightBallService {

	String getPhrase();
}
