package br.com.gsh.aghos.test.selenium.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumConfig {

	public static final String SERVER_JENKINS = "http://192.168.0.44/aghos";
	public static final String SERVER_LOCAL = "http://127.0.0.1:8080/aghos";
	public static final long TIMER_SLEEP = 600;

	public static final String SERVER = SERVER_LOCAL;

	private static WebDriver driver;
	
	public static WebDriver getDriverFirefox() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(SeleniumConfig.SERVER + "/aghos/login");
		return driver;
	}

	public static WebDriver getDriverChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\dev\\tools\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(SeleniumConfig.SERVER + "/login");
		return driver;
	}
	
	public static WebDriver getDriver(){
		driver = getDriverFirefox(); 
//		driver = getDriverChrome(); 
		return driver;
	}
	
	public static Boolean isFirefox() {
		return driver instanceof FirefoxDriver;
	}
}
