package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class DragScreen extends BaseScreen {

    private final By screenTitle = AppiumBy.accessibilityId("Drag-drop-screen");
    private final By firstDraggable = AppiumBy.accessibilityId("drag-l1");

    public DragScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isScreenDisplayed() {
        return isWebElementInDom(screenTitle, 10);
    }

    public boolean isFirstDraggableDisplayed() {
        return isWebElementInDom(firstDraggable, 10);
    }
}
