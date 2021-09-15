package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/");
		Actions action = new Actions(driver);
		
		//moveToElement
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Resource')]"));
		action.moveToElement(element).build().perform();
		Thread.sleep(3000);
		//ContextClick   right click
		action.contextClick().perform();
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i < 4; i++) {
		
		//scroll down on the webpage
		js.executeScript("window.scrollBy(0, 1800)");
		Thread.sleep(3000);
		}
		
		//double click
		//WebElement element1 = driver.findElement(By.xpath("//p[contains(text(),'Browsers')]"));
		//Thread.sleep(3000);
		//action.doubleClick(element1).build().perform();
		
		//sendKeys
		WebElement element3 = driver.findElement(By.xpath("//input[@placeholder='Your email address']"));
		action.sendKeys(element3,"Asdff").perform();
		
	}

}
