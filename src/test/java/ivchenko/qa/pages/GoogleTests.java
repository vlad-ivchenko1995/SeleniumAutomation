package ivchenko.qa.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class GoogleTests extends TestBase {

	private MainPage mainPage;

	@Parameters({ "path" })
	@BeforeMethod
	public void testInit(@Optional("") String path) {
		// Load the page in the browser
		webDriver.get(websiteUrl);
		mainPage = PageFactory.initElements(webDriver, MainPage.class);
	}
	
	/*@Test( description = "TestRail Test")
	public void testrailFirst() throws Exception{
		JSONObject json = (JSONObject) testrail.sendGet("get_case/642");
		System.out.println(json.get("title"));
		assert webDriver
				.findElement(By.tagName("body"))
				.getText()
				.contains("Transactionss");
	}*/

//	@Test(description = "Move to Employee List")
//	public void employeeListTest() throws Exception{
//		mainPage.login()
//				.goToEmployeePage()
//				.listEmployee();
//	}

//	@Features("Employee Page")
//	@Parameters({"firstName","lastName","email","phone","pin","employeeType"})
//	@Test(description = "Add New Employee Simple")
//	public void addNewEmployeeSimple(@Optional("")String firstName,
//									@Optional("")String lastName,
//									@Optional("")String email,
//									@Optional("")String phone,
//									@Optional("")String pin,
//									@Optional("")String employeeType) throws Exception{
//		mainPage.login("", "")
//				.goToEmployeePage()
//				.listEmployee()
//				.addUserSimple(firstName, lastName, email, pin, employeeType);
//	}

//	@Features("Employee Page")
//	@Parameters({"firstName","lastName","email","phone","pin","employeeType",
//				"checkbox","employeeCode","jobCodes"})
//	@Test(description = "Add New Employee Complex")
//	public void addNewEmployeeComplex(@Optional("")String firstName,
//									  @Optional("")String lastName,
//									  @Optional("")String email,
//									  @Optional("5554443322")String phone,
//									  @Optional("")String pin,
//									  @Optional("")String employeeType,
//									  @Optional("")Boolean seeAllTickets,
//									  @Optional("")String employeeCode,
//									  @Optional("")String jobCode) throws Exception{
//		mainPage.login("", "")
//				.goToEmployeePage()
//				.listEmployee()
//				.addUser(firstName,lastName,email,phone,pin,employeeType,seeAllTickets,employeeCode,jobCode);
//	}
	
}
