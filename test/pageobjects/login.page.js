const Page = require('./page');

class LoginPage extends Page {
  get screenTitle() { return $('~Login-screen'); }
  get loginTabButton() { return $('~button-login-container'); }
  get emailInput() { return $('~input-email'); }
  get passwordInput() { return $('~input-password'); }
  get loginButton() { return $('~button-LOGIN'); }
  get signUpLink() { return $('~button-sign-up-container'); }

  get successAlertMessage() { return $('android=new UiSelector().textContains("You are logged in")'); }
  get successAlertOkButton() { return $('android=new UiSelector().resourceId("android:id/button1")'); }

  async login(email, password) {
    // La sección Login recuerda el último sub-tab visto (Login/Sign up),
    // así que forzamos el sub-tab de Login antes de rellenar el formulario.
    await this.waitAndClick('~button-login-container');
    await this.waitAndSetValue('~input-email', email);
    await this.waitAndSetValue('~input-password', password);
    await this.waitAndClick('~button-LOGIN');
  }

  async goToSignUp() {
    await this.waitAndClick('~button-sign-up-container');
  }

  async dismissSuccessAlert() {
    await this.waitAndClick('android=new UiSelector().resourceId("android:id/button1")');
  }
}

module.exports = new LoginPage();