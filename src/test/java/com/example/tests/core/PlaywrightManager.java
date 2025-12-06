package com.example.tests.core;

import com.microsoft.playwright.*;
import com.example.framework.utils.ConfigReader;

public class PlaywrightManager {
    private static final ThreadLocal<Playwright> PLAYWRIGHT = new ThreadLocal<>();
    private static final ThreadLocal<Browser> BROWSER = new ThreadLocal<>();
    private static final ThreadLocal<Page> PAGE = new ThreadLocal<>();

    public static void initBrowser() {
        String browserName = System.getProperty("browser", ConfigReader.get("browser"));
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", ConfigReader.get("headless")));

        Playwright playwright = Playwright.create();
        PLAYWRIGHT.set(playwright);

        BrowserType.LaunchOptions opts = new BrowserType.LaunchOptions().setHeadless(headless);
        Browser browser;
        switch (browserName.toLowerCase()) {
            case "firefox":
                browser = playwright.firefox().launch(opts);
                break;
            case "webkit":
                browser = playwright.webkit().launch(opts);
                break;
            case "chromium":
            default:
                browser = playwright.chromium().launch(opts);
                break;
        }
        BROWSER.set(browser);
        PAGE.set(browser.newPage());
    }

    public static Page page() {
        return PAGE.get();
    }

    public static void closeBrowser() {
        Page p = PAGE.get();
        if (p != null) p.close();

        Browser b = BROWSER.get();
        if (b != null) b.close();

        Playwright pwt = PLAYWRIGHT.get();
        if (pwt != null) pwt.close();

        PAGE.remove();
        BROWSER.remove();
        PLAYWRIGHT.remove();
    }
}
