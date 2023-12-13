package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromaExcelFile {

	public static void main(String[] args) throws IOException
	{
	  //Step1: Open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
		
	  //Step2:Create a Workbook
		Workbook wb=WorkbookFactory.create(fis);
		
	 //Step3:Navigate to required sheet
	Sheet sh = wb.getSheet("Organization");

		
	//Step4:Navigate to Required row
	Row rw = sh.getRow(4);
		
	//Step5:Navigate to Required cell
	Cell cl = rw.getCell(2);
		
	//Step6:Capture the value in the cell	
	String value = cl.getStringCellValue();
	System.out.println(value);
		
		
	  	
	}
}

