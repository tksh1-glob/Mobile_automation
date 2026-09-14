package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SignupScreen extends BaseScreen {

    private final By emailInput = AppiumBy.accessibilityId("input-email");
    private final By passwordInput = AppiumBy.accessibilityId("input-password");
    private final By repeatPasswordInput = AppiumBy.accessibilityId("input-repeat-password");
    private final By submitButton = AppiumBy.accessibilityId("button-SIGN UP");
    private final By successAlertMessage =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"successfully signed up\")");
    private final By successAlertOkButton = By.id("android:id/button1");

    public SignupScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isSuccessAlertDisplayed() {
        return isWebElementInDom(successAlertMessage, 10);
    }

    public void signUp(String email, String password) {
        waitAndSetValue(emailInput, email);
        waitAndSetValue(passwordInput, password);
        waitAndSetValue(repeatPasswordInput, password);
        waitAndClick(submitButton);
    }

    public void dismissSuccessAlert() {
        waitAndClick(successAlertOkButton);
    }
}
