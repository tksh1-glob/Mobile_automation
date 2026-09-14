const HomePage = require('../pageobjects/home.page');
const LoginPage = require('../pageobjects/login.page');
const FormsPage = require('../pageobjects/forms.page');
const SwipePage = require('../pageobjects/swipe.page');
const DragPage = require('../pageobjects/drag.page');
const WebviewPage = require('../pageobjects/webview.page');

describe('Navegación del menú inferior', () => {

  beforeEach(async () => {
    // activateApp solo trae la app a primer plano, no la reinicia en Home,
    // así que forzamos la navegación a Home explícitamente.
    await driver.activateApp('com.wdiodemoapp');
    await HomePage.goToHome();
    await expect(HomePage.screenTitle).toBeDisplayed();
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

  it('debe mostrar correctamente la sección Drag', async () => {
    await HomePage.goToDrag();
    await expect(DragPage.screenTitle).toBeDisplayed();
    await expect(DragPage.firstDraggable).toBeDisplayed();
  });

});