package testcases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import init.Setup;

public class TestSetUpJar {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		Setup st = new Setup();
		AndroidDriver<AndroidElement> driver = st.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		st.pritAwesome();

	}

}
