package com.selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IFrames {
	
	public void basicIframes() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/kalpe/OneDrive/Desktop/JS%20Ex/IFrames/page2.html");
		
		//using index of the frame - [ int value] [ index of frames starts with zero]
		driver.switchTo().frame(0);     //to switch on frame
		driver.findElement(By.id("t1")).sendKeys("a");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();  //to go on main page exit from iframe
		driver.findElement(By.id("t2")).sendKeys("b");
		Thread.sleep(3000);
		
		//using id attribute of the frame -string
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("c");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("d");
		Thread.sleep(3000);
		
		//using name attribute of the frame -string
		driver.switchTo().frame("n1");
		driver.findElement(By.id("t1")).sendKeys("e");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("f");
		Thread.sleep(3000);
		
		//using address of the frame -webelement
		WebElement f = driver.findElement(By.className("c1"));
		driver.switchTo().frame(f);
		driver.findElement(By.id("t1")).sendKeys("g");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("h");
		Thread.sleep(3000);
		//driver.close();
	}
	
	public void nestedIframes() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1100)");
		Thread.sleep(3000);
		driver.switchTo().frame("frm1");          //By Frame id
		driver.findElement(By.xpath("//select[@id='course']")).sendKeys("Python");
		driver.findElement(By.xpath("//select[@id='selectnav2']")).sendKeys("Contact");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("main page");
		Thread.sleep(5000);
		driver.switchTo().frame("frm3");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Frame3 nested frame");
		Thread.sleep(5000);
		driver.switchTo().frame("frm1");   //Switch to nested Frame3 to Frame1
		driver.findElement(By.xpath("//select[@id='selectnav2']")).sendKeys("Contact");
		driver.switchTo().parentFrame();
		Thread.sleep(5000);
		
		driver.switchTo().frame("frm2");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Frame2");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Frame");
		driver.findElement(By.xpath("//input[@id='malerb']")).click();
		driver.findElement(By.xpath("//input[@id='englishchbx']")).click();
		driver.findElement(By.xpath("//input[@id='frenchchbx']")).click();
		Thread.sleep(5000);
		//driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		IFrames iframes = new IFrames();
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.basicIframes\n 2.nestedFrames\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	iframes.basicIframes();
			break;
		case 2: iframes.nestedIframes();
			break;
	}
		
	}
}
