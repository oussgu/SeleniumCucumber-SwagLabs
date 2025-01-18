package com.e2etests.automation.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;

	private final String propertyFilePath = "src/test/resources/configs/configFile.properties";

	/**
	 * Instanciation de config file reader.
	 */
	public ConfigFileReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				System.out.println("Exception:  ," + e);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception:  ," + e);
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} finally {
			// this block will be executed in every case, success or caught exception
			if (reader != null) {
				// again, a resource is involved, so try-catch another time
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Exception:  ," + e);
				}
			}
		}
	}

	/**
	 * Accesseur de l attribut driver path.
	 * 
	 * @return driver path
	 */
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	/**
	 * Accesseur de l attribut application url.
	 * 
	 * @param adress application url
	 * @return application url
	 */
	public String getProperties(String prop) {
		String url = properties.getProperty(prop);
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

}
