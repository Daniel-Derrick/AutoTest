package Variables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExtentProperties {
	
	public static Properties property;
	private static String Reportpath = "src/test/resources/extent.properties";
	
	public static void initializePropertyFile() {
		
		property = 	new Properties();
		
		try {
			InputStream instm = new FileInputStream(Reportpath);
			property.load(instm);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
