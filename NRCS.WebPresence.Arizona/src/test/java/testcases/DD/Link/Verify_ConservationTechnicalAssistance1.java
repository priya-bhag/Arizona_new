package testcases.DD.Link;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import factory.BrowserFactory;
import factory.DataProviderFactory;
import pages1.DD.Link.ConservationTechnicalAssistance1;
import utility.Helper;

public class Verify_ConservationTechnicalAssistance1 {

	WebDriver driver;

	@BeforeClass

	public void SetUp() throws IOException

	{

		driver = BrowserFactory.getBrowser(DataProviderFactory.getExcel().getdata(1, 0, 0));

		driver.get(DataProviderFactory.getConfig().getApplicationUrl1()
				+ DataProviderFactory.getExcel().getdata(0, 14, 0));

		Helper.capturescreenshot(driver, "ConservationTechnicalAssistanceIN_Prod");

	}

	@Test(priority = 1)

	public void testHomePage() throws IOException, InterruptedException {

		ConservationTechnicalAssistance1 home = PageFactory.initElements(driver,
				ConservationTechnicalAssistance1.class);

		// System.out.println("Title of URL1 is "+home.getApplicationTitle1());

		System.out.println("\t");

		ConservationTechnicalAssistance1.validateURL();

	}

	@AfterClass

	public void teardown() {

		driver.close();
	}

}
