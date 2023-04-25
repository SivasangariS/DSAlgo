package appHooks;
import java.util.Properties;


import java.io.ByteArrayInputStream;
//import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;


public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	private static Properties prop;
	private static boolean isDriverInitialized = false;
	private static final Logger LOGGER=LogManager.getLogger(ApplicationHooks.class);

	@Before()
	public void getProperty() {
		LOGGER.info("Instantiation of Config Reader");
		configReader = new ConfigReader();
		setProp(configReader.init_prop());
	
	
	/* @Before(order = 1)
	    public void initDriver() {
	        if (!isDriverInitialized) {
	            LOGGER.info("Instantiation of Driver Factory");
	            String browserName = prop.getProperty("browser");
	            driverFactory = new DriverFactory();
	            driver = driverFactory.init_driver(browserName);
	            isDriverInitialized = true;
	        }*/
	       //@Before(order = 1)
	    	//public void initDriver() {
	    		LOGGER.info("Instantiation of Driver Factory");
	    		if (driverFactory == null) {
	    			driverFactory = new DriverFactory();
	    		}
	    		String browserName = getProp().getProperty("browser");
	    		driver = driverFactory.init_driver(browserName);
	    	}
	
				
	

@After()
	public void quitBrowser() {
	LOGGER.info("Browser quit");
		//driver.quit();
		isDriverInitialized = false;
}
/*@After(order = 0)
public void quitBrowser() {
	LOGGER.info("Browser quit");
	driverFactory.quit_driver();
}*/

	@AfterStep()
	public void tearDown(Scenario scenario) {
		LOGGER.info("Taking Screenshot of failed test case");
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

		}
	}

	public static Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}


}
