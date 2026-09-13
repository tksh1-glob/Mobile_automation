const HomePage = require('../pageobjects/home.page');
const LoginPage = require('../pageobjects/login.page');
const FormsPage = require('../pageobjects/forms.page');
const SwipePage = require('../pageobjects/swipe.page');
const WebviewPage = require('../pageobjects/webview.page');

describe('Navegación del menú inferior', () => {

  beforeEach(async () => {
    // Nos aseguramos de arrancar siempre desde Home
    await driver.activateApp('com.wdiodemoapp');
  });

  it('debe mostrar correctamente la sección Login', async () => {
    await HomePage.goToLogin();
    await expect(LoginPage.screenTitle).toBeDisplayed();
    await expect(LoginPage.emailInput).toBeDisplayed();
    await expect(LoginPage.passwordInput).toBeDisplayed();
    await expect(LoginPage.loginButton).toBeDisplayed();
  });

  it('debe mostrar correctamente la sección Forms', async () => {
    await HomePage.goToForms();
    await expect(FormsPage.screenTitle).toBeDisplayed();
  });

  it('debe mostrar correctamente la sección Swipe', async () => {
    await HomePage.goToSwipe();
    await expect(SwipePage.screenTitle).toBeDisplayed();
  });

  it('debe mostrar correctamente la sección Webview', async () => {
    await HomePage.goToWebview();
    await expect(WebviewPage.screenTitle).toBeDisplayed();
  });

});