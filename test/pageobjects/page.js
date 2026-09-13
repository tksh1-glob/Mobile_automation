class Page {
  async waitAndClick(selector, timeout = 10000) {
    const element = await $(selector);
    await element.waitForDisplayed({ timeout });
    await element.click();
  }

  async waitAndSetValue(selector, value, timeout = 10000) {
    const element = await $(selector);
    await element.waitForDisplayed({ timeout });
    await element.setValue(value);
  }
}

module.exports = Page;