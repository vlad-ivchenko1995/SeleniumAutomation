package ivchenko.qa.pages;

import io.qameta.allure.Features;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase {

	MainPage mainPage;

	@BeforeMethod
	public void testInit() {
		// Load the page in the browser

		webDriver = new ChromeDriver();
		webDriver.get(websiteUrl);
		mainPage = PageFactory.initElements(webDriver, MainPage.class);
	}

	@Test(priority = 3,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify all needed elements are displayed on the page. Positive.")
	public void verifyElementsDisplayedTest() throws Exception{
			mainPage.verifyAllElementsAreDisplayed();
	}


	@Test(priority = 3,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify after click on Cancel button Google website is opened. Positive.")
	public void verifyCancelButtonTest() throws Exception{
		mainPage.clickOnCancelButton();
		mainPage.verifyGooglePageDisplayed();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify after click on OK button website notification appears. Negative.")
	public void verifyValidationOnEmptyFieldTest() throws Exception{
		mainPage.validationOnEmptyField();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify after sending value that is lefter than 3 symbols and clicking" +
			" on OK button website notification appears. Negative.")
	public void verifyValidationOnMinLengthFieldTest() throws Exception{
		mainPage.validationOnMinLengthField();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify after sending value that is more than 10 symbols other symbols are cropped. Negative.")
	public void verifyValidationOnMaxLengthFieldTest() throws Exception{
		mainPage.validationOnMaxLengthField();
	}


	@Test(priority = 3,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify sending of the correct value of numbers. Positive.")
	public void verifySendingNumbersInTextFieldTest() throws Exception{
		mainPage.validationOnNumbersField();
	}

	@Test(priority = 3,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify sending of the correct value with English letters. Positive.")
	public void verifySendingEnglishLettersInTextFieldTest() throws Exception{
		mainPage.validationOnEnglishLettersField();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify sending of the correct value with Ukrainian letters. Positive.")
	public void verifySendingUkrainianLettersInTextFieldTest() throws Exception{
		mainPage.validationOnUkrainianLettersField();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",description = "Verify sending correct value with spaces at the beginning and at the end. Positive.")
	public void verifySendingNumbersWithSpacesInTextFieldTest() throws Exception{
		mainPage.validationOnNumbersWithSpacesField();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "Verify after sending value that is lefter than 3 symbols and clicking" +
			" on OK button website notification appears. Negative.")
	public void verifySendingSpacesInTextFieldTest() throws Exception{
		mainPage.validationOnSpacesField();
	}

//	@AfterTest
//	public void tearDown() throws Exception {
//		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		webDriver.quit();
//	}
}
