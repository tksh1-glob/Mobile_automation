// test/pageobjects/webview.page.js
const Page = require('./page');

class WebviewPage extends Page {
  get screenTitle() { return $('~Webview Screen'); }
}

module.exports = new WebviewPage();