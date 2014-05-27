package br.com.gsh.aghos.test.selenium.pessoaFisica;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PessoaFisicaTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	protected static DesiredCapabilities dCaps;

	@Before
	public void setUp() throws Exception {

		dCaps = new DesiredCapabilities();
		dCaps.setJavascriptEnabled(true);
		dCaps.setCapability("takesScreenshot", false);
		//dCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/home/pinheiro/Downloads/chromedriver");
		
		//System.setProperty("webdriver.chrome.driver", "/home/pinheiro/Downloads/chromedriver");
		//System.setProperty("phantomjs.binary.path", "/home/pinheiro/Downloads/phantomjs");
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/home/pinheiro/Downloads/chromedriver");
		driver = new PhantomJSDriver(dCaps);
		baseUrl = "http://assertselenium.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Ignore
	@Test
	public void getLinksOfAssertSelenium() throws Exception {
		driver.get(baseUrl + "/");
		// Getting all the links present in the page by a HTML tag.
		List links = driver.findElements(By.tagName("a"));

		// Printing the size, will print the no of links present in the page.
		System.out.println("Total Links present is " + links.size());

		// Printing the links in the page, we get through the href attribute.
		for (int i = 0; i > links.size(); i++) {
			System.out.println("Links are listed " + links.get(i));  //getAttribute("href"));
		}
	}
	
	@After
	public void teadDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			//fail(verificationErrorString);
		}
	} 

}