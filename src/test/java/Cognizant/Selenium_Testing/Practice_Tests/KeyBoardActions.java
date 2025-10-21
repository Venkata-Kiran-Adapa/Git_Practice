package Cognizant.Selenium_Testing.Practice_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {

//		@Test
		public void copyNPaste() throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.get("https://training-support.net/webelements/dynamic-attributes");
			driver.manage().window().maximize();
			WebElement nameFieldElement=driver.findElement(By.xpath("//input[@placeholder='Full name']"));
			WebElement emailFieldElement=driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
			WebElement addressFieldElement=driver.findElement(By.xpath("//textarea"));
			nameFieldElement.sendKeys("Vk");
			nameFieldElement.sendKeys(Keys.CONTROL,"a");
			nameFieldElement.sendKeys(Keys.CONTROL,"c");
			emailFieldElement.sendKeys(Keys.CONTROL,"v");
			Thread.sleep(1000);
			emailFieldElement.sendKeys("@gmail.com");
			Thread.sleep(1000);
			addressFieldElement.sendKeys(Keys.CONTROL,"v");
			Thread.sleep(1000);
			nameFieldElement.sendKeys(Keys.CONTROL,"a");
			nameFieldElement.sendKeys(Keys.BACK_SPACE);
		}
		
		@Test
		public void copyNPasteUsingActions() {
			WebDriver driver=new ChromeDriver();
			driver.get("https://training-support.net/webelements/dynamic-attributes");
			driver.manage().window().maximize();
			WebElement nameFieldElement=driver.findElement(By.xpath("//input[@placeholder='Full name']"));
			WebElement emailFieldElement=driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
			WebElement addressFieldElement=driver.findElement(By.xpath("//textarea"));
			WebElement submitBtnElement=driver.findElement(By.xpath("//button[text()='Submit']"));
			Actions action=new Actions(driver);
			nameFieldElement.sendKeys("Vk");
			action.keyDown(nameFieldElement,Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();
			action.keyDown(emailFieldElement,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
			emailFieldElement.sendKeys("@gmail.com");
			action.keyDown(addressFieldElement,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).click(submitBtnElement).perform();
			
		}
}
