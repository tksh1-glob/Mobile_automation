package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.HashMap;
import java.util.Map;

public class SwipeScreen extends BaseScreen {

    private final By screenTitle = AppiumBy.accessibilityId("Swipe-screen");
    private final By foundMeText =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"You found me\")");

    public SwipeScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isScreenDisplayed() {
        return isWebElementInDom(screenTitle, 10);
    }

    public By card(int index) {
        return AppiumBy.androidUIAutomator(
                "new UiSelector().resourceId(\"__CAROUSEL_ITEM_" + index + "__\")");
    }

    public By lastCard() {
        return card(5);
    }

    public boolean isCardDisplayed(By cardLocator) {
        return isWebElementInDom(cardLocator, 10);
    }

    public boolean isFoundMeTextDisplayed() {
        return isWebElementInDom(foundMeText, 2);
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        Map<String, Object> params = new HashMap<>();
        params.put("left", size.getWidth() * 0.1);
        params.put("top", size.getHeight() * 0.4);
        params.put("width", size.getWidth() * 0.8);
        params.put("height", size.getHeight() * 0.2);
        params.put("direction", "left");
        params.put("percent", 0.9);
        driver.executeScript("mobile: swipeGesture", params);
    }

    public void swipeUp() {
        Dimension size = driver.manage().window().getSize();
        Map<String, Object> params = new HashMap<>();
        params.put("left", size.getWidth() * 0.1);
        params.put("top", size.getHeight() * 0.2);
        params.put("width", size.getWidth() * 0.8);
        params.put("height", size.getHeight() * 0.6);
        params.put("direction", "up");
        params.put("percent", 0.9);
        driver.executeScript("mobile: swipeGesture", params);
    }
}
