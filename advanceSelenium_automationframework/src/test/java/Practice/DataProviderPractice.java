package Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.excelFileUtility;

public class DataProviderPractice {
	
	@Test(dataProvider="getData")
	public void readData(String Name,String model,String qty,String price)// test script
	{
		System.out.println(Name+",,"+model+",,"+qty+",,"+price);
		
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		/*Object[][] data=new Object[3][4];
		
		data[0][0]="Samsung";
		data[0][1]="A80";
		data[0][2]="12";
		data[0][3]="12000";
		
		data[1][0]="Iphone";
		data[1][1]="S14";
		data[1][2]="20";
		data[1][3]="15000";
		
		data[2][0]="Vivo";
		data[2][1]="V21";
		data[2][2]="15";
		data[2][3]="10000";
		
		return data;*/
		
		excelFileUtility eutil=new excelFileUtility();
		Object[][] data=eutil.readMultipleDataFromExcel("Sheet1");
		return data;
		
		
		
		
	}

}
