// test/pageobjects/forms.page.js
const Page = require('./page');

class FormsPage extends Page {
  get screenTitle() { return $('~Forms Screen'); }
}

module.exports = new FormsPage();