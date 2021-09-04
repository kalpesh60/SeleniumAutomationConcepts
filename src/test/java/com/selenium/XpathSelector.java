package com.selenium;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathSelector {
	
	public static void FacebookElements() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[starts-with(@id,'u_0_2')]")).click();
		Thread.sleep(3000);
//		*Basic Xpath
//		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("ABCD");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("lkfjf");
//		*By contains()
		driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("9897687856");
//		driver.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("Agdhdh1234@");
		driver.findElement(By.xpath("//*[contains(@name,'reg_passwd__')]")).sendKeys("Agdhdh1234@");
//		*By and operator and or operator
		driver.findElement(By.xpath("//select[@name='birthday_day' and @id='day']")).sendKeys("16");
		driver.findElement(By.xpath("//select[@name='birthday_month' or @id='month']")).sendKeys("May");
		driver.findElement(By.xpath("//select[@name='birthday_year' or @id='year']")).sendKeys("2019");
//		*By Starts With
		driver.findElement(By.xpath("//input[starts-with(@name,'firstn')]")).sendKeys("ABCDE");
	}
	
	public static void HindustanCopperElements() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://hindustancopper.com/ITIApplication/Registration");
		System.out.println(driver.getTitle());
//		*Basic Xpath
		driver.findElement(By.xpath("//input[@id='strCandidateFName']")).sendKeys("Ajay");
		driver.findElement(By.xpath("//input[@name='strCandidateMName']")).sendKeys("Suhas");
		driver.findElement(By.xpath("//input[@id='strCandidateLName']")).sendKeys("Ghule");
//		*By contains()
		driver.findElement(By.xpath("//input[contains(@name,'strMotherName')]")).sendKeys("Ganga");
		driver.findElement(By.xpath("//input[contains(@name,'strFatherName')]")).sendKeys("Suhas");
//		*By and operator and or operator
		driver.findElement(By.xpath("//input[@id='strMobileNumber' and @name='strMobileNumber']")).sendKeys("1234563456");
		driver.findElement(By.xpath("//input[@id='dtDOB' or @name='MobileNumber']")).sendKeys("12-3-1998");
		driver.findElement(By.xpath("//input[@id='strPANNo' or @name='strPANNo']")).sendKeys("QWED123333");
//		*By Starts With
		driver.findElement(By.xpath("//input[starts-with(@id,'strEm')]")).sendKeys("kalaal@89gmail.com");
		driver.findElement(By.xpath("//input[starts-with(@name,'strAlter')]")).sendKeys("lkksk49@hshd.com");
		driver.findElement(By.xpath("//input[starts-with(@id,'strAadharNo')]")).sendKeys("123234567654");
		
		Thread.sleep(3000);
		driver.close();
		}
	
	public static void SpotifyElements() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spotify.com/in-en/signup/");
		System.out.println(driver.getTitle());
//		*Basic Xpath
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kalsksk50@gmail.com");
		driver.findElement(By.xpath("//input[@name='confirm']")).sendKeys("kalsksk50@gmail.com");
//		*By contains()
		driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[contains(@id,'displayname')]")).sendKeys("Cool");
//		*By and operator and or operator
		driver.findElement(By.xpath("//input[@id='year' and @placeholder='YYYY']")).sendKeys("1994");
		driver.findElement(By.xpath("//select[@id='month' or @inputmode='MM']")).sendKeys("June");
		driver.findElement(By.xpath("//input[@id='day' or @name='day']")).sendKeys("10");
		Thread.sleep(4000);
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Facebook\n 2.HindustanCopper\n 3.Spotify\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	FacebookElements();
			break;
		case 2: HindustanCopperElements();
			break;
		case 3: SpotifyElements();
			break;
		}
	}
}

