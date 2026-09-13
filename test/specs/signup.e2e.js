const HomePage = require('../pageobjects/home.page');
const LoginPage = require('../pageobjects/login.page');
const SignupPage = require('../pageobjects/signup.page');
const { generarEmailRandom } = require('../helpers/testData');

describe('Registro (Sign Up)', () => {

  beforeEach(async () => {
    await driver.activateApp('com.wdiodemoapp');
    await HomePage.goToLogin();
  });

  it('debe registrar un usuario nuevo exitosamente', async () => {
    const email = generarEmailRandom();
    const password = 'Password123!';

    await LoginPage.goToSignUp();
    await SignupPage.signUp(email, password);

    await expect(SignupPage.successAlertMessage).toBeDisplayed();
  });

});