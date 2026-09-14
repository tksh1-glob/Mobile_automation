package com.globant.mobile.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginScreen extends BaseScreen {

    private final By screenTitle = AppiumBy.accessibilityId("Login-screen");
    private final By loginTabButton = AppiumBy.accessibilityId("button-login-container");
    private final By signUpLink = AppiumBy.accessibilityId("button-sign-up-container");
    private final By emailInput = AppiumBy.accessibilityId("input-email");
    private final By passwordInput = AppiumBy.accessibilityId("input-password");
    private final By loginButton = AppiumBy.accessibilityId("button-LOGIN");
    private final By successAlertMessage =
            AppiumBy.androidUIAutomator("new UiSelector().textContains(\"You are logged in\")");
    private final By successAlertOkButton = By.id("android:id/button1");

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public boolean isScreenDisplayed() {
        return isWebElementInDom(screenTitle, 10);
    }

    public boolean isEmailInputDisplayed() {
        return isWebElementInDom(emailInput, 10);
    }

    public boolean isPasswordInputDisplayed() {
        return isWebElementInDom(passwordInput, 10);
    }

    public boolean isLoginButtonDisplayed() {
        return isWebElementInDom(loginButton, 10);
    }

    public boolean isSuccessAlertDisplayed() {
        return isWebElementInDom(successAlertMessage, 10);
    }

    public void login(String email, String password) {
        // La sección Login recuerda el último sub-tab visto (Login/Sign up).
        waitAndClick(loginTabButton);
        waitAndSetValue(emailInput, email);
        waitAndSetValue(passwordInput, password);
        waitAndClick(loginButton);
    }

    public void goToSignUp() {
        waitAndClick(signUpLink);
    }

    public void dismissSuccessAlert() {
        waitAndClick(successAlertOkButton);
    }
}
