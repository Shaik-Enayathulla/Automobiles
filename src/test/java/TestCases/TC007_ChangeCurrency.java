package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestBase.testbase;

public class TC007_ChangeCurrency extends testbase {
	
	@Test(groups= {"Sanity"})
	public void CheckCurrencyChange()
	{
		HomePage hp = new HomePage(driver);
		
		hp.SelectEuroCurrency();
		String act = hp.Actual_Currency();
		System.out.println("the actual String: "+act);
		if(act.contains("€"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

}
