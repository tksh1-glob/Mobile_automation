package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WebviewScreen extends BaseScreen {

    private final By screenTitle =
            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.webkit.WebView\")");

    public WebviewScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isScreenDisplayed() {
        return isWebElementInDom(screenTitle, 10);
    }
}
