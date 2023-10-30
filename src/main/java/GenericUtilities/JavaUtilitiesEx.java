package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


/**
 * This class consists of methods used in java
 * @author HP
 */
public class JavaUtilitiesEx {
	
	/**
	 * This method will generate random number for every run and returns the value to the caller
	 * @return
	 */
	
	public int createRandomnum() {
		
		Random ran=new Random();
		int r=ran.nextInt(1000);
		return r;
		
	}
	
	/**
	 * This  methods will capture the system date and return it in the required format
	 * @return
	 */
	public String getSystemDate() {
		
		Date d=new Date();
		//SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		String date = formatter.format(d);
		return date;
	}

}
