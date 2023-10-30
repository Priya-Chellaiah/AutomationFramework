package Practice;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.JavaUtilitiesEx;
import GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable  {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		  String URL = pUtil.readDataFromPropertyFile("url");
		  System.out.println(URL);
		  
		  String BROWSER = pUtil.readDataFromPropertyFile("browser");
		  System.out.println(BROWSER);
		  
		 ExcelFileUtility eUtil = new ExcelFileUtility();
		 String data=eUtil.readDatafromEcxel("contact", 1, 2);
		 System.out.println(data);
		 
		 JavaUtilitiesEx jUtil=new JavaUtilitiesEx();
		 int r=jUtil.createRandomnum();
		 System.out.println(r);
		 
		 String date=jUtil.getSystemDate();
		 System.out.println(date);
		  
		  

	}

}
