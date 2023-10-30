package Practice;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteIntoPropertyfile {

	public static void main(String[] args) throws Throwable {
		//step1:create object of FileinputStream class
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\writetopeoperty.property");
		
		//step2:create object of property class
		Properties pro=new Properties();
		
		//step3:set the values to be written in property file
		pro.setProperty("url" ,"https://www.google.com/");
		pro.setProperty("FBurl", "https://www.facebook.com/");
		pro.setProperty("username", "admin");
		pro.setProperty("pwd", "admin");
		
		//step4: store the values in the property file
		pro.store(fos, null);

	}

}
