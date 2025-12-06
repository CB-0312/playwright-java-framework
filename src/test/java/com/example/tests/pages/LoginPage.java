package com.example.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class LoginPage {
    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator loginBtn;

    public LoginPage(Page page) {
        this.page = page;
        // Selectors tuned for demoqa "Book Store Application" login page.
        this.usernameInput = page.locator("#userName");
        this.passwordInput = page.locator("#password");
        this.loginBtn = page.locator("#login");
    }

    @Step("Enter username: {0}")
    public LoginPage enterUsername(String username) {
        usernameInput.fill(username);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    @Step("Click Login")
    public void clickLogin() {
        loginBtn.click();
    }
}
