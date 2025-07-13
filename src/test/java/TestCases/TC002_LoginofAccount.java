package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Validation;
import TestBase.testbase;

public class TC002_LoginofAccount extends testbase {
	
	@Test(groups={"Sanity","Master"})
	public void ValitationofLogin()
	{
		log.info("****************Test TC002 started*********************");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickdrpMyaccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));	
		lp.setPassword(p.getProperty("password"));
		lp.clickbtnLogin();
		
		Validation vld = new Validation(driver);
		boolean b = vld.ValitationofAccount();
		Assert.assertEquals(b, false);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		finally
		{
			log.info("****************Finished Test case TC002****************");
		}
	}
	
}
