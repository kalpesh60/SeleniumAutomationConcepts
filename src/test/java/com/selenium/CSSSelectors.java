package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectors {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Ajay");
		//driver.findElement(By.cssSelector("input[id='password_step_input']")).sendKeys("Acd1234@");
		//direct can use by #
		driver.findElement(By.cssSelector("#password_step_input")).sendKeys("Acd1234@");
		
//		driver.findElement(By.cssSelector("label[class='_58mt']")).click();
//		//direct can use by .
		driver.findElement(By.cssSelector("._58mt")).click();
//		driver.findElement(By.cssSelector("input[value='textbox'][id='1_Y3'][class='_58mt']"));
//		driver.findElement(By.cssSelector("input[type='textbox']"));
		Thread.sleep(3000);
		driver.close();
	}

}
