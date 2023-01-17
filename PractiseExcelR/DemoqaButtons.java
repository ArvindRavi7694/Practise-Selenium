package com.excelr.automationpractise.PractiseExcelR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaButtons {

	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;

	@FindBy(xpath = "//span[text()='Buttons']")
	private WebElement buttons;
	
	@FindBy(id = "doubleClickBtn")
	private WebElement doubleClickButton;
	
	@FindBy(id = "rightClickBtn")
	private WebElement rightClickButton;
	
	@FindBy(xpath = "//button[normalize-space()='Click Me']")
	private WebElement singleClickButton;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("https://demoqa.com/");
		
		DemoqaButtons dB = PageFactory.initElements(driver, DemoqaButtons.class);
		
		js.executeScript("arguments[0].scrollIntoView()", dB.elements);
		dB.elements.click();
		
		js.executeScript("arguments[0].scrollIntoView()", dB.buttons);
		dB.buttons.click();
		
		new Actions(driver).doubleClick(dB.doubleClickButton).perform();
		
		js.executeScript("arguments[0].scrollIntoView()", dB.singleClickButton);
		new Actions(driver).contextClick(dB.rightClickButton).perform();
		dB.singleClickButton.click();
		
		driver.quit();
	}
}
