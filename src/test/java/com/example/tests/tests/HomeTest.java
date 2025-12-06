package com.example.tests.tests;

import com.example.tests.base.BaseTest;
import com.example.tests.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(description = "Verify home page loads and header visible")
    public void verifyHomeLoads() {
        HomePage home = new HomePage(page);
        Assert.assertTrue(home.getTitle().toLowerCase().contains("tools") || home.isHeaderVisible(),
                "Home page seems not loaded properly");
    }
}
