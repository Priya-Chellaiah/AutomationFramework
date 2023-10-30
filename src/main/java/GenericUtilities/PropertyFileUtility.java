package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class consists of generic methods to read data from property file
 * @author PRIYA 
 */
public class PropertyFileUtility {
	/**
	 * 
	 * @param key
	 * @throws Throwable
	 */
		
	public String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		//System.out.println("value is"+value);
		return value;
		
	}

}
