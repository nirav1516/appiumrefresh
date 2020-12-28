package testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import init.Setup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollDemo {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		Setup sp = new Setup();
		AndroidDriver<AndroidElement> driver = sp.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction ta = new TouchAction(driver);
		
		AndroidElement ae = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		ae.click();
		
		ae = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		ae.click();
		
		//
			

	}

}
