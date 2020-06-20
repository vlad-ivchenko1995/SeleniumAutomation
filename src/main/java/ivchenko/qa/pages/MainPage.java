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

public class MainPage extends Page {

	//WebElements
	@FindBy(id = "inputEmail")
	@CacheLookup
	private WebElement emailInput;

	@FindBy(id = "inputPassword")
	private WebElement passwordInput;

	@FindBy(xpath = "//input[contains(@class, 'zak-pass-style-log error')]")
	private WebElement errorPasswordInput;

	@FindBy(xpath = "//input[@class='form-login-input error']")
	private WebElement errorEmailInput;

	@FindBy(xpath = "//input[@class='btn btn-success zak-log-btn']")
	@CacheLookup
	private WebElement comeInButton;

	@FindBy(xpath = "//*[text()='Перевірте адресу ел. пошти ']")
	@CacheLookup
	private WebElement verifyEmailText;

	@FindBy(xpath = "//*[text()='Введіть ел. пошту']")
	@CacheLookup
	private WebElement enterEmailText;

	@FindBy(xpath = "//*[text()='Введіть пароль']")
	@CacheLookup
	private WebElement enterPasswordText;

	@FindBy(xpath = "//*[text()='Неправильний пароль']")
	@CacheLookup
	private WebElement incorrectPasswordText;

	@FindBy(xpath = "//*[text()='Як почати брати участь у закупівлях']")
	@CacheLookup
	private WebElement headerAfterLoginPageText;

	public MainPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	//Methods
	@Step
	public MainPage verifyAllElementsAreDisplayed(){

		Assert.assertEquals(true, emailInput.isDisplayed());
		Assert.assertEquals(true, passwordInput.isDisplayed());
		Assert.assertEquals(true, comeInButton.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnCorrectData(){
		emailInput.sendKeys("zakupkitest@gmail.com");
		passwordInput.sendKeys("Password123!");
		comeInButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Як почати брати участь у закупівлях']")));
		Assert.assertTrue(headerAfterLoginPageText.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnEmptyFields(){
		comeInButton.click();
		Assert.assertTrue(enterEmailText.isDisplayed());
		Assert.assertTrue(errorEmailInput.isDisplayed());
		Assert.assertTrue(errorPasswordInput.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnValidEmailAndEmptyPassword(){
		emailInput.sendKeys("zakupkitest@gmail.com");
		comeInButton.click();
		Assert.assertTrue(errorPasswordInput.isDisplayed());
		Assert.assertTrue(enterPasswordText.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnIncorrectEmailField(){
		emailInput.sendKeys("zakupkitest22@gmail.com");
		passwordInput.sendKeys("Password123!");
		comeInButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='form-login-input error']")));
		Assert.assertTrue(errorEmailInput.isDisplayed());
		Assert.assertTrue(verifyEmailText.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}

	@Step
	public MainPage validationOnValidEmailAndIncorrectPassword(){
		emailInput.sendKeys("zakupkitest@gmail.com");
		passwordInput.sendKeys("Password12345!");
		comeInButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class, 'zak-pass-style-log error')]")));
		Assert.assertTrue(errorPasswordInput.isDisplayed());
		Assert.assertTrue(incorrectPasswordText.isDisplayed());
		screenshot.capturePageScreenshot();
		return this;
	}
}
