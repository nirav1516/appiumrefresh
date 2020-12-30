package testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import init.SetupECommerce;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_tc1 extends SetupECommerce{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement ae = driver.findElementById("com.androidsample.generalstore:id/nameField");
		ae.sendKeys("nirav");
		driver.hideKeyboard();
		
		ae = driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"));
		ae.click();
		
		ae = driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry"));
		ae.click();
		
		ae = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"));");
		//new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))")); 
		ae.click();
		
		ae = driver.findElementByXPath("//android.widget.Button[@text=\"Let's  Shop\"]");
		ae.click();
		
	}

}
