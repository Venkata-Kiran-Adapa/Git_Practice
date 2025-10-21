package Cognizant.Selenium_Testing.Practice_Tests;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IframeExample {
	@Test
	public void iframeExample() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://training-support.net/webelements/iframes");
		driver.manage().window().maximize();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Frame1']")));
		WebElement btnElement1=driver.findElement(By.xpath("//button[text()='Click me!']"));
		btnElement1.click();
		driver.switchTo().defaultContent();
//		driver.switchTo().parentFrame();  Same as .defaultContent();
		Thread.sleep(2000);
		WebElement frame2=driver.findElement(By.xpath("//iframe[@title='Frame2']"));
		driver.switchTo().frame(frame2);
		WebElement btnElement2=driver.findElement(By.xpath("//button[text()='Click me!']"));
		btnElement2.click();
		
		
	}
}
