package Cognizant.Selenium_Testing.Practice_Tests;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
	
//	@Test
	public void openGooglePage() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		WebElement inputElement=driver.findElement(By.id("APjFqb"));
		inputElement.sendKeys("Hello World..!");
		Actions actions=new Actions(driver);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Stay signed out']/parent::span/parent::div/parent::div")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2000));
		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/form/div[1]/div[1]/div[3]/center/input[1]")));
		element.click();
	}
}

///html/body/div[2]/div[4]/form/div[1]/div[1]/div[3]/center/input[1]