# Selenium Cucumber Login Automation

This Maven project automates a web login scenario using the Page Object Model (POM), Selenium WebDriver, JUnit 5, and Cucumber.

## Project Structure

- `pom.xml` - Maven project configuration with Selenium, WebDriverManager, JUnit 5, Cucumber, and Commons IO dependencies.
- `src/main/java/pages/LoginPage.java` - Page Object class that encapsulates login page actions and web element interactions.
- `src/test/java/base/TestBase.java` - Base class that configures WebDriver and screenshot capture.
- `src/test/java/stepdefinitions/Hooks.java` - Cucumber hooks that initialize WebDriver and take screenshots when scenarios fail.
- `src/test/java/stepdefinitions/LoginStepDefinitions.java` - Cucumber step definitions for the login scenario.
- `src/test/java/stepdefinitions/CucumberRunnerTest.java` - Cucumber runner class to execute feature files.
- `src/test/java/stepdefinitions/LoginStepTest.java` - JUnit test class that exercises the login flow directly.
- `src/test/resources/features/login.feature` - Cucumber feature file describing the login scenario.

## How to run

From the project root, execute:

```bash
mvn test
```

This will:
- compile the project
- run the JUnit and Cucumber tests
- generate Cucumber HTML reports
- capture screenshots for failed Cucumber scenarios

## Output locations

- `target/cucumber-reports/index.html` - generated Cucumber HTML report
- `target/screenshots/` - screenshots saved for failed scenarios

## Notes

- WebDriverManager is used to automatically manage the ChromeDriver binary.
- `TestBase` configures the `WebDriver` and provides a `captureScreenshot()` helper.
- The login scenario is defined in `login.feature` and uses the `LoginPage` POM class to interact with the browser.
- If a scenario fails, `Hooks` will capture a screenshot and store it under `target/screenshots/`.
