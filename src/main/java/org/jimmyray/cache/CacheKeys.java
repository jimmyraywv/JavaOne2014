package org.jimmyray.cache;

public class CacheKeys {

	/** Separator for complex cache keys */
	protected static final String SEPARATOR = "_";

	/**
	 * Protected constructor to prevent instantiation
	 */
	protected CacheKeys() {
	}

	/**
	 * Creates a unique cache key using the given key values.
	 * 
	 * @param keyValues the key values
	 * @return the string
	 */
	public static final String createKey(final Object... keyValues) {
		final StringBuffer cacheKey = new StringBuffer();
		for (Object key : keyValues) {
			if (cacheKey.length() > 0) {
				cacheKey.append(SEPARATOR);
			}
			cacheKey.append(key.hashCode());
		}
		return cacheKey.toString();
	}
}

