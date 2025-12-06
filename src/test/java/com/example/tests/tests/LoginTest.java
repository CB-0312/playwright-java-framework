package com.example.tests.tests;

import com.example.tests.base.BaseTest;
import com.example.tests.pages.HomePage;
import com.example.tests.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Sample login flow (DemoQA Book Store App). Uses placeholder creds for demo.")
    public void sampleLoginTest() {
        LoginPage login = new LoginPage(page);
        // DemoQA requires registration; these are placeholders — adapt with real test account if needed.
        login.enterUsername("testuser").enterPassword("Password123").clickLogin();

        HomePage home = new HomePage(page);
        Assert.assertTrue(home.getTitle() != null && !home.getTitle().isEmpty(), "Title should be present");
    }
}
