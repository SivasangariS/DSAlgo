package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"appFeatures"},
		glue = {"Stepdefnitions", "appHooks"},
		monochrome=true,
	   
		plugin = {"pretty",
				
		}
		
		)

public class MyTestRunner {

}
