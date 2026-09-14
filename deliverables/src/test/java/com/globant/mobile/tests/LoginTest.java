package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.screens.SignupScreen;
import com.globant.mobile.utils.BaseTest;
import com.globant.mobile.utils.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void debeIniciarSesionExitosamenteConUnUsuarioValido() {
        String email = RandomDataGenerator.generarEmailRandom();
        String password = "Password123!";

        HomeScreen homeScreen = new HomeScreen(driver);
        LoginScreen loginScreen = new LoginScreen(driver);
        SignupScreen signupScreen = new SignupScreen(driver);

        driver.activateApp(APP_PACKAGE);
        homeScreen.goToLogin();
        loginScreen.goToSignUp();
        signupScreen.signUp(email, password);

        Assert.assertTrue(signupScreen.isSuccessAlertDisplayed());
        signupScreen.dismissSuccessAlert();

        // El signup no navega automáticamente de vuelta a Login.
        homeScreen.goToLogin();
        loginScreen.login(email, password);

        Assert.assertTrue(loginScreen.isSuccessAlertDisplayed());
        loginScreen.dismissSuccessAlert();
    }
}
