package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearchbox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("gmail");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//descendant::div[@class='wM6W7d']"));
		Thread.sleep(3000);
		System.out.println(list.size());
		Thread.sleep(3000);
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("gmail account")) {
				list.get(i).click();
			break;
			}
		}
	}
}
