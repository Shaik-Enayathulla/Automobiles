package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Validation;
import TestBase.testbase;
import Utilities.DataProviders;

public class TC_003_DataDrivenLogin extends testbase{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void DataDriverTest(String email,String pass,String expt)
	{
		log.info("****************Test TC003 Data Driven Testing started*********************");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickdrpMyaccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);	
			lp.setPassword(pass);
			lp.clickbtnLogin();
			
			Validation vld = new Validation(driver);
			boolean targetpage = vld.ValitationofAccount();
			if(expt.equalsIgnoreCase("Valid"))
			{
				if(targetpage==true)
				{
					vld.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(expt.equalsIgnoreCase("Invalid"))
			{
				if(targetpage==true)
				{
					vld.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			Thread.sleep(4000);
			
		}
		catch(Exception e)
		{
			Assert.fail("An exception occured "+e.getMessage());
		}
		finally
		{
			log.info("****************Finished Data Driven Test Case_003****************");
		}
	}
	
}

