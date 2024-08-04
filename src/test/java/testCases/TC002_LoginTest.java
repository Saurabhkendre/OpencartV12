package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("**** Starting TC_002_LoginTest ****");
		   try
		   {
			//Home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on MyAccount link...");
			
			hp.clickLogin();
			logger.info("Clicked on login link...");
			
			//Login page
			LoginPage lp = new LoginPage(driver);
			logger.info("Providing customer details...");
			lp.setEmailAddress(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			
			lp.clickLogin();
			
			//My Account page
			MyAccountPage mp = new MyAccountPage(driver);
			
			boolean targetPage = mp.isMyAccountPageExists();
			
			Assert.assertEquals(targetPage, true, "Login failed"); //Assert.assertTrue(targetPage);
			} 
		    catch (Exception e) 
		    {
			Assert.fail();
		    }
		    logger.info("**** Finished TC_002_LoginTest ****");
	}
}
