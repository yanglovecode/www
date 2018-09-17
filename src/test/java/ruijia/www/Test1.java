package ruijia.www;

import java.io.File;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.hamcrest.SelfDescribing;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.ScreenshotListener;

import util.TestNGListeners;
import util.UITest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


@Listeners({TestNGListeners.class}) 
public class Test1 extends UITest{
	//用AppiumDriver类，主要针对手势操作，比如滑动、长按、拖动
		public AppiumDriver driver; 
		@BeforeTest
		public void setUp() throws Exception{
			//set up appium
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot,"/app");
			File app = new File(appDir,"smartdoor-latest.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appPackage", "com.ruijia.door");
			capabilities.setCapability("appActivity", ".act.MainActivity");
			
			//平台的名称：iOS, Android, or FirefoxOS
			capabilities.setCapability("platformName", "Android");
			
			//移动设备的系统版本号，7.1, 4.4
			capabilities.setCapability("platformVersion", "6.0");
			
			//IOS：instruments -s devices，Android:随便写
			capabilities.setCapability("deviceName", "Lexv X500");
			
			//模拟器的名字
			//capabilities.setCapability("avd", "appium");
			
			//比如/abs/path/to/my.apk或http://myapp.com/app.ipa 

			//capabilities.setCapability("app",app.getAbsolutePath());
			
			//你想运行的Android应用的包名
			//capabilities.setCapability("appPackage","com.comb.live");
			
			//你要从你的应用包中启动的 Android Activity 名称。
			//capabilities.setCapability("appActivity", "com.comb.live.ui.activity.Startactivity");
			
			driver = new AndroidDriver(
					new URL("http://127.0.0.1:4723/wd/hub"),capabilities );
		}
		
		@Test
		 public void t1() throws Exception{
			super.init(driver);
			System.out.println(Test1.this.getDriver());
			WebElement weblement=driver.findElementById("com.ruijia.door:id/menu");
			weblement.click();
			 weblement=driver.findElementById("com.ruijia.door:id/communit");
			 weblement.click();
		}
		@AfterTest
		public void close() {
			super.stop();
			
		}

}
