package testcases1.Arizona;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages1.Arizona.CivilRights1;
import pages1.Arizona.TeachersandStudents1;
import utility.Helper;

public class Verify_TeachersandStudents1 {

	WebDriver driver;

	@BeforeClass

	public void SetUp()

	{

		driver = BrowserFactory.getBrowser("firefox");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl1() + "main/az/people/teachers/");
		Helper.capturescreenshot(driver, "TeachersandStudentsAZ_Prod");

	}

	@Test(priority = 1)

	public void testHomePage() {

		TeachersandStudents1 home = PageFactory.initElements(driver, TeachersandStudents1.class);

		// System.out.println("Title of URL1 is "+home.getApplicationTitle1());

		System.out.println("\t");

		TeachersandStudents1.validateURL();

	}

	@AfterClass

	public void teardown() {

		driver.close();
	}
}
