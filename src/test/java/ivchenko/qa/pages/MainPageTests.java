package ivchenko.qa.pages;

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
			description = "#1. Verify all needed elements are displayed on the page. Positive.")
	public void verifyElementsDisplayedTest() throws Exception{
			mainPage.verifyAllElementsAreDisplayed();
	}


	@Test(priority = 3,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "#2. Verify validation on correct data and proceding on the next page. Positive.")
	public void validationOnCorrectDataTest() throws Exception{
		mainPage.validationOnCorrectData();
	}

	@Test(priority = 1,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "#3. Verify after click on Come In button website error message appears. Negative.")
	public void verifyValidationOnEmptyFieldsTest() throws Exception{
		mainPage.validationOnEmptyFields();
	}

	@Test(priority = 2,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "#4. Verify situation if user enter valid email but haven't entered a password. Negative.")
	public void verifyValidationOnValidEmailAndEmptyPasswordTest() throws Exception{
		mainPage.validationOnValidEmailAndEmptyPassword();
	}

	@Test(priority = 2,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "#5. Verify situation if user entered incorrect email and any password. Negative.")
	public void verifyValidationOnIncorrectEmailPasswordTest() throws Exception{
		mainPage.validationOnIncorrectEmailField();
	}


	@Test(priority = 3,
			alwaysRun = true,
			groups = "MainPageTests",
			description = "#6. Verify situation when user entered valid email and incorrect password. Negative.")
	public void verifyValidEmailAndIncorrectPasswordTest() throws Exception{
		mainPage.validationOnValidEmailAndIncorrectPassword();
	}
}
