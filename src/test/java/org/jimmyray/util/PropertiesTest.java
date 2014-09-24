package org.jimmyray.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class PropertiesTest {

	@Test
	public void testProperties() {
		assertEquals("Property did not match.", "!GET_NOTHING!",
				Properties.getString("GET_NOTHING"));

		assertNotNull("Property was null.",
				Properties.getString("application.builder"));
		assertNotEquals("Property matched.", "!application.builder!",
				Properties.getString("application.builder"));

		assertNotNull("Property was null.",
				Properties.getString("application.buildDateTime"));
		assertNotEquals("Property matched.", "!application.buildDateTime!",
				Properties.getString("application.buildDateTime"));

		assertNotNull("Property was null.",
				Properties.getString("application.version"));
		assertNotEquals("Property matched.", "!application.version!",
				Properties.getString("application.version"));

	}
}
