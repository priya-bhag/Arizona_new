package testcases1.Iowa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages.Agronomy;
import pages.EventsDeadlines;
import pages1.Iowa.EventsDeadlines1;
import utility.Helper;

public class Verify_EventsDeadlines1 {

	WebDriver driver;

	@BeforeClass

	public void SetUp()

	{

		driver = BrowserFactory.getBrowser("firefox");

		driver.get(DataProviderFactory.getConfig().getApplicationUrl1() + "events/ia/newsroom/events/");

		Helper.capturescreenshot(driver, "EventsDeadLinesIN_Prod");

	}

	@Test(priority = 1)

	public void testHomePage() {

		EventsDeadlines1 home = PageFactory.initElements(driver, EventsDeadlines1.class);

		System.out.println("\t");

		EventsDeadlines1.validateURL();

		// Agronomy.getApplicationTitle2();

		System.out.println("\t");

	}

	@AfterClass

	public void teardown() {

		driver.close();

	}
}