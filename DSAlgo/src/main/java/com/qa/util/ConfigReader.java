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
			FileInputStream ip = new FileInputStream("./src/test/resources/config/Config.properties");
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
	public static String getLoginPageUrl() {
		String url = prop.getProperty("loginpageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getRegisterPageUrl() {
		String url = prop.getProperty("registerpageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getArrayPageURL()
	{
		String url=prop.getProperty("arraypageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getArrayinPythonPageURL()
	{
		String url=prop.getProperty("arraysinpythonpageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getArraysusingListpageurl()
	{
		String url=prop.getProperty("arraysusinglistpageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public static String getTryEditorpageurl()
	{
		String url=prop.getProperty("tryherepageurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getBasicoperationinlistpageurl()
	{
		String url=prop.getProperty("basicoperationinlisturl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public static String getQuestionSearchthearrayurl()
	{
		String url=prop.getProperty("QuestionSearchthearray");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
			
	}
	public static String getDSIntroPageurl()
	{
		String url=prop.getProperty("DataStructuresIntroduction");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
			
	}
	public static String getTimeComplexityPageurl()
	{
		String url=prop.getProperty("TimeComplexity");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
			
	}
	
	public static String getPracticePageurl()
	{
		String url=prop.getProperty("practiceurl");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
			
	}
	// Graph
		public static String getGraphUrl() {
			String graphurl = prop.getProperty("graphurl");
			if (graphurl != null)
				return graphurl;
			else
				throw new RuntimeException("graph url is not specified in the Configuration.properties file.");
		}

		public static String getGraphGraphUrl() {
			String graphgraphurl = prop.getProperty("graphgraphurl");
			if (graphgraphurl != null)
				return graphgraphurl;
			else
				throw new RuntimeException("graphgraph url is not specified in the Configuration.properties file.");
		}

		public static String getGraphRepresentationsUrl() {
			String graphrepresentationsurl = prop.getProperty("graphrepresentationsurl");
			if (graphrepresentationsurl != null)
				return graphrepresentationsurl;
			else
				throw new RuntimeException(
						"graphrepresentations url is not specified in the Configuration.properties file.");
		}
		
	// Queue
		public static String getQueueUrl() {
			String queueurl = prop.getProperty("queueurl");
			if (queueurl != null)
				return queueurl;
			else
				throw new RuntimeException("queue url is not specified in the Configuration.properties file.");
		}
		public static String getQueueImplementationPythonUrl() {
			String queueimplementationpythonurl = prop.getProperty("queueimplementationpythonurl");
			if (queueimplementationpythonurl != null)
				return queueimplementationpythonurl;
			else
				throw new RuntimeException("queueimplementationpython url is not specified in the Configuration.properties file.");
		}
		public static String getQueueimplementationDequeUrl() {
			String queueimplementationdequeurl = prop.getProperty("queueimplementationdequeurl");
			if (queueimplementationdequeurl != null)
				return queueimplementationdequeurl;
			else
				throw new RuntimeException("queueimplementationdeque url is not specified in the Configuration.properties file.");
		}
		public static String getQueueImplementationArrayUrl() {
			String queueimplementationarrayurl = prop.getProperty("queueimplementationarrayurl");
			if (queueimplementationarrayurl != null)
				return queueimplementationarrayurl;
			else
				throw new RuntimeException("queueimplementationarrayurl url is not specified in the Configuration.properties file.");
		}
		public static String getQueueOperationUrl() {
			String queueoperationurl = prop.getProperty("queueoperationurl");
			if (queueoperationurl != null)
				return queueoperationurl;
			else
				throw new RuntimeException("queueoperation url is not specified in the Configuration.properties file.");
		}
		public static String getQueuePracticeUrl() {
			String queuepracticeurl = prop.getProperty("queuepracticeurl");
			if (queuepracticeurl != null)
				return queuepracticeurl;
			else
				throw new RuntimeException("queuepractice url is not specified in the Configuration.properties file.");
		}

	
}
	
