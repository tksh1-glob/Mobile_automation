const HomePage = require('../pageobjects/home.page');
const LoginPage = require('../pageobjects/login.page');
const SignupPage = require('../pageobjects/signup.page');
const { generarEmailRandom } = require('../helpers/testData');

describe('Inicio de sesión (Login)', () => {

  it('debe iniciar sesión exitosamente con un usuario válido', async () => {
    const email = generarEmailRandom();
    const password = 'Password123!';

    await driver.activateApp('com.wdiodemoapp');
    await HomePage.goToLogin();
    await LoginPage.goToSignUp();
    await SignupPage.signUp(email, password);

    await expect(SignupPage.successAlertMessage).toBeDisplayed();
    await SignupPage.dismissSuccessAlert();

    await LoginPage.login(email, password);

    await expect(LoginPage.successAlertMessage).toBeDisplayed();
    await LoginPage.dismissSuccessAlert();
  });

});