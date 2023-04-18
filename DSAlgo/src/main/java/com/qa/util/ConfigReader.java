package com.qa.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	private static Properties prop;

	/**
	 * This method is used to load the properties from config.properties file
	 * @return it returns Properties prop object
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}
	
	public static String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getHomePageUrl() {
		String url = prop.getProperty("homepageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getTryEditorpageurl()
	{
		String url = prop.getProperty("tryeditorpageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getArraysusingListpageurl()
	{
		String url = prop.getProperty("arraysusinglistpageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getQuestionSearchthearrayurl()
	{
		String url = prop.getProperty("questionsearchthearrayurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	}
	