package ivchenko.qa.pages;

import io.qameta.allure.Step;
import ivchenko.qa.keywords.Screenshot;
import ivchenko.qa.util.Browser;
import ivchenko.qa.util.PropertyLoader;
import ivchenko.qa.webdriver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase extends TestListenerAdapter{

	protected WebDriver webDriver;
	protected String gridHubUrl;
	protected String websiteUrl;
	protected Browser browser;
	private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
//	protected APIClient testrail;

	@BeforeClass
	public void init() {
		websiteUrl = PropertyLoader.loadProperty("site.url");
		gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

//		String username = PropertyLoader.loadProperty("user.username");
//		String password = PropertyLoader.loadProperty("user.password");

		webDriver = WebDriverFactory.getInstance(gridHubUrl, browser);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

		EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
		webDriver = driver;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		if (webDriver != null) {
			webDriver.quit();
		}
	}


	@Step("Test-NG Listener")
	@Override
	public void onTestFailure(ITestResult testResult) {
		System.out.println("-- Failure Handler --");
		setScreenshot(testResult);
        postTestResult(testResult);
	}
	

	public void setScreenshot(ITestResult result) {
			Screenshot screenshot = new Screenshot(webDriver);
			screenshot.capturePageScreenshot(result.getTestName());
	}
	
	public void postTestResult(ITestResult result){
		Map data = new HashMap();
		data.put("status_id", new Integer(1)); // Failed Status
		data.put("comment", "This test worked fine!");
//		JSONObject r = null;
//		try {
//			r = (JSONObject) testrail.sendPost("add_result_for_case/20/591", data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (APIException e) {
//			e.printStackTrace();
//		}
//		System.out.println(r.toString());
//	}
}
}
