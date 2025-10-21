package Cognizant.Selenium_Testing.Practice_Tests;
//package Cognizant.Selenium_Testing.Practice_Tests-Testing.Practice_Tests;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IRCTCFlightSearchAutomation {
	
	@Test
	public void testIRCTC() throws InterruptedException {
		WebDriver driver=new EdgeDriver();
	    String baseUrl="https://www.air.irctc.co.in";
	    driver.get(baseUrl);
	    driver.manage().window().maximize();
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//	    wait.until(ExpectedConditions.elementToBeClickable(By.name("From"))).sendKeys("Hyd");
	    WebElement originElement=driver.findElement(By.name("From"));
	    originElement.sendKeys("Hyd");
	    Thread.sleep(1000);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//ul[@id='ui-id-1']/child::li)[1]"))).click();
//	    WebElement fromBtnElement=driver.findElement(By.xpath(" (//ul[@id='ui-id-1']/child::li)[1]"));
//	    fromBtnElement.click();
	  
	    WebElement destinationElement=driver.findElement(By.name("To"));
	    destinationElement.sendKeys("Pune");
	    Thread.sleep(1000);
//	    
//	    WebElement toBtnElement=driver.findElement(By.xpath(" (//ul[@id='ui-id-2']/child::li)[1]"));
//	    toBtnElement.click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//ul[@id='ui-id-2']/child::li)[1]"))).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'active-red')]"))).click();
//	    driver.findElement(By.xpath("//span[contains(@class,'active-red')]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noOfpaxEtc"))).click();
//	    driver.findElement(By.id("noOfpaxEtc")).click();
	    Select select=new Select(driver.findElement(By.id("travelClass")));
	    select.selectByVisibleText("Business");
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search ']")));
	    driver.findElement(By.xpath("//button[text()='Search ']")).click();
	    Thread.sleep(2000);
	    
	    List<WebElement> resultList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='right-searchbarbtm']")));


	    Thread.sleep(2000);
	    Set<WebElement> set=new HashSet<>();
	    Set<String> set2=new HashSet<>();
	    System.out.println(resultList.size());
//	    String originCheck=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stationFrom"))).getText();
	    for(WebElement ele:resultList) {
	    	set.add(ele);
	    	
	    	String flightName=ele.findElement(By.xpath("//div/div/div[2]/b")).getText();
	    	String flightCode=ele.findElement(By.xpath("//div[@class='right-searchbarbtm-in']/child::div/child::div[2]/child::span")).getText();
//	    	set2.add(flightName);
	    	System.out.println(flightName+"-"+flightCode);
//	    	System.out.println("Available flights: "+flightName);
//	    	System.out.println("Flight Code: "+flightCode);
	    }
	    
	    
	    System.out.println(set.size());
	    System.out.println(set2);
	    Thread.sleep(5000);
	    driver.quit();
	}

}
