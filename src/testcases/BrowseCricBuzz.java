package testcases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import init.Setup;
import init.SetupMobileChrome;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowseCricBuzz extends SetupMobileChrome{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://cricbuzz.com");
		WebElement we = driver.findElementByXPath("//a[@href=\"#menu\"]");
		we.click();
		Thread.sleep(2000);
		//we = driver.findElement(By.name("pass"));
		we = driver.findElementByXPath("//a[text()=\"Home\"]");
		//we = driver.findElementByCssSelector("a[title='Cricbuzz Home']");
		we.click();
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,600)", "");
		we = driver.findElementByXPath("//h4[text()=\"Top Stories\"]");
		Assert.assertTrue(we.getAttribute("class").contains("header"));
		
		
	}

}
