const Page = require('./page');

class SwipePage extends Page {
  get screenTitle() { return $('~Swipe-screen'); }
  get foundMeText() { return $('android=new UiSelector().textContains("You found me")'); }

  card(index) {
    return $(`android=new UiSelector().resourceId("__CAROUSEL_ITEM_${index}__")`);
  }

  get lastCard() { return this.card(5); }

  async swipeRight() {
    const { width, height } = await driver.getWindowSize();
    await driver.execute('mobile: swipeGesture', {
      left: width * 0.1, top: height * 0.4, width: width * 0.8, height: height * 0.2,
      direction: 'left',
      percent: 0.9
    });
  }

  async swipeUp() {
    const { width, height } = await driver.getWindowSize();
    await driver.execute('mobile: swipeGesture', {
      left: width * 0.1, top: height * 0.2, width: width * 0.8, height: height * 0.6,
      direction: 'up',
      percent: 0.9
    });
  }
}

module.exports = new SwipePage();