package testcases;

//import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import init.SetupECommerce;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.offset.ElementOption.element;

import static io.appium.java_client.touch.TapOptions.tapOptions;

public class Ecommerce_tc6_hybrid extends SetupECommerce{
	HashSet<String> shoeNames = new HashSet<>();
	float totalAmount = 0;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		AndroidElement ae = driver.findElementById("com.androidsample.generalstore:id/nameField");
		ae.sendKeys("Nita");
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
		Ecommerce_tc6_hybrid ev = new Ecommerce_tc6_hybrid();
		//ev.addToCart(ae,driver,shoesText);
		//System.out.println("Total so far: "+ev.totalAmount);
		ev.addToCart(ae,driver,secondShoeText);
		System.out.println("Total so far: "+ev.totalAmount);
		ev.navigateToCart(ae, driver);
		
		TouchAction ta = new TouchAction(driver);
		WebElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		
		ta.tap(tapOptions().withElement(element(checkBox)));
		ta.perform();
		//com.androidsample.generalstore:id/termsButton
		
		ae = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
		ae.click();
		Thread.sleep(3000);
		ev.setDriverContext("web",driver);
		
		System.out.println(driver.getContext());
		WebElement we = driver.findElement(By.xpath("//input[@name='q']"));
		//WebElement we = driver.findElement(By.name("q"));
		we.sendKeys("Covid-19");
		//driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		we.sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		ev.setDriverContext("native", driver);
		System.out.println(driver.getContext());
		
	}
	
	public void addToCart(AndroidElement ae,AndroidDriver<AndroidElement> driver,String shoesText) {
		ae = driver
                .findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\""+ shoesText +"\"));");
		
		//Find parent of this shoeText
		AndroidElement parentElement = driver.findElement(By.xpath("//*[@text='"+ shoesText +"']/parent::android.widget.LinearLayout[1]"));
		
		//below commented part is another approch to get parent, first get list and then get the fisrt parent
		//List<MobileElement> lae = ae.findElements(By.xpath("./parent::*"));
		
		//System.out.println("the size: " +lae.size());
		//ae = lae.get(0);
		
		//once parent is found, search within parent to find Add to cart 
		System.out.println(ae.getAttribute("class"));
		ae = (AndroidElement) parentElement.findElement(By.xpath("//*[@text='ADD TO CART']"));
		System.out.println(ae.getAttribute("class"));
		ae.click();
		
		ae = (AndroidElement) parentElement.findElement(By.xpath("//*[@resource-id='com.androidsample.generalstore:id/productPrice']"));
		String sPrice = ae.getText().substring(1);
		float fPrice = Float.parseFloat(sPrice);
		totalAmount+=fPrice;
		shoeNames.add(shoesText);
	}
	
	
	public boolean isElementPresent(AndroidDriver<AndroidElement> driver, By locator) {
		try {
			AndroidElement ae = driver.findElement(locator);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void navigateToCart(AndroidElement ae, AndroidDriver<AndroidElement> driver) {
		By cartBy = By.xpath("//android.widget.TextView[@text='Cart']");
		if(!isElementPresent(driver, cartBy)) {
			ae = driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
			ae.click();
		}
		WebDriverWait wait = new WebDriverWait(driver,20,1000);
		
		//List<AndroidElement> lae = driver.findElementsById("com.androidsample.generalstore:id/productName");
		ae = (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(cartBy));
	}

	public void setDriverContext(String contextToSet,AndroidDriver<AndroidElement> driver) {
		Set<String> contextNames = driver.getContextHandles();
		System.out.println(contextNames.size());
		for(String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		    if(contextName.toUpperCase().contains(contextToSet.toUpperCase())) {
		    	driver.context(contextName);
		    	break;
		    }
		}

	}
	

}
