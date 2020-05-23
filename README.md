#Ivchenko Automation
This is project structure for Selenium Web Automation. 

As a base, it has implementation of different profiles and including RemoteWebDriver, 
Screenshot implementation and more.

##Reporting
As reporting project uses Allure 2.13.3.

**In order to run the project simple execute**
`mvn test`
This will execution the browser and get the results.

**In order to create reports, execute:**
`mvn site`

Report will be in /target/site/allure-mvn-plugin/index.html **( only firefox)**

**You can use the following command in cmd or terminal to run the tests "allure serve /Users/macbook/Downloads/QA/Ivchenko_TestTask/target/allure-results" **