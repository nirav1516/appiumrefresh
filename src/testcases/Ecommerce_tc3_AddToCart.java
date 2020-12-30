package testcases;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import init.SetupECommerce;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_tc3_AddToCart extends SetupECommerce{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		
		ae = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"));");
		//new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))")); 
		ae.click();
		
		ae = driver.findElementByXPath("//android.widget.Button[@text=\"Let's  Shop\"]");
		ae.click();
		
		String shoesText = "Converse All Star";
		String secondShoeText = "Air Jordan 4 Retro";
		ae = driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\""+ shoesText +"\"));");
		//ae = (AndroidElement) ae.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']"));
		//ae.click();
		
		//List<And> lae = (AndroidElement) ae.findElement(By.xpath("./parent::*"));
		ae = driver.findElement(By.xpath("//*[@text='"+ shoesText +"']/parent::android.widget.LinearLayout[1]"));
				//List<MobileElement> lae = ae.findElements(By.xpath("./parent::*"));
		
		//System.out.println("the size: " +lae.size());
		//ae = lae.get(0);
		System.out.println(ae.getAttribute("class"));
		ae = (AndroidElement) ae.findElement(By.xpath("//*[@text='ADD TO CART']"));
		System.out.println(ae.getAttribute("class"));
		ae.click();
		
		
		//com.androidsample.generalstore:id/appbar_btn_cart
		ae = driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
		ae.click();
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,10,1000);
		ae = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='"+ shoesText +"']") ));
		//ae = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression))
		//ae = driver.findElement(By.xpath("//android.widget.TextView[@text='"+ shoesText +"']"));
		Assert.assertEquals(shoesText, ae.getText());
		System.out.println(ae.getText());
		
		ae = driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_back"));
		ae.click();
		ae = driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\""+ shoesText +"\"));");
		
		ae = driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\""+ secondShoeText +"\"));");
		
		
	}

}
