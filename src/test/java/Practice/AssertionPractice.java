package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPractice {

	@Test
	public void practice() {
		System.out.println("Step1");
		System.out.println("Step2");
		
		Assert.assertTrue(false);
		System.out.println("Step3");
		System.out.println("Step4");
	}
}
