package testProject;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MA001 {
	public AndroidDriver driver;
  @Test
  public void magento() {
	  driver.findElement(By.xpath("//*[@id=\"navbar\"]/button")).click();
	  driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[2]/a/span")).click();
	  driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[2]/div/div/div/div/ul/li[1]/ul/li[1]/a")).getText();
	  String expected="Small Business";
      String actual=driver.findElement(By.xpath("//*[@id=\"block-header\"]/ul/li[2]/div/div/div/div/ul/li[1]/ul/li[1]/a")).getText();
      Assert.assertEquals(actual, expected);
	  
  }
  
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities capability = new DesiredCapabilities();
      capability.setCapability(MobileCapabilityType.DEVICE_NAME,"Rohit");
      capability.setCapability(MobileCapabilityType.APPLICATION_NAME,"Android");
      capability.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
      driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);        
      driver.get("https://magento.com/");
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  
  }

}
