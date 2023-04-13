package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Variables.ConfigProperties;
import io.cucumber.java.en.Given;

public class Default_Steps {

	WebDriver driver = null;
	public static final String Username = "bharathajjaiah_m15aKU";
	public static final String Automatekey = "RgAqRQEuKD7EBkzRFF2C";
	public static final String url = "https://"+Username+":"+Automatekey+"@hub-cloud.browserstack.com/wd/hub";
	
	//User opens browser and navigates to URL.
	@Given("^User navigate to the URL \"(.*)\"$")
	public void Open_Browser(String URL) throws MalformedURLException {
		
		//Initializing app-config file
		ConfigProperties.initializePropertyFile();

		//condition to initiate browser stack execution
		if(ConfigProperties.property.getProperty("browser_stack_Execution").equalsIgnoreCase("Y")) {
			
			
			//Desired Capabilities for browserstack
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", "Windows");
			caps.setCapability("os_version", "10");
			caps.setCapability("browser", ConfigProperties.property.getProperty("browser"));
			caps.setCapability("browser_version", ConfigProperties.property.getProperty("browser_version"));
			caps.setCapability("projectName", "HCP_Test_Automation");
			caps.setCapability("name", "Run HCP -Regression");
			
			driver = new RemoteWebDriver(new URL(url),caps);
			
		}
		//condition to initiate Local execution
		else if (ConfigProperties.property.getProperty("browser_stack_Execution").equalsIgnoreCase("N"))  {
		  
		  if(ConfigProperties.property.getProperty("browser").equalsIgnoreCase("Chrome")) {
		  
			  System.getProperty("Webdriver.crome.driver",
					  "src/test/resources/Drivers/chromedriver.exe");
			  
			  driver = new ChromeDriver();
		  
		  }
		  else if (ConfigProperties.property.getProperty("browser").equalsIgnoreCase("Edge")) {
			  
			  driver = new EdgeDriver();
			  
		  }
		}
		  driver.manage().window().maximize();
		  
		  driver.get(URL);
		 
		  driver.quit();
	}
	


}
