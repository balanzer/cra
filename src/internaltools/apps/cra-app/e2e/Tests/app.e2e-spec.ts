import { CraAppPage } from '../PageObject/app.po';

describe('cra-app App', () => {
  let page: CraAppPage;

  beforeEach(() => {
    page = new CraAppPage();
  });

  it('should display HEADER message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg.toLowerCase()).toEqual('header'))
      .then(done, done.fail);
  });
});
