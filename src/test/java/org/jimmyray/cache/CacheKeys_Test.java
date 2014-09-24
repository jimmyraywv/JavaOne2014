package org.jimmyray.cache;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//@RunWith(SpringJUnit4ClassRunner.class)
public class CacheKeys_Test {

	@Test
	public void testcreatKey() {
		String keyString = "STRING";
		Object keyObject = "OBJECT";

		assertEquals("Key did not match.", keyString.hashCode() + "_"
				+ keyObject.hashCode(),
				CacheKeys.createKey(keyString, keyObject));

		keyString = null;
		keyObject = null;

		keyString = "STRING";
		keyObject = "OBJECT";

		assertEquals("Key did not match.", keyString.hashCode() + "_"
				+ keyObject.hashCode(),
				CacheKeys.createKey(keyString, keyObject));
	}
}
