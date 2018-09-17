package util;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.appium.java_client.AppiumDriver;





public class UITest {
	AppiumDriver driver;
	 Logger log = Logger.getLogger(this.getClass());	
   public AppiumDriver   getDriver(){
	   return driver;
   }

    /**
     * init test case
     * 
     * @param driver
     */
    public void setDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public void init(AppiumDriver driver) {
       log.info("Start AppiumDriver");
        setDriver(driver);
    }

    /**
     * stop webdriver
     * 
     * @param driver
     */
    public void stop() {
        log.info("Stop AppiumDriver");
        driver.closeApp();

    }

    /**
     * @author Young
     */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(), path);
    }

    /**
     * @author Young
     * @param drivername
     * @param path
     */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        // this method will take screen shot ,require two parameters ,one is
        // driver name, another is file name
    	  Date date = new Date();
        String currentPath = System.getProperty("user.dir"); // get current work
        String picDir = currentPath+"\\results\\"+String.valueOf(DateUtil.getYear(date))+"-"
                +String.valueOf(DateUtil.getMonth(date))+"-"
                +String.valueOf(DateUtil.getDay(date));
        if(!new File(picDir).exists()){
            FileUtil.createDir(picDir);
        }
        
        log.info(currentPath);
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy
        try {
            log.info("save snapshot path is:" + picDir + path);
            FileUtils.copyFile(scrFile, new File(picDir + "\\" + path));
        } catch (Exception e) {
            log.error("Can't save screenshot");
            e.printStackTrace();
        } finally {
            log.info("screen shot finished");
        }
        
        

    }
//    private static class UITestLoad {
//        private static final UITest instance = new UITest();
//    }
//
//    public static UITest getInstance() {
//        return UITestLoad.instance;
//    }
}
