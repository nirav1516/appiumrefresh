package testcases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import init.Setup;
import init.SetupMobileChrome;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Browsebasic extends SetupMobileChrome{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
		WebElement we = driver.findElementByXPath("//*[@id=\"m_login_email\"]");
		we.sendKeys("nirav");
		Thread.sleep(2000);
		//we = driver.findElement(By.name("pass"));
		we = driver.findElementByXPath("//*[@type='password']");
			// driver.findElementByName("pass");
		we.sendKeys("try");
		
		we = driver.findElementByXPath("//button[@value=\"Log In\"]");
		we.click();
	}

}
