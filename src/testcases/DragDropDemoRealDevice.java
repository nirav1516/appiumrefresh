package testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import init.Setup;
import init.SetupRealDevice;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;


public class DragDropDemoRealDevice extends SetupRealDevice{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilitiesRealDevice();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction ta = new TouchAction(driver);
		
		AndroidElement ae = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		ae.click();
		
		ae = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drag and Drop\"));");
		ae.click();
		
		//io.appium.android.apis:id/drag_dot_1
		WebElement weFrom = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement weTo = driver.findElementById("io.appium.android.apis:id/drag_dot_3");
		ta.longPress(longPressOptions().withElement(element(weFrom)).withDuration(ofSeconds(2))).moveTo(element(weTo)).release();
		ta.perform();

	}

}
