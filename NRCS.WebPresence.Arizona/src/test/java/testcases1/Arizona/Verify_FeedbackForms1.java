package testcases1.Arizona;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.FeedbackForms;
import pages.SuccessStories;
import pages1.Arizona.FeedbackForms1;
import utility.Helper;

public class Verify_FeedbackForms1 {

	WebDriver driver;

	@BeforeClass

	public void SetUp()

	{

		driver = BrowserFactory.getBrowser("firefox");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl1() + "contactusn/az/contact/feedback/");

		Helper.capturescreenshot(driver, "FeedBackFormsAZ_Prod");

	}

	@Test(priority = 1)

	public void testHomePage() {

		FeedbackForms1 home = PageFactory.initElements(driver, FeedbackForms1.class);

		System.out.println("\t");

		FeedbackForms1.validateProd();

	}

	@AfterClass

	public void teardown() {

		driver.close();
	}

}
