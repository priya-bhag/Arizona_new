package pages1.DD;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.DataProviderFactory;
import junit.framework.Assert;
import utility.Helper;

public class LocalServiceCenters1 {
	static WebDriver driver;

	public LocalServiceCenters1(WebDriver Idriver) {
		this.driver = Idriver;
	}
	// Prod Elements

	@FindBy(xpath = ".//*[@id='overview']/h2/a")
	static WebElement headingProd;

	@FindBy(xpath = ".//*[@id='traversed']")
	static WebElement BreadCrumbProd;

	/*@FindBy(xpath = ".//*[@id='overview']/p[2]")
	static WebElement MapProd;
*//*
	@FindBy(xpath = ".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[6]/td/table/tbody/tr/td/div/p")
	static WebElement Table_LeftHeaderProd;

	@FindBy(xpath = ".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[6]/td/table/tbody/tr/td/div/ul/li/a")
	static List<WebElement> Table_LeftelementsProd;*/

	@FindBy(xpath = ".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[3]/table/tbody/tr/td/table/tbody/tr/td")
	static WebElement INProd;

	// Test Elements

	@FindBy(xpath = ".//*[@id='overview']/h2[1]/a")
	static WebElement headingTest;

	/*@FindBy(xpath = ".//*[@id='overview']/p[2]")
	static WebElement MapTest;*/

	@FindBy(xpath = ".//*[@id='traversed']")
	static WebElement BreadCrumbTest;

	/*@FindBy(xpath = ".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[6]/td/table/tbody/tr/td/div/p")
	static WebElement Table_LeftHeaderTest;

	@FindBy(xpath = ".//*[@id='mainContent']/table/tbody/tr/td/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[6]/td/table/tbody/tr/td/div/ul/li/a")
	static List<WebElement> Table_LeftelementsTest;*/

	@FindBy(xpath = ".//*[@id='layoutContainers']/div/table/tbody/tr/td/table/tbody/tr/td/div/section/div[2]/div[2]/div[2]")
	static WebElement INTest;

	// Comparison Arrays

	public static List<String> LinksArrayProd = null;

	public static List<String> LinksArrayTest = null;

	public static List<String> BreadCrumbArrayProd = null;

	public static List<String> BreadCrumbArrayTest = null;

