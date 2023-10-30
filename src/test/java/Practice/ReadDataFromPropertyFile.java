package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//step1: open the document in the java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		//step2:create object of properties for java.util package
		Properties prop=new Properties();
		//step3: load the file input stream into properties
		prop.load(fis);
		
		//step4:fetch the value from the property file by providing key and print the value
		String value = prop.getProperty("abcd");
		
		System.out.println(value);

	}

}
