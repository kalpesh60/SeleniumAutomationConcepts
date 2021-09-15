package com.selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {
	
	public static void enterText_intoDisabledTextbox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("C:\\Users\\kalpe\\OneDrive\\Desktop\\JS Ex\\JS.html");
		
		//Typecast the driver object to JavascriptExecutor interface type
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		
		//enter "admin" in first textbox using javascript
		js.executeScript("document.getElementById('t1').value='admin'");
		Thread.sleep(2000);
		
		//clear the value in second textbox using javascript
		js.executeScript("document.getElementById('t2').value=''");
		
		//enter "manager" in second textbox using javascript
		js.executeScript("document.getElementById('t2').value='manager'");
		
		//change the second text box to button type using Javascript
		js.executeScript("document.getElementById('t2').type='button'");
	}
	
	public static void scrollUpandDown() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumhq.org/download");
		
		//typecasting driver object to JavascriptExecutor interface type
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 1; i < 4; i++) {
		
		//scroll down on the webpage
		js.executeScript("window.scrollBy(0, 1000)");
		Thread.sleep(3000);
		}
		for (int i = 1; i < 4; i++) {
		
		//scroll up on the webpage
		js.executeScript("window.scrollBy(0, -500)");
		Thread.sleep(3000);
	}
	}
	
	public static void scrollUpandDowntospecificElementonWebpage () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumhq.org/download");
		
		//click on the close icon of the yellow color background pop up 
		//driver.findElement(By.id("close")).click();
		
		// find the Applitools element on the webpage
		WebElement ele = driver.findElement(By.xpath("//img[contains(@src,'applitools')]"));
		//ele.click();
		// get the X-coordinate and store in a variable
		int x = ele.getLocation().getX();
		
		// get the Y-coordinate and store in a variable
		int y = ele.getLocation().getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Scroll to Applitools element’s x and y coordinate
		js.executeScript("window.scrollBy("+x+", "+y+")");
		System.out.println(x + y);
		Thread.sleep(3000);
	}
	
	public static void navigatetoBottomofthePage () throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.seleniumhq.org/download/");
		
		//select an element which is present at the bottom of the page
		WebElement element = driver.findElement(By.linkText("About Selenium"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is :"+x + " and Y coordinate is :"+ y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
		Thread.sleep(3000);
		element.click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.EnterText_intoDisabledTextbox\n 2.ScrollUpandDown\n 3.ScrollUpandDowntospecificElementonWebpage\n 4.navigatetoBottomofthePage\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	enterText_intoDisabledTextbox();
			break;
		case 2: scrollUpandDown();
			break;
		case 3: scrollUpandDowntospecificElementonWebpage();
			break;
		case 4: navigatetoBottomofthePage();
		break;	
		}
	}

}
