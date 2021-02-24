package testProject2;

import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

public class KA007Set2 {
	public AndroidDriver driver;
	
  @Test
  public void f() throws IOException, InterruptedException {
	  File file= new File("C:\\Users\\RohitLodhi\\eclipse-workspace\\Appium\\TestData.xlsx");
      FileInputStream fis= new FileInputStream(file);
      XSSFWorkbook wb= new XSSFWorkbook(fis);
      XSSFSheet sheet=wb.getSheetAt(0);
      int rc= sheet.getLastRowNum();      
      
      System.out.println(rc);
      for (int i=1;i<=rc;i++) {
          String username=sheet.getRow(i).getCell(0).getStringCellValue();
          String password=sheet.getRow(i).getCell(1).getStringCellValue();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
          System.out.println("before sign in");
          driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
          driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign in\")")).click();
          driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys(username);
          driver.findElementByAccessibilityId("Password").sendKeys(password);       	         
          //driver.hideKeyboard();
          driver.findElementByAccessibilityId("Sign in").click();   
          Thread.sleep(5000);
          driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
          driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Sign out\")")).click();
          driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"SIGN OUT\")")).click();
      }
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

  @AfterClass
  public void afterClass() {
	  driver.pressKey(new KeyEvent(AndroidKey.HOME));	  
  }

}
