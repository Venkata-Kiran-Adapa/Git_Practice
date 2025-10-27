//package Cognizant.Practice;
//
//import static org.testng.Assert.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class LoginTestTwo {
//	
//	WebDriver driver;
//	@BeforeClass
//	public void createDriver() {
//		driver=new EdgeDriver();
//		driver.get("https://training-support.net/webelements/login-form/");
//	}
//	
//	@Test
//	public void loginTest() throws InterruptedException {
//		driver.findElement(By.id("username")).sendKeys("admin1");
//		driver.findElement(By.id("password")).sendKeys("password");
//		driver.findElement(By.xpath("//button[text()='Submit']")).click();
//		Thread.sleep(1000);
//		String text=driver.findElement(By.tagName("h2")).getText();
//		System.out.println(text);
//		assertNotEquals(text, "Welcome Back, Admin!");
//	}
//	
//	@AfterClass
//	public void close() {
//		driver.quit();
//	}
//}
