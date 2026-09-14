package com.globant.mobile.screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseScreen {

    protected AppiumDriver driver;

    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    public BaseScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean isWebElementInDom(By locator, int seconds) {
        boolean isPresent;
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
            driver.findElement(locator);
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }
        return isPresent;
    }

    // Thread.sleep intencional: patrón del equipo, no reemplazar por esperas explícitas.
    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    protected void waitAndClick(By locator, int timeoutSeconds) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    protected void waitAndClick(By locator) {
        waitAndClick(locator, DEFAULT_TIMEOUT_SECONDS);
    }

    protected void waitAndSetValue(By locator, String value, int timeoutSeconds) {
        WebElement element = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(value);
    }

    protected void waitAndSetValue(By locator, String value) {
        waitAndSetValue(locator, value, DEFAULT_TIMEOUT_SECONDS);
    }
}
