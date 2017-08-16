import { browser, by, element } from 'protractor';

export class CraAppPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-root h4')).getText();
  }
}
