package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {

    private final By screenTitle = AppiumBy.accessibilityId("Home-screen");
    private final By homeTab = AppiumBy.accessibilityId("Home");
    private final By loginTab = AppiumBy.accessibilityId("Login");
    private final By formsTab = AppiumBy.accessibilityId("Forms");
    private final By swipeTab = AppiumBy.accessibilityId("Swipe");
    private final By dragTab = AppiumBy.accessibilityId("Drag");
    private final By webviewTab = AppiumBy.accessibilityId("Webview");

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isScreenDisplayed() {
        return isWebElementInDom(screenTitle, 10);
    }

    public void goToHome() {
        waitAndClick(homeTab);
    }

    public void goToLogin() {
        waitAndClick(loginTab);
    }

    public void goToForms() {
        waitAndClick(formsTab);
    }

    public void goToSwipe() {
        waitAndClick(swipeTab);
    }

    public void goToDrag() {
        waitAndClick(dragTab);
    }

    public void goToWebview() {
        waitAndClick(webviewTab);
    }
}
