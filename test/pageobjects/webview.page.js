// test/pageobjects/webview.page.js
const Page = require('./page');

class WebviewPage extends Page {
  get screenTitle() { return $('android=new UiSelector().className("android.webkit.WebView")'); }
}

module.exports = new WebviewPage();