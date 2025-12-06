# Playwright Java Framework (Maven + TestNG + POM)

This repository is a starter automation framework using **Playwright for Java**, **Maven**, **TestNG**, **Page Object Model**, and **Allure**.

## Quickstart

1. Install JDK 11+ and Maven.
2. Install Playwright browsers (required once):
   ```bash
   mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
   ```
   or if you have Node:
   ```bash
   npx playwright install
   ```
3. Run tests:
   ```bash
   mvn test
   ```
4. To view Allure reports (if Allure CLI installed):
   ```bash
   allure serve target/allure-results
   ```

## Project structure

```
playwright-java-framework/
├─ pom.xml
├─ testng.xml
├─ src/
│  ├─ main/java/com/example/framework/utils/ConfigReader.java
│  └─ test/java/com/example/tests/...
└─ .github/workflows/maven-test.yml
```

## Notes
- Update `src/test/resources/config.properties` to change `base.url`, `browser`, etc.
- Selectors in Page Objects are tuned for demo sites; adapt as needed for your target site (demoqa.com, saucedemo.com, the-internet.herokuapp.com).
