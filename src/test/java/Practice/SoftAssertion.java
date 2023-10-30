package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
@Test
public void softAssert() {
	SoftAssert sa=new SoftAssert();
	System.out.println("Step1");
	
	System.out.println("Step2");
	sa.assertEquals(false, false);//passed
	System.out.println("Step3");
	System.out.println("Step4");
	Assert.assertEquals(1, 2);//failed
	sa.assertEquals("A"," B"); //failed
	sa.assertAll();
}
}
