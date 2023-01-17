package com.excelr.automationpractise.PractiseExcelR;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise01 {
	
	@FindBy(name = "first_name")
	private WebElement firstName;
	
	@FindBy(name = "last_name")
	private WebElement lastName;
	
	@FindBy(name = "business_name")
	private WebElement businessName;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(id = "number")
	private WebElement result;
	
	@FindBy(xpath= "//button[text() = 'Submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//strong[text()=' Thank you!']")
	private WebElement verify;
	
	public static void main(String[] args) {
		WebDriverManager.firefoxdriver();
		WebDriverManager.chromedriver();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo");

		Practise01 homePage = PageFactory.initElements(driver, Practise01.class);
		homePage.firstName.sendKeys("xyz");
		homePage.lastName.sendKeys("abc");
		homePage.businessName.sendKeys("axbycz");
		homePage.email.sendKeys("xaybzc@gmail.com");
		
		WebElement numb1 = driver.findElement(By.id("numb1"));
		String no1 = numb1.getText();
		int NO1=Integer.parseInt(no1);
		System.out.println(NO1);
		
		WebElement numb2 = driver.findElement(By.id("numb2"));
		String no2 = numb2.getText();
		int NO2=Integer.parseInt(no2);
		System.out.println(NO2);
		
		int sum = NO1 + NO2 ;
		String res = String.valueOf(sum);
		System.out.println(res);
		
		homePage.result.sendKeys(res);
		homePage.submit.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String verification = homePage.verify.getText();
		System.out.println(verification);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
	
}
