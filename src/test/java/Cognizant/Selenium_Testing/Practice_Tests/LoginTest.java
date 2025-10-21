package Cognizant.Selenium_Testing.Practice_Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	@Test
	public void loginTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form");
		String xpath1="(//button)[3]";
		String xpath2="//button[text()='Submit']";
		String xpath3="//button[@class='svelte-1pdjkmx']";
		String absoluteXPathString="/html/body/div/main/div/div/div/div/div[2]/form/button";
		WebElement inputElement1=driver.findElement(By.xpath(xpath1));
		WebElement inputElement2=driver.findElement(By.xpath(xpath2));
		WebElement inputElement3=driver.findElement(By.xpath(xpath3));
	}
}
