package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.SwipeScreen;
import com.globant.mobile.utils.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    private SwipeScreen swipeScreen;

    @BeforeMethod
    public void goToSwipeSection() {
        HomeScreen homeScreen = new HomeScreen(driver);
        swipeScreen = new SwipeScreen(driver);
        driver.activateApp(APP_PACKAGE);
        homeScreen.goToSwipe();
    }

    // Los 3 tests comparten sesión/estado del carrusel (igual que el spec JS
    // original bajo Mocha), y TestNG no garantiza orden de declaración como
    // Mocha sí hace con it(); se fija el orden explícitamente con priority.
    @Test(priority = 1)
    public void debeOcultarLaTarjetaAnteriorAlHacerSwipeALaDerecha() {
        By primeraTarjeta = swipeScreen.card(0);
        Assert.assertTrue(swipeScreen.isCardDisplayed(primeraTarjeta));

        swipeScreen.swipeRight();

        Assert.assertFalse(swipeScreen.isCardDisplayed(primeraTarjeta));
    }

    @Test(priority = 2)
    public void debeDejarVisibleSoloLaUltimaTarjetaTrasVariosSwipes() {
        for (int i = 0; i < 5; i++) {
            swipeScreen.swipeRight();
        }
        Assert.assertTrue(swipeScreen.isCardDisplayed(swipeScreen.lastCard()));
    }

    @Test(priority = 3)
    public void debeEncontrarElTextoYouFoundMeAlHacerSwipeVertical() {
        boolean encontrado = false;
        for (int i = 0; i < 10 && !encontrado; i++) {
            encontrado = swipeScreen.isFoundMeTextDisplayed();
            if (!encontrado) {
                swipeScreen.swipeUp();
            }
        }
        Assert.assertTrue(swipeScreen.isFoundMeTextDisplayed());
    }
}
