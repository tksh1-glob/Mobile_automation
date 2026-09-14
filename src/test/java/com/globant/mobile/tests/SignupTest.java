package com.globant.mobile.tests;

import com.globant.mobile.screens.HomeScreen;
import com.globant.mobile.screens.LoginScreen;
import com.globant.mobile.screens.SignupScreen;
import com.globant.mobile.utils.BaseTest;
import com.globant.mobile.utils.RandomDataGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    private LoginScreen loginScreen;
    private SignupScreen signupScreen;

    @BeforeMethod
    public void goToLoginSection() {
        HomeScreen homeScreen = new HomeScreen(driver);
        loginScreen = new LoginScreen(driver);
        signupScreen = new SignupScreen(driver);
        driver.activateApp(APP_PACKAGE);
        homeScreen.goToLogin();
    }

    @Test
    public void debeRegistrarUnUsuarioNuevoExitosamente() {
        String email = RandomDataGenerator.generarEmailRandom();
        String password = "Password123!";

        loginScreen.goToSignUp();
        signupScreen.signUp(email, password);

        Assert.assertTrue(signupScreen.isSuccessAlertDisplayed());
    }
}
