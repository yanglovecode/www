package ruijia.www;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebTest {
	private static long sec=1000;
	@Test
	public void  web() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","E:\\androi  maven\\www\\source\\chromedriver.exe");
	//chromePath为Chrome Driver的绝对路径
	ChromeDriver chromeDriver=new ChromeDriver();
	chromeDriver.manage().window().maximize();
	chromeDriver.get("https://www.baidu.com");
	for (int i = 1; i < 4204; i++) {
		 synchronized(this){
			 wait(1*sec);
	            this.notifyAll();
	            //查找物业公告菜单项并点击
	            WebElement  webElement=chromeDriver.findElement(By.xpath("//*[@id=\"acs-announcement\"]/a"));
	            webElement.click();
	            wait(1*sec);
	            this.notifyAll();
	            //查找门禁机公告菜单项并点击
	            webElement=chromeDriver.findElement(By.linkText("门禁机公告"));
	            webElement.click();
	            //查找新增公告菜单项并点击
	            webElement=chromeDriver.findElement(By.linkText("新增公告"));
	            webElement.click();
	            wait(1*sec);
	            this.notifyAll();
	            //选择物业
	            String listValue = "最新测试物业";
	            Select select = new Select(chromeDriver.findElement(By.id("property")));
	            select.selectByVisibleText(listValue);
	            wait(1*sec);
	            this.notifyAll();
	            //选择小区
	            String listValue1 = "最新测试小区";
	            select = new Select(chromeDriver.findElement(By.id("community")));
	            select.selectByVisibleText(listValue1);
	            webElement=chromeDriver.findElement(By.xpath("//*[@id=\"loadingDate\"]"));
	            webElement.click();
	            webElement.sendKeys("2017");
	            webElement.sendKeys(Keys.chord(Keys.TAB));
	            webElement.sendKeys("04");
	            webElement.sendKeys("08");
	            webElement=chromeDriver.findElement(By.xpath("//*[@id=\"unloadingDate\"]"));
	            webElement.click();
	            webElement.sendKeys("2017");
	            webElement.sendKeys(Keys.chord(Keys.TAB));
	            webElement.sendKeys("04");
	            webElement.sendKeys("08");
	            webElement=chromeDriver.findElement(By.xpath("//*[@id=\"announcementTitle\"]"));
	            webElement.sendKeys("123");
	            webElement=chromeDriver.findElement(By.xpath("//*[@id=\"picture\"]"));//*[@id="doorPicture"]
	            Coordinates coor = ((Locatable)webElement).getCoordinates();  
	            coor.inViewPort();  
	            webElement.click();
	            webElement=chromeDriver.findElement(By.xpath("//*[@id=\"doorPicture\"]"));
	            coor = ((Locatable)webElement).getCoordinates();  
	            coor.inViewPort();  
	            webElement.sendKeys("E:\\人脸\\浓妆\\已录入.jpg");
	            wait(5*sec);
	            this.notifyAll();
	            webElement=chromeDriver.findElement(By.xpath("//*[@id=\"doorAnnouncementSave\"]/div[2]/div/input"));
	            webElement.click();
	        }
		 }
	}
}

