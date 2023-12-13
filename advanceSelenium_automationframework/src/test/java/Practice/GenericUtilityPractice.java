package Practice;

import java.io.IOException;

import genericUtilities.PropertyFileUtility;
import genericUtilities.excelFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		
		//test script
		PropertyFileUtility  pUtil=new PropertyFileUtility ();
		String value = pUtil.readdatafrompropertyfile("url");

		System.out.println(value);
		
		String value1 = pUtil.readdatafrompropertyfile("username");

		System.out.println(value1);
		
		
		//test script
		excelFileUtility eutil=new excelFileUtility();
		String val = eutil.readdatafromexcelfile("ORGANIZATION",0,0);
		System.out.println(val);
		
		
		
		
	}

}
