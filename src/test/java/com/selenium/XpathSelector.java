package com.selenium;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public static void XpathAxes() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/kalpe/eclipse-workspace/SeleniumConcepts/Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		System.out.println(driver.getTitle());
		 //self 
	     String text1 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/self::a")).getText();
	     String text2 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/self::*")).getText();
	     System.out.println(text1);
	     System.out.println(text2);
	     
	     //parent      
	     String text3 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/parent::td")).getText();
	     String text4 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/parent::*")).getText();
	     System.out.println(text3);
	     System.out.println(text4);
	     //td[contains(text(),'28.60')]/parent::*
	     
	     //child 
	     String text5 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/parent::td/child::*")).getText();
	     String text6 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/parent::td/child::a")).getText();
	     System.out.println(text5);
	     System.out.println(text6);
	     
	     
	    //Ancestor
	     String text7 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/ancestor::tr")).getText();
	     String text8 = driver.findElement(By.xpath("//a[contains(text(),'Navoday Enterprises')]/ancestor::td")).getText();
	     System.out.println(text7);
	     System.out.println(text8);    
	     //a[contains(text(),'Navoday Enterprises')]/ancestor::html
	     //a[contains(text(),'Navoday Enterprises')]/ancestor::div[1]
	     //td[contains(text(),'28.60')]/ancestor::*
	     //td[contains(text(),'28.60')]/ancestor::tr
	     //td[contains(text(),'28.60')]/ancestor::div
	     
	     //Descendant
	     List<WebElement> element1 = driver.findElements(By.xpath("//a[contains(text(),'Navoday Enterprises')]/ancestor::tr/descendant::td"));
	     System.out.println(element1.size());
	     //td[contains(text(),'28.60')]/ancestor::tr/descendant::td
	     //td[contains(text(),'28.60')]/parent::tr/descendant::td
	     
	     
	     //Following
	     List<WebElement> element2 = driver.findElements(By.xpath("//a[contains(text(),'Navoday Enterprises')]/following::*"));
	     System.out.println(element2.size());
	     //a[contains(text(),'Navoday Enterprises')]/following::tr[3]

	     //Following-sibling
	     List<WebElement> element3 = driver.findElements(By.xpath("//a[contains(text(),'Navoday Enterprises')]/ancestor::tr/following-sibling::*"));
	     System.out.println(element3.size());

	     //Preceding
	     List<WebElement> element4 = driver.findElements(By.xpath("//a[contains(text(),'Navoday Enterprises')]/ancestor::tr/preceding::*"));
	     System.out.println(element4.size());

	     //Preceding-sibling
	     List<WebElement> element5 = driver.findElements(By.xpath("//a[contains(text(),'Navoday Enterprises')]/ancestor::tr/preceding-sibling::*"));
	     System.out.println(element5.size());
	     
	     Thread.sleep(3000);
	     driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println(" 1.Facebook\n 2.HindustanCopper\n 3.Spotify\n 4.XpathAxes\n");
		int choice = sc.nextInt();	
		switch (choice) {
		case 1:	FacebookElements();
			break;
		case 2: HindustanCopperElements();
			break;
		case 3: SpotifyElements();
			break;
		case 4: XpathAxes();
		break;	
		}
	}
}

