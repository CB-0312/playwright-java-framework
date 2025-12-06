package com.example.tests.base;

import com.example.tests.core.PlaywrightManager;
import com.example.framework.utils.ConfigReader;
import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {
    protected Page page;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        // global setup if needed
    }

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional String browser) {
        if (browser != null && !browser.isEmpty()) {
            System.setProperty("browser", browser);
        }
        PlaywrightManager.initBrowser();
        this.page = PlaywrightManager.page();
        String base = ConfigReader.get("base.url");
        page.navigate(base);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                byte[] screenshot = page.screenshot();
                Allure.addAttachment("screenshot-" + result.getName(), new ByteArrayInputStream(screenshot));
                // Save to target/screenshots as well
                Files.createDirectories(Paths.get("target", "screenshots"));
                Files.write(Paths.get("target", "screenshots", result.getName() + ".png"), screenshot);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        PlaywrightManager.closeBrowser();
    }
}
