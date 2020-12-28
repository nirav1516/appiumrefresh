package testcases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import init.Setup;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

public class SwipeDemo1 extends Setup{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TouchAction ta = new TouchAction(driver);
		
		AndroidElement ae = driver.findElementByAndroidUIAutomator("text(\"Views\")");
		ae.click();
		
		//Date Widgets
		ae = driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")");
		ae.click();
		
		//2. Inline
		ae = driver.findElementByAndroidUIAutomator("text(\"2. Inline\")");
		ae.click();
		
		// content-desc 9, android.widget.RadialTimePickerView$RadialPickerTouchHelper
		/*List<AndroidElement> lae = driver.findElements(By.xpath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper"));
		ae = lae.get(8);
		ae.click();*/
		
		ae = driver.findElementByXPath("//*[@content-desc='9']");
		ae.click();
		
		System.out.println(ae.getAttribute("content-desc"));
		WebElement weFirstPosition = driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement weLastPosition = driver.findElement(By.xpath("//*[@content-desc='45']"));
		TouchAction holdMinute = ta.longPress(longPressOptions().withElement(element(weFirstPosition)).withDuration(ofSeconds(2))).moveTo(element(weLastPosition)).release();
		holdMinute.perform();
		
	}

}
