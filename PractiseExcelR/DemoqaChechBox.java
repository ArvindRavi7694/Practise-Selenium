package com.excelr.automationpractise.PractiseExcelR;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoqaChechBox {
	
	@FindBy(xpath = "//h5[normalize-space()='Elements']")
	private WebElement elements;
	
	@FindBy(xpath = "//span[text()='Check Box']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//button[@class='rct-option rct-option-expand-all']")
	private WebElement expand;
	
	@FindBy(xpath = "//button[@class='rct-option rct-option-collapse-all']")
	private WebElement collapse;
	
	@FindBy(xpath = "//span[text()='Notes']")
	private WebElement notesCheckBox;
	
	@FindBy(xpath = "//span[text()='Commands']")
	private WebElement commandsCheckBox;
	
	@FindBy(xpath = "//span[text()='React']")
	private WebElement reactCheckBox;
	
	@FindBy(xpath = "//span[text()='Angular']")
	private WebElement angularCheckBox;
	
	@FindBy(xpath = "//span[text()='Veu']")
	private WebElement veuCheckBox;
	
	@FindBy(xpath = "//span[text()='Public']")
	private WebElement publicCheckBox;
	
	@FindBy(xpath = "//span[text()='Private']")
	private WebElement privateCheckBox;
	
	@FindBy(xpath = "//span[text()='Classified']")
	private WebElement classifiedCheckBox;
	
	@FindBy(xpath = "//span[text()='General']")
	private WebElement generalCheckBox;
	
	@FindBy(xpath = "//span[text()='Word File.doc']")
	private WebElement wordFileCheckBox;
	
	@FindBy(xpath = "//span[text()='Excel File.doc']")
	private WebElement excelFileCheckBox;
	
	@FindBy(xpath = "//span[text()='Home']")
	private WebElement homeCheckBox;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		DemoqaChechBox dCM = PageFactory.initElements(driver,DemoqaChechBox.class);
		
		js.executeScript("arguments[0].scrollIntoView()", dCM.elements);
		
		dCM.elements.click();
		dCM.checkBox.click();
		dCM.expand.click();
		dCM.notesCheckBox.click();
		dCM.commandsCheckBox.click();
		
		js.executeScript("arguments[0].scrollIntoView()", dCM.classifiedCheckBox);
		
		dCM.reactCheckBox.click();
		dCM.angularCheckBox.click();
		dCM.veuCheckBox.click();
		dCM.publicCheckBox.click();
		dCM.privateCheckBox.click();
		dCM.classifiedCheckBox.click();
		dCM.generalCheckBox.click();
		dCM.wordFileCheckBox.click();
		dCM.excelFileCheckBox.click();
		
		js.executeScript("arguments[0].scrollIntoView()", dCM.collapse);
		
		dCM.collapse.click();
//		dCM.homeCheckBox.click();
		
		System.out.println("All CheckBox is Marked");
		driver.quit();
		
	}

}
