package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MP3PlayersPage;
import PageObjects.MyWishListPage;
import PageObjects.TouchPadDevicePage;
import TestBase.testbase;

public class TC005_AddWishList extends testbase
{
	@Test(groups="Master")
	public void Func_WishList()
	{
		log.info("*********Home Page got launched*****************");
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickdrpMyaccount();
			hp.clickLogin();
			
			LoginPage login = new LoginPage(driver);
			login.setEmail("newme@gmail.com");
			login.setPassword("09876");
			login.clickbtnLogin();
			
			hp.clickMp3PlayerDropDown();
			hp.NavigateToMp3playersShop();
			
			log.info("*****************MP3 Player/Ipod Shopping Page Launched*****************");
			MP3PlayersPage mp3= new MP3PlayersPage(driver);
			mp3.selectTouchPad();
			
			log.info("****************Touched Ipod Page Launched*****************");
			TouchPadDevicePage iPadTouch = new TouchPadDevicePage(driver);
			iPadTouch.AddTouchTo_WishList();
			
			/*String Expected_msg=" Success: You have added ";
			String Actual_msg=iPadTouch.Actual_Msg_from_WebPage();
			
			Assert.assertEquals(Expected_msg, Actual_msg);*/
			
			MyWishListPage WishList = new MyWishListPage(driver);
			boolean Act_result = WishList.isiPodTouch_add();
			
			Assert.assertTrue(Act_result);
			
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
