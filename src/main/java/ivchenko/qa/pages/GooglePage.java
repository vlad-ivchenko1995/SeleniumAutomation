package ivchenko.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GooglePage extends Page {

	//WebElements
	
	@FindBy(id = "gsr")
	private WebElement googleFrame;

	public GooglePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gsr")));
	}

	//Methods
	// @Step
//	public GooglePage verifyGooglePageDisplayed() throws Exception{
//		Assert.assertEquals(true, googleFrame.isDisplayed());
//		screenshot.capturePageScreenshot();
//		return this;
//	}

}
