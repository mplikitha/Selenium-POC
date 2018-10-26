package com.capgemini.selenium.demo;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCsvDownload {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\likimp\\Downloads\\chromedriver_win32\\chromedriver.exe");

		String downloadFilepath = "C:\\Users\\likimp\\Downloads";

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);

		// Save Chrome Opions
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--test-type");

		ChromeOptions cap = new ChromeOptions();
		cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		WebDriver driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
//		driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/");
//		driver.findElement(By.linkText("smilechart.xls")).click();  
		driver.get("https://cg-gis-operations.atlassian.net/sr/jira.issueviews:searchrequest-csv-current-fields/21158/SearchRequest-21158.csv?tempMax=1000");
		driver.findElement(By.id("username")).sendKeys("ravi-kumar.sampath@capgemini.com");
		driver.findElement(By.id("login-submit")).click();
		WebElement password = driver.findElement(By.id("password"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("Dilip123");
		driver.findElement(By.id("login-submit")).click();
//		WebElement email_phone = driver.findElement(By.xpath("//input[@id='username']"));
//		email_phone.sendKeys("ravi-kumar.sampath@capgemini.com");
//		driver.findElement(By.id("login-submit")).click();
//		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.elementToBeClickable(password));
//		password.sendKeys("Dilip123");
//		driver.findElement(By.id("login-submit")).click();

	}

}
