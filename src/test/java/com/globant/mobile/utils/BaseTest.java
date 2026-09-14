package com.globant.mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/";
    private static final String DEVICE_NAME = "emulator-5554";
    private static final String APP_PATH = "C:/Users/gustavo.cabrera/Downloads/android.wdio.native.app.v2.2.0.apk";
    protected static final String APP_PACKAGE = "com.wdiodemoapp";
    private static final String APP_ACTIVITY = "com.wdiodemoapp.MainActivity";

    // Una sesión por clase de test (como un worker de wdio por spec file), no por
    // método: crear/reinstalar la app en cada @Test sobrecargaba el emulador.
    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(DEVICE_NAME)
                .setApp(APP_PATH)
                .setAppPackage(APP_PACKAGE)
                .setAppActivity(APP_ACTIVITY)
                .setNoReset(false);

        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
