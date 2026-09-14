// test/pageobjects/forms.page.js
const Page = require('./page');

class FormsPage extends Page {
  get screenTitle() { return $('~Forms-screen'); }
  get formTitle() { return $('android=new UiSelector().text("Form components")'); }
}

module.exports = new FormsPage();