const Page = require('./page');

class HomePage extends Page {
  get screenTitle() { return $('~Home-screen'); }
  get homeTab() { return $('~Home'); }
  get loginTab() { return $('~Login'); }
  get formsTab() { return $('~Forms'); }
  get swipeTab() { return $('~Swipe'); }
  get dragTab() { return $('~Drag'); }
  get webviewTab() { return $('~Webview'); }

  async goToHome() { await this.waitAndClick('~Home'); }
  async goToLogin() { await this.waitAndClick('~Login'); }
  async goToForms() { await this.waitAndClick('~Forms'); }
  async goToSwipe() { await this.waitAndClick('~Swipe'); }
  async goToDrag() { await this.waitAndClick('~Drag'); }
  async goToWebview() { await this.waitAndClick('~Webview'); }
}

module.exports = new HomePage();