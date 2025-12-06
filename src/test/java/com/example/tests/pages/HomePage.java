package com.example.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class HomePage {
    private final Page page;
    private final Locator header;

    public HomePage(Page page) {
        this.page = page;
        this.header = page.locator("header");
    }

    @Step("Get page title")
    public String getTitle() {
        return page.title();
    }

    @Step("Is header visible")
    public boolean isHeaderVisible() {
        try {
            return header.isVisible();
        } catch (Exception e) {
            return false;
        }
    }
}
