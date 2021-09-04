package com.selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectors {
	
	public static void FacebookElements() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[contains(text(),'Create New')]")).click();
		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input[id='u_0_j_LU']")).sendKeys("Ajay");
		driver.findElement(By.cssSelector("input[id='password_step_input']")).sendKeys("Acd1234@");
//		direct can use by #
//		driver.findElement(By.cssSelector("#password_step_input")).sendKeys("Acd1234@");
		
		driver.findElement(By.cssSelector("label[class='_58mt']")).click();
//		direct can use by .
//		driver.findElement(By.cssSelector("._58mt")).click();
		
		driver.findElement(By.cssSelector("select[class='_9407 _5dba _9hk6 _8esg'][id='day']")).sendKeys("16");
		driver.findElement(By.cssSelector("#month")).sendKeys("May");
		driver.findElement(By.cssSelector("select[class='_9407 _5dba _9hk6 _8esg'][id='year']")).sendKeys("2019");
//		driver.findElement(By.cssSelector("input[type='textbox']"));
//		Thread.sleep(3000);
//		driver.close();
	}
	
	public static void MonsterElements() {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.monsterindia.com/seeker/registration");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("input[type='text']")).sendKeys("Kalpesh");
		driver.findElement(By.cssSelector("input[class='input email-autocomplete-input']")).sendKeys("Kalpesh60@gmail.com");
		driver.findElement(By.cssSelector("input[class='input pass']")).sendKeys("Ajvb!233");
		//driver.findElement(By.cssSelector(".input")).sendKeys("2345678899");
		
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Facebook\n 2.Monster\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	FacebookElements();
			break;
		case 2: MonsterElements();
			break;
	}
	}
}
