package Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGProgram {

	//@Test(priority=1)//to set priority
	@Test(invocationCount=2,priority=0)// preference will be given to priority
	public  void createContact() {
		//Assert.fail(); // making fail using assert
		System.out.println("create");
	}
	//@Test(priority=-1)
	
	//@Test//it takes default priority as 0 and executes first
	//@Test(invocationCount=3)
	//@Test(enabled=false)// it will be disabled from execution
	@Test(dependsOnMethods = "createContact")
	public  void modifyContact() {
		System.out.println("modify");
	}
	
	//@Test(invocationCount=0) //it will disable the script from execution
	//@Test(priority=2)
	@Test// if more than one method have same or default priority it will execute 
			//based on ascii value
	public  void deleteContact() {
		System.out.println("delete");
	}
	
	
	

}
