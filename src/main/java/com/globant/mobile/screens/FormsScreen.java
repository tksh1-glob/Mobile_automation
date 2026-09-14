package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FormsScreen extends BaseScreen {

    private final By screenTitle = AppiumBy.accessibilityId("Forms-screen");

    public FormsScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isScreenDisplayed() {
        return isWebElementInDom(screenTitle, 10);
    }
}