	public static void validateProd() throws IOException, InterruptedException {

		Logger log = Logger.getLogger("LocalServiceCenters1");

		String title1 = driver.getTitle();

		String heading1 = headingProd.getText();

		List<String> BreadCrumbArrayProd = new ArrayList<String>();

		List<WebElement> BreadCrumbProd_elements = BreadCrumbProd.findElements(By.tagName("p"));

		for (int i = 0; i <= (BreadCrumbProd_elements).size() - 1; i++) {

			String text = BreadCrumbProd_elements.get(i).getText();

			String NewText = text.trim();

			BreadCrumbArrayProd.add(NewText);

		}

		log.info("The breadcrumb of Prod is " + BreadCrumbArrayProd);

		log.info("\t");

		/*boolean IsMApPresentProd = MapProd.isDisplayed();

		if (!IsMApPresentProd == true) {

			
			 * log.info("map is present on the page right side : Prod"); } else{
			 
			log.info("map is not  present on the page right side : Prod");

		}*/

		/*boolean RelatedHeaderProd = Table_LeftHeaderProd.isDisplayed();

		if (!RelatedHeaderProd == true) {

			
			 * log.info("RelatedHeader is present on the page right side : Prod"
			 * ); } else{
			 
			log.info("RelatedHeader is not  present on the page right side : Prod");

		}

		List<String> ArrayProd = new ArrayList<String>();

		List<WebElement> Table_LeftelementsProd_elements = Table_LeftelementsProd;

		for (int i = 0; i <= (Table_LeftelementsProd_elements).size() - 1; i++) {

			String text = Table_LeftelementsProd_elements.get(i).getText();

			String NewText = text.trim();

			ArrayProd.add(NewText);

		}*/

		/*
		 * log.info("The links inside Related links  of prod are " +ArrayProd);
		 * 
		 * log.info("\t");
		 * 
		 */

		List<String> LinksArrayProd = new ArrayList<String>();

		List<WebElement> tableItems_Prod = INProd.findElements(By.tagName("a"));

		tableItems_Prod.addAll(INProd.findElements(By.tagName("img")));

		int count = 0;
		int c1 = 0;
		int c2 = 0;
		int counter_valid1 = 0;

		StringBuilder buildresponsesProd = new StringBuilder();

		for (int j = 0; j <= tableItems_Prod.size() - 1; j++) {

			WebElement element1 = tableItems_Prod.get(j);

			String link_Prod = element1.getAttribute("href");

			if (link_Prod == null || link_Prod.isEmpty()) {

				// log.info("URL is either not configured for anchor tag or it
				// is empty");

				c1 = c1 + 1;

				continue;
			}

			if (link_Prod.contains("@")) {
				// log.info("Link is an email");

				c2 = c2 + 1;

				continue;

			}

			count = count + 1;

			// verifyLinkActive(Prod);

			try {

				URL url = new URL(link_Prod);

				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

				httpURLConnect.setConnectTimeout(3000);

				httpURLConnect.connect();

				if (httpURLConnect.getResponseCode() >= 400) {
					// log.info(link_Prod+" -
					// "+httpURLConnect.getResponseMessage());
					buildresponsesProd.append(link_Prod + "__" + httpURLConnect.getResponseMessage() + "\n");

				} else {
					buildresponsesProd.append(link_Prod + "__" + httpURLConnect.getResponseMessage() + "\n");

					// log.info(link_Prod+"-"+httpURLConnect.getResponseMessage());

					if (httpURLConnect.getResponseMessage().contains("OK")) {

						counter_valid1 = counter_valid1 + 1;
					}
				}

			}

			catch (Exception e) {
				e.toString();
			}

		} /*
			 * log.info("No of emails are "+c2);
			 * 
			 * 
			 * //log.
			 * info("Number of URL is either not configured for anchor tag or it is empty are "
			 * +c1);
			 * 
			 * //log.info("v is "+v);
			 * 
			 * // log.info("first url arrays are "+LinksArrayProd);
			 * 
			 * /* String contentProd =INProd.getText(); String NewcontentProd
			 * =contentProd.trim(); log.info("The contents in Prod are ");
			 * log.info(NewcontentProd); log.info("\t");
			 * 
			 */

		// Test Methods

		driver.get(DataProviderFactory.getConfig().getApplicationUrl3()
				+ DataProviderFactory.getExcel().getdata(0, 41, 1));

		Helper.capturescreenshot(driver, "LocalServiceCentersIN_Test");

		String heading2 = headingTest.getText();

		String title2 = driver.getTitle();

		log.info("Title of Prod is " + title1);

		log.info("\t");

		log.info("Title of Test is " + title2);
		log.info("\t");

		/*
		 * 
		 * log.info("Heading of Prod is "+heading1); log.info("\t");
		 * 
		 * 
		 * 
		 * log.info("Heading of Test is " +heading2); log.info("\t");
		 */
		if (!(heading1.equals(heading2))) {

log.info("heading of both urls are  not same := "+ " Prod : " +heading1 + ", Test: " +heading2 );		}

		/*
		 * log.info("heading of both urls are same");
		 * 
		 * }else{ log.info("heading of both urls are  not same");
		 * 
		 * 
		 * }
		 * 
		 */
		// log.info("\t");

		if (!(title1.equals(title2))) {

			/*
			 * log.info("Titles of both URLs are same"); }else{
			 */
			log.info("Titles of both URLs are not same");

		}

		log.info("\t");

		List<String> BreadCrumbArrayTest = new ArrayList<String>();

		List<WebElement> BreadCrumbTest_elements = BreadCrumbTest.findElements(By.tagName("p"));

		for (int i = 0; i <= (BreadCrumbTest_elements).size() - 1; i++) {

			String text = BreadCrumbTest_elements.get(i).getText();

			String NewText = text.trim();

			BreadCrumbArrayTest.add(NewText);

		}

		/*
		 * log.info("The breadcrumb of Test is " +BreadCrumbArrayTest);
		 * 
		 * log.info("\t");
		 * 
		 */
/*
		boolean IsMApPresentTest = MapTest.isDisplayed();

		if (!IsMApPresentTest == true) {

			
			 * log.info("map is present on the page right side : Test"); } else{
			 

			log.info("map is not  present on the page right side : Test");

		}
*/
		/*boolean RelatedHeaderTest = Table_LeftHeaderTest.isDisplayed();

		if (!RelatedHeaderTest == true) {

			
			 * log.info("RelatedHeader is present on the page right side : Test"
			 * ); } else{
			 
			log.info("RelatedHeader is not  present on the page right side : Test");

		}

		List<String> ArrayTest = new ArrayList<String>();

		List<WebElement> Table_LeftelementsTest_elements = Table_LeftelementsTest;

		for (int i = 0; i <= (Table_LeftelementsTest_elements).size() - 1; i++) {

			String text = Table_LeftelementsTest_elements.get(i).getText();

			String NewText = text.trim();

			ArrayTest.add(NewText);

		}
*/
		/*
		 * log.info("The links inside Related links  of Test are " +ArrayTest);
		 * 
		 * log.info("\t");
		 * 
		 */
/*
		Boolean v = Arrays.equals(ArrayProd.toArray(), ArrayTest.toArray());

		try {

			if (!v == true) {

				
				 * log.info("Related links  on both Env: are same"); }
				 * 
				 * 
				 * if(v==false){
				 
				log.info("Related links  of both Env: are not same");

			}

		} catch (Exception e) {

			log.info("The exception is " + e.getMessage());

		}
*/
		Boolean value2 = Arrays.equals(BreadCrumbArrayTest.toArray(), BreadCrumbArrayProd.toArray());

		try {

			if (!value2 == true) {

				/*
				 * log.info("Breadcrumb on both Env: are same"); }
				 * 
				 * 
				 * if(value2==false){
				 */
				log.info("Breadcrumb of both Env: are not same");

			}

		} catch (Exception e) {

			log.info("The exception is " + e.getMessage());

		}

		log.info("\t");
		

		

		List<String> LinksArrayTest = new ArrayList<String>();

		List<WebElement> tableItems_Test = INTest.findElements(By.tagName("a"));

		tableItems_Test.addAll(INTest.findElements(By.tagName("img")));

		int count1 = 0;
		int c3 = 0;
		int c4 = 0;
		int counter_valid2 = 0;

		StringBuilder buildresponsesTest = new StringBuilder();

		for (int j = 0; j <= tableItems_Test.size() - 1; j++) {

			WebElement element1 = tableItems_Test.get(j);

			String link_Test = element1.getAttribute("href");
			;

			if (link_Test == null || link_Test.isEmpty()) {
				// log.info("URL is either not configured for anchor tag or it
				// is empty");
				c3 = c3 + 1;
				continue;
			}

			if (link_Test.contains("@")) {
				// log.info("Link is an email");

				c4 = c4 + 1;
				continue;
			}

			LinksArrayTest.add(link_Test);
			count1 = count1 + 1;

			// verifyLinkActive(link_Test);

			try {

				URL url1 = new URL(link_Test);

				HttpURLConnection httpURLConnect = (HttpURLConnection) url1.openConnection();

				httpURLConnect.setConnectTimeout(3000);

				httpURLConnect.connect();

				if (httpURLConnect.getResponseCode() >= 400) {

					buildresponsesTest.append(link_Test + "__" + httpURLConnect.getResponseMessage() + "\n");

					// log.info(link_Test+" -
					// "+httpURLConnect.getResponseMessage());

				} else {

					// log.info(link_Test+"-"+httpURLConnect.getResponseMessage());

					buildresponsesTest.append(link_Test + "__" + httpURLConnect.getResponseMessage() + "\n");

					if (httpURLConnect.getResponseMessage().contains("OK")) {

						counter_valid2 = counter_valid2 + 1;
					}
				}

			}

			catch (Exception e) {
				e.toString();
			}

		}

		/*
		 * log.info("No of links in Test are "+count1);
		 * 
		 * //log.info("No of links with href null Test are "+c3);
		 * 
		 * 
		 * log.info("No of email  links in Test are "+c4);
		 * 
		 * 
		 * 
		 * log.info("Total number of of Valid links in Test are "+counter_valid2
		 * );
		 */

		// log.info(LinksArrayTest);

		log.info("\t");

		try {
			if (!(count == count1)) {
				/*
				 * log.
				 * info("Both Env: has got same number of internal and external links"
				 * ); }
				 * 
				 * else{
				 */
				log.info("No of links doesnt match in both Env:");
				log.info("Total number of of links in Prod are " + count);
				log.info("Total number of of links in Test are " + count1);

				log.info(buildresponsesProd);
				log.info(buildresponsesTest);

			}

		} catch (Exception e) {

			log.info(e.getMessage());
		}

		try {
			if (!(counter_valid1 == counter_valid2)) {
				/*
				 * log.info("Both Env: has got same number of valid links"); }
				 * 
				 * else{
				 */

				log.info("No of valid links doesnt match in both env:");

				log.info("Total number of of Valid links in Prod are " + counter_valid1);
				log.info("Total number of of Valid links in Test are " + counter_valid2);
				log.info(buildresponsesProd);
				log.info(buildresponsesTest);

			}

		} catch (Exception e) {

			log.info(e.getMessage());
		}

		try {
			if (!(c2 == c4)) {/*
								 * 
								 * log.
								 * info("Both Env: has got same number of email links"
								 * ); }
								 * 
								 * else{
								 */

				log.info("No of email links does not match in both Env:");
				log.info("No of email links " + c2);
				log.info("No of email links " + c4);

			}

		} catch (Exception e) {

			log.info(e.getMessage());
		}

	}
}
