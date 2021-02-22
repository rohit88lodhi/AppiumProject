package testProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class KA007 {
	
	public AndroidDriver driver;
	@Test
	public void PraxisCoreWritingtest() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("org.khanacademy.android:id/tab_bar_button_search")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Test prep\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Praxis Core Writing\")")).click();
		String expected="About the Praxis Core Writing test";
	    String actual=driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"About the Praxis Core Writing test\")")).getText();
	    Assert.assertEquals(actual, expected);
	    System.out.println("actual text is: "+ actual +" and expected text is: "+ expected);
	}
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		DesiredCapabilities capability = new DesiredCapabilities();        
        capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Rohit");
        capability.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capability.setCapability(MobileCapabilityType.NO_RESET,true);
        capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"org.khanacademy.android");
        capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"org.khanacademy.android.ui.library.MainActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);  
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	
}
