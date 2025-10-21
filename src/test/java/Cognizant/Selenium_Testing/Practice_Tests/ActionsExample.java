package Cognizant.Selenium_Testing.Practice_Tests;

import java.sql.Driver;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {
	@Test
	public void dragAndDrop() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://training-support.net/webelements/drag-drop");
		driver.manage().window().maximize();  
		WebElement element=driver.findElement(By.id("ball"));
		WebElement drop1=driver.findElement(By.id("dropzone1"));
		WebElement drop2=driver.findElement(By.id("dropzone2"));
		Actions action=new Actions(driver);
//		action.dragAndDrop(element, drop1).perform();
//		action.clickAndHold(element).moveToElement(drop1).release().perform();
		
//		Thread.sleep(3000);
		
//		action.dragAndDrop(element, drop2).perform();
//		action.clickAndHold(element).moveToElement(drop2).release().perform();
		
		int widthOfTargetOne = drop1.getLocation().getX();
		int heightOfTargetOne = drop1.getLocation().getY();
		int ballWidth = element.getLocation().getX();
		int ballHeight = element.getLocation().getY();
		
		int widthOffSetX1 = widthOfTargetOne - ballWidth;
		int heightOffSetY1 = heightOfTargetOne - ballHeight;
	
		action.clickAndHold(element).moveByOffset(widthOffSetX1, heightOffSetY1).release().perform();
	
		Thread.sleep(2000);
		
		int widthOfTargetTwo = drop2.getLocation().getX();
		int heightOfTargetTwo = drop2.getLocation().getY();

		
		int widthOffSetX2 = widthOfTargetTwo - widthOfTargetOne;
		int heightOffSetY2 = heightOfTargetTwo - heightOfTargetOne;
		
		action.clickAndHold(element).moveByOffset(widthOffSetX2, heightOffSetY2).release().perform();
//		action.dragAndDropBy(drop2, widthOffSetX2, heightOffSetY2)
	}
}
