package org.fastdb;

import java.util.Properties;

import org.fastdb.util.PropertiesUtils;
import org.fastdb.util.StringUtils;

public class SysProperties {

	private static volatile Properties props;

	private static String defaultConfigName = "fastdb.properties";

	private static void initPropertyMap() {
		props = PropertiesUtils.load(defaultConfigName);
		if (props == null) {
			props = new Properties();
		}
	}

	/**
	 * Return the property map loading it if required.
	 */
	private static Properties getPropertyMap() {
		if (props == null) {
			initPropertyMap();
		}
		return props;
	}

	public static String getProperty(String key) {
		return getPropertyMap().getProperty(key);
	}

	public static String getProperty(String key, String defaultValue) {
		return getPropertyMap().getProperty(key, defaultValue);
	}

	public static int getInt(String key, int defaultValue) {
		return StringUtils.parseInt(getProperty(key), defaultValue);
	}

	public static boolean getBoolean(String key, boolean defaultValue) {
		return StringUtils.parseBoolean(getProperty(key), defaultValue);
	}

	public static void put(String key, String value) {
		getPropertyMap().setProperty(key, value);
	}
}
