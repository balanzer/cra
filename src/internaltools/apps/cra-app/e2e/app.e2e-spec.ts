import { CraAppPage } from './app.po';

describe('cra-app App', () => {
  let page: CraAppPage;

  beforeEach(() => {
    page = new CraAppPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
