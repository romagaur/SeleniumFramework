package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of reusable methods related to property file.
 * 
 *
 */
	public class PropertyFileUtility {
	/**
	 * This method will give data from property file for the key provided by caller 
	 * and return the value to caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	
		public String readdatafrompropertyfile(String key) throws IOException
	{
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fisp);
		String value = p.getProperty(key);
		return value;
		
		
	}
}
