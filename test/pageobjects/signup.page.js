const Page = require('./page');

class SignupPage extends Page {
  get emailInput() { return $('~input-email'); }
  get passwordInput() { return $('~input-password'); }
  get repeatPasswordInput() { return $('~input-repeat-password'); }
  get submitButton() { return $('~button-SIGN UP'); }

  get successAlertMessage() { return $('android=new UiSelector().textContains("successfully signed up")'); }
  get successAlertOkButton() { return $('android=new UiSelector().resourceId("android:id/button1")'); }

  async signUp(email, password) {
    await this.waitAndSetValue('~input-email', email);
    await this.waitAndSetValue('~input-password', password);
    await this.waitAndSetValue('~input-repeat-password', password);
    await this.waitAndClick('~button-SIGN UP');
  }

  async dismissSuccessAlert() {
    await this.waitAndClick('android=new UiSelector().resourceId("android:id/button1")');
  }
}

module.exports = new SignupPage();