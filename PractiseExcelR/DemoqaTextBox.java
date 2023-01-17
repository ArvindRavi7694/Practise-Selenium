package com.excelr.automationpractise.PractiseExcelR;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaTextBox {

	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;
	
	@FindBy(xpath = "//span[text()='Text Box']")
	private WebElement textBox;
	
	@FindBy(id = "userName")
	private WebElement userName;
	
	@FindBy(id = "userEmail")
	private WebElement email;
	
	@FindBy(id = "currentAddress")
	private WebElement currentAddress;
	
	@FindBy(id = "permanentAddress")
	private WebElement permanentAddress;
	
	@FindBy(id = "submit")
	private WebElement submit;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		DemoqaTextBox dTB = PageFactory.initElements(driver, DemoqaTextBox.class);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dTB.elements.click();
		dTB.textBox.click();
		dTB.userName.sendKeys("Popeye");
		dTB.email.sendKeys("popeye@gmail.com");
		dTB.currentAddress.sendKeys("GREENLAND");
		dTB.permanentAddress.sendKeys("FRANCE");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,350)");
		
		dTB.submit.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		List<WebElement> allOutput = driver.findElements(By.id("output"));
		
		for(WebElement all : allOutput) {
			all.getText();
			System.out.println(all.getText());
		}
		
		driver.quit();
		
	}
}
