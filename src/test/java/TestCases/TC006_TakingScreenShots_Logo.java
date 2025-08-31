package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestBase.testbase;

public class TC006_TakingScreenShots_Logo extends testbase {
	@Test(groups= {"Regression"})
	public void takeSnap_Logo()
	{
		try {
		HomePage hp = new HomePage(driver);
		while(!hp.Dell_logo_check().isDisplayed())
		{
			hp.nextButtomTabNavigator_btn();
		}
		
			hp.ScreenShort_Dell_Logo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
