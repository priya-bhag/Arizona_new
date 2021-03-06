package testcases1.Montana;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.CivilRights;
import pages.ConservationPlanning;
import pages1.Montana.CivilRights1;
import utility.Helper;

public class Verify_CivilRights1 {

	WebDriver driver;

	@BeforeClass

	public void SetUp()

	{

		driver = BrowserFactory.getBrowser("firefox");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl1() + "main/mt/about/civilrights/");
		Helper.capturescreenshot(driver, "CivilRightsIN_Prod");

	}

	@Test(priority = 1)

	public void testHomePage() {

		CivilRights1 home = PageFactory.initElements(driver, CivilRights1.class);

		// System.out.println("Title of URL1 is "+home.getApplicationTitle1());

		System.out.println("\t");

		CivilRights1.validateURL();

	}

	@AfterClass

	public void teardown() {

		driver.close();
	}
}
