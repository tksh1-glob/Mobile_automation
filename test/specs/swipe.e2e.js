const HomePage = require('../pageobjects/home.page');
const SwipePage = require('../pageobjects/swipe.page');

describe('Swipe de tarjetas', () => {

  beforeEach(async () => {
    await driver.activateApp('com.wdiodemoapp');
    await HomePage.goToSwipe();
  });

  it('debe ocultar la tarjeta anterior al hacer swipe a la derecha', async () => {
    const primeraTarjeta = SwipePage.card(0);
    await primeraTarjeta.waitForDisplayed();

    await SwipePage.swipeRight();

    await expect(primeraTarjeta).not.toBeDisplayed();
  });

  it('debe dejar visible solo la última tarjeta tras varios swipes', async () => {
    for (let i = 0; i < 5; i++) { // ajusta el número según cuántas tarjetas tenga la app
      await SwipePage.swipeRight();
    }

    await expect(SwipePage.lastCard).toBeDisplayed();
  });

  it('debe encontrar el texto "You found me!!!" al hacer swipe vertical', async () => {
    let encontrado = false;

    for (let i = 0; i < 10 && !encontrado; i++) {
      encontrado = await SwipePage.foundMeText.isDisplayed().catch(() => false);
      if (!encontrado) {
        await SwipePage.swipeUp();
      }
    }

    await expect(SwipePage.foundMeText).toBeDisplayed();
  });

});