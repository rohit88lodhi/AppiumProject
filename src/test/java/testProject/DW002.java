package testProject;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class DW002 {
	public AndroidDriver driver;
  @Test
  public void registerandlogout() {
	  driver.findElement(By.xpath("//*[@id='Email']")).sendKeys("xy49312@gmail.com");
      driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("xyz123");
      driver.hideKeyboard();
      driver.findElement(By.xpath("//input[@value='Log in']")).click();
      String expected="xy49312@gmail.com";
      String actual=driver.findElement(By.xpath("//a[text()='xy49312@gmail.com']")).getText();
      Assert.assertEquals(actual, expected);	  
	  
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities capability = new DesiredCapabilities();
      capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Rohit");
      capability.setCapability(MobileCapabilityType.APPLICATION_NAME,"Android");
      capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
      driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);        
      driver.get("http://demowebshop.tricentis.com/login");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	  
  }

  
  @AfterClass
  public void afterClass() {
	  driver.findElement(By.linkText("Log out")).click();
	  driver.close();
	  
  }
}
