package StepDefinitions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.runner.JUnitCore;

import Variables.ConfigProperties;
import Variables.ExtentProperties;

public class Test_Demo {
	
 

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int min = 10000;  
		int max = 99999; 
		
		//data manipulation for app-config file
		/*
		 * ConfigProperties.initializePropertyFile();
		 * 
		 * OutputStream outputstream_appconfig = new
		 * FileOutputStream("src/test/resources/Configration/app-config.properties");
		 * 
		 * ConfigProperties.property.store(outputstream_appconfig,null);
		 * 
		 * outputstream_appconfig.close();
		 */
		
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        
        DateTimeFormatter Time = DateTimeFormatter.ofPattern("HH-mm-ss");    
        
        LocalDateTime now = LocalDateTime.now();
     	
     	int Tc_ID = (int)(Math.random()*(max-min+1)+min); 
     	
     	String ExtentReport_Path = "target/test-output/SparkReport_"+date.format(now)+"/HCP-Report_TCID-"+Tc_ID+"-"+Time.format(now)+".html";
     	
     	//ExtentProperties.property.setProperty("extent.reporter.spark.out", "target/test-output/SparkReport/Spark.html");
     	
     	//data manipulation for extentproperties file
     	
		ExtentProperties.initializePropertyFile();
     	
     	OutputStream outputstream_Extentproperties = new FileOutputStream("src/test/resources/extent.properties");
     	
     	ExtentProperties.property.setProperty("extent.reporter.spark.out", ExtentReport_Path);

     	ExtentProperties.property.store(outputstream_Extentproperties,null);
     	
     	outputstream_Extentproperties.close();

		
		
		
		
		  JUnitCore jCore = new JUnitCore(); 
		  jCore.run(TestRunner.class);
		 
		 
		 
		
	}
	

}
