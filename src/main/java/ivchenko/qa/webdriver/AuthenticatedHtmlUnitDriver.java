package ivchenko.qa.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.DefaultCredentialsProvider;
import com.gargoylesoftware.htmlunit.WebClient;

/*
 * Class extending HtmlUnitDriver to support BASIC authentication
 */
public class AuthenticatedHtmlUnitDriver extends HtmlUnitDriver {
//	private static String USERNAME;
//	private static String PASSWORD;

	private AuthenticatedHtmlUnitDriver() {
	}

	public static WebDriver create() {
		return new AuthenticatedHtmlUnitDriver();
	}

	@Override
	protected WebClient newWebClient(BrowserVersion browserVersion) {
		WebClient client = super.newWebClient(browserVersion);
		DefaultCredentialsProvider provider = new DefaultCredentialsProvider();
		client.setCredentialsProvider(provider);
		return client;
	}
}
