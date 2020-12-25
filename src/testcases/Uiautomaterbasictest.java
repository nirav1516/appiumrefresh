package testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import init.Setup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Uiautomaterbasictest extends Setup{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//AndroidElement e = driver.findElementByAndroidUIAutomator("attribute(value)");
		AndroidElement e = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		e.click();
		
	}

}
