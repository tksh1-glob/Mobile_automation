package com.globant.mobile.tests;

import com.globant.mobile.screens.DragScreen;
import com.globant.mobile.screens.FormsScreen;
import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.screens.SwipeScreen;
import com.globant.mobile.screens.WebviewScreen;
import com.globant.mobile.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {

    private HomeScreen homeScreen;
    private LoginScreen loginScreen;
    private FormsScreen formsScreen;
    private SwipeScreen swipeScreen;
    private WebviewScreen webviewScreen;
    private DragScreen dragScreen;

    @BeforeMethod
    public void initScreens() {
        homeScreen = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        formsScreen = new FormsScreen(driver);
        swipeScreen = new SwipeScreen(driver);
        webviewScreen = new WebviewScreen(driver);
        dragScreen = new DragScreen(driver);

        // activateApp solo trae la app a primer plano, no la reinicia en Home,
        // así que forzamos la navegación a Home explícitamente.
        driver.activateApp(APP_PACKAGE);
        homeScreen.goToHome();
        Assert.assertTrue(homeScreen.isScreenDisplayed(), "La Home screen debería estar visible como precondición");
    }

    @Test
    public void debeMostrarCorrectamenteLaSeccionLogin() {
        homeScreen.goToLogin();
        Assert.assertTrue(loginScreen.isScreenDisplayed());
        Assert.assertTrue(loginScreen.isEmailInputDisplayed());
        Assert.assertTrue(loginScreen.isPasswordInputDisplayed());
        Assert.assertTrue(loginScreen.isLoginButtonDisplayed());
    }

    @Test
    public void debeMostrarCorrectamenteLaSeccionForms() {
        homeScreen.goToForms();
        Assert.assertTrue(formsScreen.isScreenDisplayed());
    }

    @Test
    public void debeMostrarCorrectamenteLaSeccionSwipe() {
        homeScreen.goToSwipe();
        Assert.assertTrue(swipeScreen.isScreenDisplayed());
    }

    @Test
    public void debeMostrarCorrectamenteLaSeccionWebview() {
        homeScreen.goToWebview();
        Assert.assertTrue(webviewScreen.isScreenDisplayed());
    }

    @Test
    public void debeMostrarCorrectamenteLaSeccionDrag() {
        homeScreen.goToDrag();
        Assert.assertTrue(dragScreen.isScreenDisplayed());
        Assert.assertTrue(dragScreen.isFirstDraggableDisplayed());
    }
}
