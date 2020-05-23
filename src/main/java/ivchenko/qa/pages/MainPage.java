package ivchenko.qa.pages;

import io.qameta.allure.Step;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page {

	private GooglePage googlePage;


	//WebElements
	@FindBy(id = "cancelForm")
	@CacheLookup
	private WebElement cancelButton;

	@FindBy(id = "gsr")
	private WebElement googleFrame;

	@FindBy(id = "saveForm")
	@CacheLookup
	private WebElement saveButton;

	@FindBy(id = "form_testtask")
	@CacheLookup
	private WebElement testForm;

	@FindBy(id = "input_code")
	@CacheLookup
	private WebElement inputCodeField;

	@FindBy(id = "main_body")
	@CacheLookup
	private WebElement appFrame;

	@FindBy(xpath = "//*[contains(h2, 'SampleWebsite')]")
	@CacheLookup
	private WebElement textSampleWebsite;

	@FindBy(xpath = "//*[contains(text(), 'Made by Vladyslav Ivchenko')]")
	@CacheLookup
	private WebElement textFooter;
	private Object GooglePage;

	public MainPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	//Methods
	@Step
	public String getValidationMessage(){ WebElement notificationMessage = new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='input_field' and @id='input_code']")));
		System.out.println(notificationMessage.getAttribute("validationMessage"));
		return notificationMessage.getAttribute("validationMessage");
	}

	//Methods
	@Step
	public MainPage verifyAllElementsAreDisplayed(){

		Assert.assertEquals(true, appFrame.isDisplayed());
		Assert.assertEquals(true, saveButton.isDisplayed());
		Assert.assertEquals(true, testForm.isDisplayed());
		Assert.assertEquals(true, inputCodeField.isDisplayed());
		Assert.assertEquals(true, cancelButton.isDisplayed());
		Assert.assertEquals(true, textSampleWebsite.isDisplayed());
		Assert.assertEquals(true, textFooter.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage clickOnCancelButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cancelForm")));
		cancelButton.click();
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage clickOnOKButton(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("saveForm")));
		saveButton.click();
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnEmptyField(){
		saveButton.click();
		String valMes = getValidationMessage();
		Assert.assertEquals("Заполните это поле.", valMes );
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnMinLengthField(){
		inputCodeField.sendKeys("12");
		saveButton.click();
		String valMes = getValidationMessage();
		Assert.assertEquals("Минимально допустимое количество символов: 3. Длина текста сейчас: 2.", valMes );
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnMaxLengthField(){
		inputCodeField.sendKeys("1234567890123456789");
		WebElement input = webDriver.findElement(By.id("input_code"));
		Assert.assertEquals("1234567890", input.getAttribute("value"));
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnNumbersField(){
		inputCodeField.sendKeys("12345");
		saveButton.click();
		WebElement input = webDriver.findElement(By.id("input_code"));
		Assert.assertEquals("", input.getText());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnEnglishLettersField(){
		inputCodeField.sendKeys("test");
		saveButton.click();
		WebElement input = webDriver.findElement(By.id("input_code"));
		Assert.assertEquals("", input.getText());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnUkrainianLettersField(){
		inputCodeField.sendKeys("Україна");
		saveButton.click();
		WebElement input = webDriver.findElement(By.id("input_code"));
		Assert.assertEquals("", input.getText());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnNumbersWithSpacesField(){
		inputCodeField.sendKeys("  1 2 3   ");
		saveButton.click();
		WebElement input = webDriver.findElement(By.id("input_code"));
		Assert.assertEquals("", input.getText());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnSpacesField(){
		inputCodeField.sendKeys("     ");
		saveButton.click();
		WebElement input = webDriver.findElement(By.id("input_code"));
		Assert.assertEquals("", input.getText());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public GooglePage verifyGooglePageDisplayed() throws Exception{
		Assert.assertEquals(true, googleFrame.isDisplayed());
		screenshot.capturePageScreenshot();
		return googlePage;
	}
}
