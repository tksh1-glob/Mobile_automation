const Page = require('./page');

class LoginPage extends Page {
  get emailInput() { return $('~input-email'); }
  get passwordInput() { return $('~input-password'); }
  get loginButton() { return $('~button-LOGIN'); }
  get signUpLink() { return $('android=new UiSelector().text("Sign up")'); }

  get successAlertMessage() { return $('android=new UiSelector().textContains("You are logged in")'); }
  get successAlertOkButton() { return $('android=new UiSelector().resourceId("android:id/button1")'); }

  async login(email, password) {
    await this.waitAndSetValue('~input-email', email);
    await this.waitAndSetValue('~input-password', password);
    await this.waitAndClick('~button-LOGIN');
  }

  async goToSignUp() {
    await this.waitAndClick('android=new UiSelector().text("Sign up")');
  }

  async dismissSuccessAlert() {
    await this.waitAndClick('android=new UiSelector().resourceId("android:id/button1")');
  }
}

module.exports = new LoginPage();