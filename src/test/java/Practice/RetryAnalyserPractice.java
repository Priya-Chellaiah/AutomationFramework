package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {
	@Test(retryAnalyzer= GenericUtilities.RetryAnalyserImplementation.class)
	public void analyserPractice()
	{
		Assert.fail();
		System.out.println("Haiii");
	}

}
