package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromePropertyFile {

	public static void main(String[] args) throws NullPointerException,IOException{
		
		//step 1: open the document in java readable format
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		// Step 2: Create object of properties for java.utilpackage
		Properties p=new Properties();
					
					
		//step 3: load the file input stream into properties
		p.load(fis);
		
		//step 4: provide the key and read the value
		String value = p.getProperty("browser");
		System.out.println(value);
		System.out.println(p.getProperty("url"));
		System.out.println(p.getProperty("password"));
		System.out.println(p.getProperty("username"));
		
		

	}

}
