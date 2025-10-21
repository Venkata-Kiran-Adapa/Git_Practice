package Cognizant.Selenium_Testing.Practice_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExample {

	@Test
	public void selectMultiple() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://training-support.net/webelements/selects");
		driver.manage().window().maximize();
//		WebElement selectMultiplElement=driver.findElement(By.id("single-select"));
		WebElement selectMultiplElement=driver.findElement(By.xpath("//option[text()='Rust']/parent::select"));
		Select select=new Select(selectMultiplElement);
		select.selectByVisibleText("Rust");
		select.selectByIndex(2);
		select.selectByIndex(3);
		select.selectByValue("svelte");
		select.selectByVisibleText("TypeScript");
		Thread.sleep(3000);
		select.deselectByIndex(2);
		Thread.sleep(10000);
		driver.quit();
	}
	
//	@Test
	public void selectMultipleActivity18() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.get("https://v1.training-support.net/selenium/selects");
		driver.manage().window().maximize();
		System.out.println("Title of the page is : " + driver.getTitle());
		WebElement selectMultiplElement=driver.findElement(By.id("multi-select"));
//		WebElement selectMultiplElement=driver.findElement(By.xpath("//option[text()='Angular']/parent::select"));
		Select select=new Select(selectMultiplElement);
		select.selectByVisibleText("Javascript");
		select.selectByIndex(4);
		select.selectByIndex(5);
		select.selectByIndex(6);
		select.selectByValue("node");
		Thread.sleep(5000);
		select.deselectByIndex(5);
	}
	
	
}
