package ruijia.www;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class NewTest {
	    private AndroidDriver<AndroidElement> driver;
	  @BeforeTest
	  public void setUp() throws Exception{
	      /* File classpathRoot = new File(System.getProperty("user.dir"));
	      System.out.println(classpathRoot);
	      File appDir = new File(classpathRoot, "/apps");
	      File app = new File(appDir, "");*/
	      DesiredCapabilities capabilities = new DesiredCapabilities();
	      
	      capabilities.setCapability("deviceName","udid");
	      capabilities.setCapability("platformVersion", "4.4");
	      capabilities.setCapability("udid","YT91050HXZ");
	      //capabilities.setCapability("app", app.getAbsolutePath());
	      capabilities.setCapability("appPackage", "com.example.yadudemo");
	      capabilities.setCapability("appActivity", ".MainActivity");
	      //capabilities.setCapability("appActivity", ".ui.activity.UPlusMainActivity");
	  driver = new AndroidDriver(new URL("http://127.0.0.1:4726/wd/hub"), capabilities);
	  }
	  
	  @Test
	  public void test() throws UnsupportedEncodingException {
	      //验证APP启动成功，并且MainActivity打开
	      if(activityVerify(8000, driver, ".MainActivity")==true)
	      {
	          System.out.println(driver.currentActivity().toString());
	          Assert.assertEquals(driver.currentActivity().toString(), ".MainActivity");
	          AndroidElement bt_config = driver.findElementByName("配置");
	          bt_config.click();
	          //验证ConfigActivity打开
	          if(activityVerify(3000, driver, ".ConfigActivity")==true)
	          {
	              Assert.assertEquals(driver.currentActivity().toString(), ".ConfigActivity");
	              List<AndroidElement> et_List = driver.findElementsByClassName("android.widget.EditText");
	              //输入密码
	              et_List.get(1).clear();
	              et_List.get(1).sendKeys("12345678");
	              //验证输入密码正确
	              Assert.assertEquals(et_List.get(1).getText(), "12345678");
	              //输入超时时间
	              et_List.get(2).clear();
	              et_List.get(2).sendKeys("12");
	              //验证超时时间输入正确
	              Assert.assertEquals(et_List.get(2).getText(), "12");
	              //如果button被键盘遮挡，关闭键盘
	              if(driver.findElementsByName("开始配置").isEmpty())
	              {
	                  driver.pressKeyCode(4);
	              }
	              //点击开始配置
	              AndroidElement bt_start_config = driver.findElementByName("开始配置");
	              bt_start_config.click();
	          }
	      }
	      //关闭APP
	      closeApp();
	      //验证APP已经关闭
	      Assert.assertNotEquals(driver.currentActivity().toString(), ".ConfigActivity");
	      Assert.assertNotEquals(driver.currentActivity().toString(), ".MainActivity");       
	  }

	  @AfterTest
	  public void tearDown() {
	      driver.quit();
	  }
	  //线程等待方法
	  public void appWait(long time)
	  {
	      try {
	          Thread.sleep(time);
	      } catch (InterruptedException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	  }
	  //关闭APP方法
	  public void closeApp()
	  {
	      for(int h=0;h<6;h++)
	      {
	          driver.pressKeyCode(4);
	      }
	  }
	  //验证activity方法
	 public Boolean activityVerify(long time,AndroidDriver<AndroidElement> tdriver,String activity)
	 {
	         for(int i=1;i<time/1000;i++){
	             appWait(1000);
	             if(tdriver.currentActivity().equals(activity))
	             {
	                 return true;
	             }    
	         }
	         System.out.println("can not find "+activity);
	         return false;
	     
	 }
	}
