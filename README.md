# UP42 - API test automation using RestAssured 

This Framwork is built using Rest Assured, Java, Maven, TestNG.

****************************************************************************

How to run this framework?
> Please make sure you have Java and Maven installed in your system.

Clone this repository to your workspace.

1. Open pom.xml in your Java IDE as a maven project.
2. Refresh Maven/ download all dependencies.
3. Run the testng.xml file.

OR

Maven surefire plugin inside pom.xml is also configured to run this testng.xml file:
1. For this, Open Terminal in project folder where pom.xml is present and then run this command "mvn clean test"

******************************************************************************

Sensitive Data management:

In this project, sensitive data can be "Project_ID" and "Project_API_Key". This can be encrypted using git-crypt.
Since git-crypt needs separate installation, for now properties file containing this data is kept in .gitignore file to keep everything simple.

This data can also be seen in console logs, which can further be masked using logback library and some masking patterns over it.

******************************************************************************

Reports:

Default reports from TestNG can be referred in following project paths:
1. If testng.xml is run directly from an IDE: "test-output" folder -> "emailable-report.html"
2. If it is run via terminal using "mvn clean test" command: target -> surefire-reports -> "emailable-report.html"


******************************************************************************

Below mentioned improvements were not done because of time crunch but would be good to have:

1. Enable data driven tests using @DataProvider and data can be fetched from an Excel sheet
2. Better reporting tools(like ExtentReports) can be added.
3. ThreadLocal can be introduced to run tests in Parallel if they grow in number
4. Direct JSON payloads can be stored and utilities for modify them run-time can be added.
5. More Enums and levels of abstractions can be introduced depending upon Test requirements.
