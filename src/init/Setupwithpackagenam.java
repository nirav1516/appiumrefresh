package init;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Setupwithpackagenam {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		File srcPath = new File("src");
		File apkPath = new File(srcPath,"ApiDemos-debug.apk");
		String serverPath = "http://127.0.0.1:4723/wd/hub";
		URL serverURL = new URL(serverPath);
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "niravpixel3a8");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 25);
		//cap.setCapability(MobileCapabilityType.);
		//cap.setCapability(MobileCapabilityType.APP, apkPath.getAbsolutePath());
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(serverURL,cap);
		Activity act = new Activity("io.appium.android.apis", ".text.LogTextBox1");
		driver.startActivity(act);
		//return driver;

	}

}
