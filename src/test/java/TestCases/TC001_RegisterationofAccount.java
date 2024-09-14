package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.testbase;

public class TC001_RegisterationofAccount extends testbase {
	
	@Test(groups= {"Regression","Master"})
	public void Validation_of_Regestraion() throws InterruptedException
	{
		log.info("*********Home Page got launched*****************");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickdrpMyaccount();
			hp.clickRegister();
			
			log.info("**********Registration Page got launched************");
			RegistrationPage rp = new RegistrationPage(driver);
			rp.setFirstName(generateRandomString().toUpperCase());
			rp.setLastName(generateRandomString().toUpperCase());
			rp.setEmail(generateRandomString().toUpperCase()+"@gmail.com");
			rp.setTelephone(randomeNumber());
			String password=randomealphanum();
			rp.setPassword(password);
			rp.setConfirmPassword(password);
			rp.setPrivacyPolicy();
			rp.clickContinue();
			log.info("*************Registred the user successfully************");
			
			String Expectedtxt="Your Account Has Been Created!";
			String Actualtxt=rp.getConfirmationMsg();
			log.atDebug();
			Assert.assertEquals(Actualtxt,Expectedtxt);
		}
		catch(Exception e)
		{
			log.error("Test Failed: "+e.getMessage());
			Assert.fail("Test Failed: "+e.getMessage());
		}
		finally
		{
			log.info("****************Finished the TC001_RegisterationofAccount.java********************");
		}
	}
		
}

