package ruijia.www;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import util.UITest;

public class Home extends UITest {
	private  static long sec=1000;
	public AppiumDriver driver; 
	@BeforeTest
	public void setUp() throws Exception{
		//set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot,"/app");
		File app = new File(appDir,"com.ruijia.door.apk");
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

		capabilities.setCapability("app",app.getAbsolutePath());
		
		//你想运行的Android应用的包名
		capabilities.setCapability("appPackage","com.ruijia.door");
		
		//你要从你的应用包中启动的 Android Activity 名称。
		capabilities.setCapability("appActivity", "com.ruijia.door.act.MainActivity");
		
		driver = new AndroidDriver(
				new URL("http://127.0.0.1:4723/wd/hub"),capabilities );
	}
	@Test
	 public void t2() throws Exception{
		 synchronized(this){
	           
		super.init(driver);
//		System.out.println(OpenDoor.this.getDriver());
//		for(int i=0;i<100;i++){
//			HashMap<String, Integer> keycode = new HashMap<String, Integer>();
//			keycode.put("KEYCODE_HOME", 3);
//			((JavascriptExecutor)driver).executeScript("mobile: keyevent", keycode);
//	   WebElement weblement=driver.findElementByName("轻触开门");
//		weblement.click();
		for(int i=0;i<100;i++){
		String cmdstr="adb shell input keyevent 3";
		//运行shell
		Runtime.getRuntime().exec(cmdstr).waitFor();
		Thread.sleep(1*sec);
		WebElement webElement=driver.findElementByName("睿视-测试");
		webElement.click();
		
	}
		 }
		}
	@AfterTest
	public void close() {
		super.stop();
		
	}

}
