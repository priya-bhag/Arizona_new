package testcases1.Arizona;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.WatershedProtectionandFloodPreventionProgram;
import pages.WatershedSurveysandPlanning;
import pages1.Arizona.WatershedSurveysandPlanning1;
import utility.Helper;

public class Verify_WatershedSurveysandPlanning1 {

	WebDriver driver;

	@BeforeClass

	public void SetUp()

	{

		driver = BrowserFactory.getBrowser("firefox");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl1() + "main/az/programs/planning/wsp/");
		Helper.capturescreenshot(driver, "WatershedSurveysAndPlanningAZ_Prod");

	}

	@Test(priority = 1)

	public void testHomePage() {

		WatershedSurveysandPlanning1 home = PageFactory.initElements(driver, WatershedSurveysandPlanning1.class);

		// System.out.println("Title of URL1 is "+home.getApplicationTitle1());

		System.out.println("\t");

		WatershedSurveysandPlanning1.validateURL();

		System.out.println("\t");

	}

	@AfterClass

	public void teardown() {

		driver.close();

	}
}
