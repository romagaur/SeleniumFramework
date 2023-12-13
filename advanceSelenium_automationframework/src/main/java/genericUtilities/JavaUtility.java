package genericUtilities;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * This method will return the current system date in specified format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d=new Date(0);
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String currentdate=formatter.format(d);
		return currentdate;
		
	}
	
	/**
	 * this method will generate a random number for every run
	 */
	public int getRandomNumber()
	{
		Random r= new Random();
		int value=r.nextInt(10000);
		return value;
	}
}
