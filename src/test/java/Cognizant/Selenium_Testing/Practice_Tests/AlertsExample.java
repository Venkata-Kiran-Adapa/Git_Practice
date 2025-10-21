package Cognizant.Selenium_Testing.Practice_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AlertsExample {
	
	@Test
	public void alertsExample() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://training-support.net/webelements/alerts");
		driver.manage().window().maximize();
		WebElement simpleAlertElement=driver.findElement(By.id("simple"));
		simpleAlertElement.click();
//		WebElement confirmationAlertElement=driver.findElement(By.id("confirmation"));
//		confirmationAlertElement.click();
//		WebElement promptAlertElement=driver.findElement(By.id("prompt"));
//		promptAlertElement.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
//		alert.dismiss();
//		alert.sendKeys("Into Prompt alert");
//		alert.accept();
		
	}

}
