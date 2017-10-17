package com.statravel.ds.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DSConfig {
	private static final String CATALINA_HOME = "catalina.home";
	private static final String APP_CONFIG_DIR = "appconfig";
	private static final String DS_CONFIG_DIR = "ds";
	private static final String PROPERTIES_FILE_NAME = "app.properties";
	
	public static final String NODE_HOST_PROP_NAME = "node.js.host";
	public static final String NODE_PORT_PROP_NAME = "node.js.port";
	public static final String TIMEOUT_PROP_NAME = "request.node.timeout";
	
	private static Properties properties;
	private static DSConfig config;
	private static int timeout = -1;
	
	static {
		config = new DSConfig();
	}

	private DSConfig() {
		try {
			String propsPath = System.getProperty(CATALINA_HOME) + File.separator + APP_CONFIG_DIR 
				+ File.separator + DS_CONFIG_DIR + File.separator + PROPERTIES_FILE_NAME;
			FileInputStream fis = new FileInputStream(new File(propsPath));
			properties = new Properties();
			properties.load(fis);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static DSConfig getDSConfig() {
		return config;
	}

	public String getProperty(String propName) {
		return properties.getProperty(propName, "Null");
	}
	
	public static int getTimeout() {
		if ( timeout < 0 ) {
			String t = properties.getProperty(TIMEOUT_PROP_NAME, "Null");
			try {
				timeout = Integer.parseInt(t);
			} catch(Exception e) {
				timeout = 0;			}
		}
		return timeout;
	}
}
