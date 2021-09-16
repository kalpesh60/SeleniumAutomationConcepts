package com.selenium;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsInSelenium {
	
	public void implicitWait() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();   
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //it will not stop for 20 sec when element find it will execute    
		// Implicit Wait for 20 seconds  
		driver.get("https://www.ebay.com/");  
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(element).build().perform();
		//Thread.sleep(3000);
		driver.findElement(By.linkText("Apple")).click();
	}
	
	public void explicitWait() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");  
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(element).build().perform();
		// Implicit Wait for 10 seconds
		WebDriverWait wait = new WebDriverWait(driver, 10);   //it will not stop for 10 sec when element find it will execute
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple"))).click();
//		driver.findElement(By.linkText("Apple")).click();
	}
	
	public void fluentWait() {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.linkText("Electronics"));
		action.moveToElement(element).build().perform();
		// it will check for the element on the web page at every 5 seconds for the maximum time of 20 seconds
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)                         
	            .withTimeout(Duration.ofSeconds(20))                        
	            .pollingEvery(Duration.ofSeconds(3))            
	            .ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Apple"))).click();
	}

	public static void main(String[] args) throws InterruptedException {
		WaitsInSelenium wait = new WaitsInSelenium();
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Implicit wait\n 2.Explicit wait\n 3.Fluent wait\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	wait.implicitWait();
			break;
		case 2: wait.explicitWait();
			break;
		case 3: wait.fluentWait();
			break;	
		}

	}

}
