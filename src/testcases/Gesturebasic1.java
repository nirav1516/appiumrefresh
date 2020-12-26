package testcases;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import init.Setup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class Gesturebasic1 extends Setup{

	public static void main(String[] args) throws MalformedURLException{
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction ta = new TouchAction(driver);
		
		AndroidElement ae = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		ae.click();
		
		
		WebElement we =  driver.findElementByXPath("//android.widget.TextView[@content-desc='Expandable Lists']");
		ta.tap(tapOptions().withElement(element(we))).perform();
		
		ae=  driver.findElementByXPath("//android.widget.TextView[@content-desc='1. Custom Adapter']");
		ae.click();
		
		we = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		//we.click();
		ta.longPress(longPressOptions().withElement(element(we)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());
		
		

	}

}
