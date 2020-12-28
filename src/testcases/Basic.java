package testcases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import init.Setup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Basic extends Setup{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement e=  driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
		e.click();
		
		e=  driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']");
		e.click();
		
		e = driver.findElementById("android:id/checkbox");		
		e.click();
		
		e=  driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]"));//driver.findElementByXPath("(//android.widget.RelativeLayout)[2]");
		e.click();
		
		e = driver.findElement(By.className("android.widget.EditText"));
		e.setValue("Nirav");
		 
		//e= driver.findElement(By.id("android:id/button1"));
		
		List<AndroidElement> eL = driver.findElementsByClassName("android.widget.Button");
		e = eL.get(1);
		e.click();
	}

}
